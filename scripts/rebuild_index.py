#!/usr/bin/env python3
"""
rebuild_index.py

Regenerates the Index table in the top-level README.md by scanning every
solutions/<pattern>/<num>-<slug>/README.md for its metadata block. Only the
content between the <!-- INDEX:START --> / <!-- INDEX:END --> markers in
README.md is replaced -- everything else in the file (title, Patterns
section, any notes) is left untouched.

Usage:
    python3 scripts/rebuild_index.py
"""

import re
import sys
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parent.parent
SOLUTIONS_DIR = REPO_ROOT / "solutions"
TOP_README = REPO_ROOT / "README.md"

START_MARKER = "<!-- INDEX:START -->"
END_MARKER = "<!-- INDEX:END -->"

METADATA_RE = re.compile(
    r"^<!--\s*\n"
    r"number:\s*(?P<number>\S+)\s*\n"
    r"title:\s*(?P<title>.+?)\s*\n"
    r"pattern:\s*(?P<pattern>\S+)\s*\n"
    r"difficulty:\s*(?P<difficulty>\S+)\s*\n"
    r"languages:\s*(?P<languages>.+?)\s*\n"
    r"slug:\s*(?P<slug>\S+)\s*\n"
    r"last_reviewed:\s*(?P<last_reviewed>\S+)\s*\n"
    r"-->",
    re.MULTILINE,
)

# Friendly display names for patterns whose table label differs from the
# folder slug (e.g. "arrays-hashing" is shown as just "Hashing", matching
# the existing table). Anything not listed here falls back to a generic
# hyphen-to-Title-Case conversion -- add entries as you need to override it.
PATTERN_DISPLAY = {
    "arrays-hashing": "Hashing",
}


def display_pattern(slug: str) -> str:
    return PATTERN_DISPLAY.get(slug, slug.replace("-", " ").title())


def leetcode_url(slug: str) -> str:
    return f"https://leetcode.com/problems/{slug}/description/"


def collect_entries():
    entries = []
    for readme in sorted(SOLUTIONS_DIR.glob("*/*/README.md")):
        text = readme.read_text()
        m = METADATA_RE.match(text)
        if not m:
            print(f"  ! No metadata block, skipping: {readme.relative_to(REPO_ROOT)}")
            continue
        folder_name = readme.parent.name
        entries.append({
            "number": m.group("number"),
            "title": m.group("title"),
            "pattern": m.group("pattern"),
            "difficulty": m.group("difficulty"),
            "languages": m.group("languages"),
            "last_reviewed": m.group("last_reviewed"),
            "slug": m.group("slug"),
            "link": f"solutions/{m.group('pattern')}/{folder_name}/",
        })
    return entries


def build_table(entries) -> str:
    # Chronological by last_reviewed (== the solve date until you update it
    # after revisiting a problem); same-date entries broken by number.
    entries.sort(key=lambda e: (e["last_reviewed"], int(e["number"])))

    header = (
        "| # | Problem | Pattern | Language(s) | Difficulty | Last Reviewed | Link |\n"
        "|---|---------|---------|----------|------------|----------------|------|\n"
    )

    rows = []
    for e in entries:
        num_display = str(int(e["number"]))
        problem_cell = f"[{e['title']}]({leetcode_url(e['slug'])})"
        link_cell = f"[Solution]({e['link']})"
        rows.append(
            f"| {num_display} | {problem_cell} | {display_pattern(e['pattern'])} | "
            f"{e['languages']} | {e['difficulty']} | {e['last_reviewed']} | {link_cell} |"
        )

    return header + "\n".join(rows) + "\n"


def main():
    if not TOP_README.exists():
        sys.exit(f"Error: {TOP_README} not found.")

    content = TOP_README.read_text()
    if START_MARKER not in content or END_MARKER not in content:
        sys.exit(
            f"Error: could not find {START_MARKER} / {END_MARKER} in README.md.\n"
            "Add them around your Index table first."
        )

    entries = collect_entries()
    if not entries:
        sys.exit("No problem folders with metadata found -- nothing to build.")

    new_block = f"{START_MARKER}\n{build_table(entries)}{END_MARKER}"
    pattern = re.compile(re.escape(START_MARKER) + r".*?" + re.escape(END_MARKER), re.DOTALL)
    new_content = pattern.sub(lambda _: new_block, content)

    TOP_README.write_text(new_content)
    print(f"Rebuilt index with {len(entries)} problems.")


if __name__ == "__main__":
    main()
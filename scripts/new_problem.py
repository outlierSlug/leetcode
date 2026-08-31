#!/usr/bin/env python3
"""
new_problem.py

Creates a new LeetCode problem folder with a README file and a blank solution file.
Default language is Java.

Usage: 
    python3 scripts/new_problem.py \
        --num 1\
        --title "Two Sum" \
        --pattern arrays-hashing \
        --difficulty Easy
        [--lang Java,Python] \
        [--slug two-sum] \
"""

import argparse
import re
import sys
from datetime import date
from pathlib import Path

PATTERNS = [
    "arrays-hashing", "two-pointers", "sliding-window", "stack",
    "binary-search", "linked-list", "trees", "heap-priority-queue",
    "backtracking", "graphs", "math", "matrix", "dp-1d", "dp-2d", "greedy",
    "intervals", "trie", "union-find", "bit-manipulation",
]

DIFFICULTIES = ["Easy", "Medium", "Hard"]

REPO_ROOT = Path(__file__).resolve().parent.parent
SOLUTIONS_DIR = REPO_ROOT / "solutions"

# Maps a case-insensitive user-supplied language name to its canonical
# display name, filename, and blank stub content.
LANG_ALIASES = {
    "java": "Java",
    "python": "Python", "py": "Python",
    "c++": "C++", "cpp": "C++",
    "typescript": "TypeScript", "ts": "TypeScript",
}

LANG_STUBS = {
    "Java": ("Solution.java", ""),
    "Python": ("solution.py", ""),
    "C++": ("solution.cc", ""),
    "TypeScript": ("solution.ts", ""),
}


def slugify(title: str) -> str:
    s = title.lower().strip()
    s = re.sub(r"[^a-z0-9]+", "-", s)
    return s.strip("-")


def leetcode_url(slug: str) -> str:
    return f"https://leetcode.com/problems/{slug}/description/"


def find_existing_folder(num_padded: str):
    """Return the path of an existing folder for this problem number,
    regardless of which pattern or slug it was created under, or None."""
    if not SOLUTIONS_DIR.exists():
        return None
    for match in SOLUTIONS_DIR.glob(f"*/{num_padded}-*"):
        if match.is_dir():
            return match
    return None


def normalize_pattern(raw: str) -> str:
    return raw.strip().lower()


def normalize_difficulty(raw: str) -> str:
    return raw.strip().capitalize()


def parse_languages(raw: str) -> list:
    langs = []
    for part in raw.split(","):
        key = part.strip().lower()
        if key not in LANG_ALIASES:
            valid = ", ".join(sorted(set(LANG_ALIASES.values())))
            sys.exit(f"Error: unrecognized language '{part.strip()}'. Valid options: {valid}")
        canonical = LANG_ALIASES[key]
        if canonical not in langs:
            langs.append(canonical)
    return langs


def readme_stub(num: str, title: str, slug: str, pattern: str,
                 difficulty: str, languages: list) -> str:
    today = date.today().isoformat()
    lang_str = ", ".join(languages)
    # The HTML comment block is invisible on GitHub but lets a future
    # index-rebuild script parse metadata without re-guessing it from
    # folder names.
    return f"""<!--
number: {num}
title: {title}
pattern: {pattern}
difficulty: {difficulty}
languages: {lang_str}
slug: {slug}
last_reviewed: {today}
-->
# {title}
[Problem Description]({leetcode_url(slug)})

Summary:

## Algorithm


## Complexity

| Time | Space |
|---|---|
| `O()`| `O()` |

## Notes

"""


def main():
    parser = argparse.ArgumentParser(description="Scaffold a new LeetCode problem folder.")
    parser.add_argument("--num", required=True, help="Problem number, e.g. 217")
    parser.add_argument("--title", required=True, help="Problem title, e.g. 'Contains Duplicate'")
    parser.add_argument("--pattern", required=True, type=normalize_pattern, choices=PATTERNS)
    parser.add_argument("--difficulty", required=True, type=normalize_difficulty, choices=DIFFICULTIES)
    parser.add_argument("--lang", default="Java", help="Comma-separated languages, e.g. Java,Python. Default: Java")
    parser.add_argument("--slug", default=None, help="LeetCode URL slug; auto-derived from title if omitted")
    args = parser.parse_args()

    if not args.num.isdigit():
        sys.exit(f"Error: --num must be numeric, got '{args.num}'")

    num_padded = args.num.zfill(4)
    slug = args.slug or slugify(args.title)

    if not slug:
        sys.exit(f"Error: title '{args.title}' produced an empty slug. Pass --slug explicitly.")

    folder_name = f"{num_padded}-{slug}"
    folder_path = SOLUTIONS_DIR / args.pattern / folder_name

    existing = find_existing_folder(num_padded)
    if existing is not None:
        sys.exit(f"Error: problem {num_padded} already exists at {existing.relative_to(REPO_ROOT)}")

    languages = parse_languages(args.lang)

    folder_path.mkdir(parents=True, exist_ok=False)

    created = []
    for lang in languages:
        filename, stub = LANG_STUBS[lang]
        (folder_path / filename).write_text(stub)
        created.append(filename)

    (folder_path / "README.md").write_text(
        readme_stub(num_padded, args.title, slug, args.pattern, args.difficulty, languages)
    )
    created.append("README.md")

    print(f"Created: {folder_path.relative_to(REPO_ROOT)}")
    for f in created:
        print(f"  - {f}")


if __name__ == "__main__":
    main()

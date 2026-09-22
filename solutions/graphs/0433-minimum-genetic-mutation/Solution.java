import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        // Ensure the endGene is a valid gene string
        if (!geneBank.contains(endGene)) return -1;
        
        char[] letters = {'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);

        // Standard BFS loop
        int mutations = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene)) {
                    return mutations;
                }

                // Test every character position in the current gene string.
                // Each string is 8 characters and each character has 3 mutation options.
                for (int pos = 0; pos < curr.length(); pos++) {
                    for (char letter : letters) {
                        if (curr.charAt(pos) == letter) continue;
                        String mutated = curr.substring(0, pos) + letter + curr.substring(pos + 1);
                        // If the gene bank contains the mutated string and it has not been checked,
                        // add it to the visited set and enqueue it
                        if (geneBank.contains(mutated) && !visited.contains(mutated)) {
                            visited.add(mutated);
                            queue.offer(mutated);
                        }
                    }
                }
            }
            mutations++;
        }
        return -1;
    }
}
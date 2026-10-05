class Solution {
    public int minOperations(int n) {
        int operations = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                // If lowest bit is 0, shift to the next bit.
                n >>= 1;
            } else if ((n & 3) == 3) {
                // If the lowest two bits are 11 (a run of 1s), adding 1 creates a carry, turning it
                // into a single 1 higher up.
                n++;
                operations++;
            } else {
                // If the lowest two bits are 01 (single 1), subtract it directly.
                n--;
                operations++;
            }
        }
        return operations;
    }
}
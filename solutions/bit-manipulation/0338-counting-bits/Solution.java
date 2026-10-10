class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        // bits[i] = bit count of i without its last bit (i >> 1, already computed) + its last bit (i & 1)
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
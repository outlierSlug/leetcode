class Solution {
    public int reverseBits(int n) {
        int result = 0;
        // Isolate bit at position 2^i and place it reversed in result
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            result |= (bit << 31 - i);
        }
        return result;
    }
}
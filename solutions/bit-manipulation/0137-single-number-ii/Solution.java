class Solution {
    public int singleNumber(int[] nums) {
        // Start with 0 (all bits off)
        int result = 0;
        // Look at each bit position (32 bits in an int)
        for (int i = 0; i < 32; i++) {
            int count = 0;
            
            // Increment count if bit i is set in num
            for (int num : nums) {
                count += (num >> i) & 1;
            }

            // If the count is not cleanly divisible by 3, that means the single number
            // has bit i set. Set that bit in result.
            if (count % 3 != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }
}
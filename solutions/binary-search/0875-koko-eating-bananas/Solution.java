class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // The range of k is from 1 to max(piles). Perform binary search over this range for k.
        int lo = 1;
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int hi = max;

        // For each k checked, check if it is a valid k and narrow the search space accordingly.
        while (lo < hi) {
            // Set k to be the midpoint between lo and hi
            int k = lo + (hi - lo) / 2;
            
            if (isValidK(k, piles, h)) {
                // If the current k is valid, bring the hi pointer down to k. This is now the largest valid minimum k.
                hi = k;
            } else {
                // If the current k fails, bring the lo pointer up to (k + 1), since we need a strictly higher rate of eating.
                lo = k + 1;
            }
        }
        // lo and hi will both point at the minimum valid k after binary search completes.
        return lo;

    }

    // Returns true if Koko can eat all the bananas at a rate of k per hour within h hours.
    private boolean isValidK(int k, int[] piles, int h) {
        int hours = 0;
        for (int pile : piles) {
            // It takes pile / k hours to eat one pile, rounded up. hours += Math.ceil((double) pile / k)
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
    }
}
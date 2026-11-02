class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];  // tallest bar strictly left of i
        int[] maxRight = new int [n];  // tallest bar strictly right of i

        // Fill both arrays in one pass: i sweeps left to right, j sweeps right to left.
        // Each wall is stored before including the current bar, so the maxima are exclusive.
        int leftWall = 0, rightWall = 0;
        for (int i = 0; i < n; i++) {
            int j = n - i - 1;
            maxLeft[i] = leftWall;
            maxRight[j] = rightWall;
            leftWall = Math.max(leftWall, height[i]);
            rightWall = Math.max(rightWall, height[j]);
        }

        // Water above i is bounded by the shorter of its two walls.
        // Clamp at 0: a bar taller than both walls holds no water.
        int result = 0;
        for (int i = 0; i < n; i++) {
            int potential = Math.min(maxLeft[i], maxRight[i]);
            result += Math.max(0, potential - height[i]);
        }

        return result;
    }
}
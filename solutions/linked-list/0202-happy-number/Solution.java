class Solution {
    public boolean isHappy(int n) {
        int slow = getSum(n);
        int fast = getSum(getSum(n));

        while (fast != 1 && slow != fast) {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }

        if (fast == 1) return true;
        return false;  // slow == fast
    }

    // Returns the sum of the squares of the digits of n.
    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}
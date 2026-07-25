class Solution {
    public int maxProduct(int n) {
        int max = -1;
        int secondMax = -1;

        while (n > 0) {
            int digit = n % 10;

            if (digit > max) {
                secondMax = max;
                max = digit;
            } else if (digit > secondMax) {
                secondMax = digit;
            }

            n /= 10;
        }

        return max * secondMax;
    }
}

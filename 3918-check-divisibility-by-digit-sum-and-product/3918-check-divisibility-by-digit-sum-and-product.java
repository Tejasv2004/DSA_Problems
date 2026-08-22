class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prd = 1;
        int x = n;

        while (x > 0) {
            int dig = x % 10;
            sum += dig;
            prd *= dig;
            x /= 10;
        }

        return n % (sum + prd) == 0;
    }
}
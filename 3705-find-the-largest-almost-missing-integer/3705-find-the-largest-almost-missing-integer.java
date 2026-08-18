class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if (k == n) {
            int ans = nums[0];
            for (int x : nums) ans = Math.max(ans, x);
            return ans;
        }

        int[] cnt = new int[51];
        for (int x : nums) cnt[x]++;

        if (k == 1) {
            int ans = -1;
            for (int x : nums) {
                if (cnt[x] == 1) ans = Math.max(ans, x);
            }
            return ans;
        }

        int ans = -1;
        if (cnt[nums[0]] == 1) ans = nums[0];
        if (cnt[nums[n - 1]] == 1) ans = Math.max(ans, nums[n - 1]);

        return ans;
    }
}
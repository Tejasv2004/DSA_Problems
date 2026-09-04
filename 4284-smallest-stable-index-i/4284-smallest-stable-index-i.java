class Solution {
    public int firstStableIndex(int[] nums, int k) {
    int n = nums.length;
        int i = 0;
        while (i < n) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
            }
            int s = max - min;
            if (s <= k) {
              return i;
            }

            i++;
        }
        return -1;
    }
}
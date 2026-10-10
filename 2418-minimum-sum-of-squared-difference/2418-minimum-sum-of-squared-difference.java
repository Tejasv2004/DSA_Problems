class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        long[] diff = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long left = 0, right = max;

        while (left < right) {
            long mid = (left + right + 1) / 2;
            long needed = 0;

            for (long d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        long remaining = k;
        long ans = 0;

        for (long d : diff) {
            if (d > left + 1) {
                remaining -= d - (left + 1);
                ans += (left + 1) * (left + 1);
            } else {
                ans += d * d;
            }
        }

        for (long d : diff) {
            if (remaining > 0 && d > left) {
                ans -= (left + 1) * (left + 1);
                ans += left * left;
                remaining--;
            }
        }

        return ans;
    }
}
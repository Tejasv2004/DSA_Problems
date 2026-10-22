class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int idxZero = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idxZero = i;
                break;
            }
        }

        boolean inc = isValidIncreasing(nums, idxZero);
        boolean dec = isValidDecreasing(nums, idxZero);

        if (!inc && !dec) {
            return -1;
        }

        int minOps = Integer.MAX_VALUE;

        if (inc) {
         
            int costPureRotate = idxZero;
            
            int costRevRotRev = 2 + ((n - idxZero) % n);

            minOps = Math.min(minOps, Math.min(costPureRotate, costRevRotRev));
        }

        if (dec) {
          
            int costReverseFirst = 1 + (n - 1 - idxZero);
           
            int costRotateFirst = ((idxZero + 1) % n) + 1;

            minOps = Math.min(minOps, Math.min(costReverseFirst, costRotateFirst));
        }

        return minOps;
    }

    private boolean isValidIncreasing(int[] nums, int startIdx) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[(startIdx + i) % n] != i) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidDecreasing(int[] nums, int startIdx) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int expectedIdx = (startIdx - i + n) % n;
            if (nums[expectedIdx] != i) {
                return false;
            }
        }
        return true;
    }
}




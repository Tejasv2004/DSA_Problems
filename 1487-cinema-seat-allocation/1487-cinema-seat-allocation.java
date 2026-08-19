class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << (col - 2)));
            }
        }

        int ans = (n - map.size()) * 2;

        int leftMask = (1 << 0) | (1 << 1) | (1 << 2) | (1 << 3);
        int midMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int rightMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);

        for (int mask : map.values()) {
            boolean left = (mask & leftMask) == 0;
            boolean right = (mask & rightMask) == 0;

            if (left && right) {
                ans += 2;
            } else if (left || right || (mask & midMask) == 0) {
                ans += 1;
            }
        }

        return ans;
    }
}
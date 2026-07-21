class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int totalOnes = 0;
        int previousZeroGroup = Integer.MIN_VALUE;
        int bestExtra = 0;

        int i = 0;

        while (i < s.length()) {

            int j = i;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int length = j - i;

            if (s.charAt(i) == '1') {
                totalOnes += length;
            } else {
                bestExtra = Math.max(bestExtra, previousZeroGroup + length);
                previousZeroGroup = length;
            }

            i = j;
        }

        return totalOnes + bestExtra;
    }
}
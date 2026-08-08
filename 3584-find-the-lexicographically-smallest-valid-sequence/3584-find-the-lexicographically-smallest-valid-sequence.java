class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();

        int[] suf = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && s[i] == t[j]) {
                suf[i] = suf[i + 1] + 1;
                j--;
            } else {
                suf[i] = suf[i + 1];
            }
        }

        int[] ans = new int[m];
        int i = 0;
        j = 0;

        while (i < n && j < m) {
            if (s[i] == t[j]) {
                ans[j++] = i;
            } else {
                if (suf[i + 1] >= m - j - 1) {
                    ans[j++] = i;
                    i++;
                    break;
                }
            }
            i++;
        }

        if (j < m && i == n) {
            return new int[0];
        }

        while (i < n && j < m) {
            if (s[i] == t[j]) {
                ans[j++] = i;
            }
            i++;
        }

        return j == m ? ans : new int[0];
    }
}
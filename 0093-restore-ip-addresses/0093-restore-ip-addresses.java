import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(String s, int index, int parts,
                           List<String> path, List<String> ans) {
        if (parts == 4) {
            if (index == s.length()) {
                ans.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String segment = s.substring(index, index + len);

            if (segment.length() > 1 && segment.charAt(0) == '0')
                break;

            if (Integer.parseInt(segment) > 255)
                break;

            path.add(segment);
            backtrack(s, index + len, parts + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
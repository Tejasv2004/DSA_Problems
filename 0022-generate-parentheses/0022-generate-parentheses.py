class Solution(object):
    def generate(self, n, l, r, s, ans):
        if r == n:
            ans.append(s)
            return

        if l < n:
            self.generate(n, l + 1, r, s + "(", ans)

        if r < l:
            self.generate(n, l, r + 1, s + ")", ans)

    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        self.generate(n, 0, 0, "", ans)
        return ans
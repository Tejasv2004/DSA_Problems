class Solution {
    public boolean isPalindrome(int x) {
     int temp = x;
     int rem = 0;
     while (x > 0) {
       int num = x % 10;
       x /= 10;
       rem = rem * 10 + num; 
     }
     if (rem == temp) return true;
     else return false;
    }
}
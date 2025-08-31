package array.easy;

public class PalindromeNumber {
    // 9. Palindrome Number
    // https://leetcode.com/problems/palindrome-number/
    // Easy
    // Tags: Array, Math
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String s = String.valueOf(x);
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int x = 121;
        System.out.println(new PalindromeNumber().isPalindrome(x));
        int x1 = -121;
        System.out.println(new PalindromeNumber().isPalindrome(x1));
        int x2 = 10;
        System.out.println(new PalindromeNumber().isPalindrome(x2));
    }
}

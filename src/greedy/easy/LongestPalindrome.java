package greedy.easy;

import java.util.Arrays;
import java.util.Stack;

public class LongestPalindrome {
//    We have a string that has lowercase and uppercase letters, and we have to find out the longest palindrome that can be built from those characters in the string, that’s all.
//
//    s = “abccccdd”	output = 7
//
//    Approach
//    Sorting the array and then using stacks.
    public static void main(String[] args) {
        System.out.println(
                longestPalindrome("aba")
        );
        System.out.println(
                longestPalindrome("abccccdd")
        );
        System.out.println(
                longestPalindrome("a")
        );
    }
    public static int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        s = new String(arr);
        Stack<Character> stack = new Stack<Character>();
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(stack.size() > 0 && stack.peek() == s.charAt(i)) {
                stack.pop();
                ans += 2;
                continue;
            }
            stack.push(s.charAt(i));
        }
        if(stack.size() > 0) {
            ans += 1;
        }
        return ans;
    }

}

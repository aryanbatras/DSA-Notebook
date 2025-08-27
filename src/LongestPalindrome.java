import java.util.Arrays;
import java.util.Stack;

public class LongestPalindrome {
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

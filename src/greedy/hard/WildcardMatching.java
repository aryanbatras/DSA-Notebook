package greedy.hard;

public class WildcardMatching {
    // Unsolved
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        if(s.length() > 0 && p.length() == 0) return false;
        int ptr = 0;
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*') continue;
            else if (c == '?') {
                if (s.length( ) == 0) return false;
                if (s.length( ) >= ++ptr) continue;
                else return false;
            }
            else{
                if(i > 0 && p.charAt(i - 1) == '*')
                    while(s.charAt(ptr) != c && ptr < s.length() - 1) ptr++;
                if (ptr < s.length() && c == s.charAt(ptr++)) continue;
                else return false;
            }

        }
        for(int i = ptr; i < s.length(); i++) {
            if (p.charAt(p.length() - 1) != '*') return false;
        }
        return true;
    }
    public static void main(String[] args) {

        // IMPOSSIBLE TEST CASE
        System.out.println(
                new WildcardMatching().isMatch("abcabczzzde", "*abc???de*") // true
        );


        // ALL TEST CASES PASSED
        System.out.println(
                new WildcardMatching().isMatch("mississippi", "m??*ss*?i*pi") // false
        );
        System.out.println(
                new WildcardMatching().isMatch("adceb", "*a?b")
        );
        System.out.println(
                new WildcardMatching().isMatch("a", "")
        );
        System.out.println(
                new WildcardMatching().isMatch("cb", "?a")
        );
        System.out.println(
                new WildcardMatching().isMatch("adceb", "*a*b")
        );
        System.out.println(
                new WildcardMatching().isMatch("acdcb", "a*c?b")
        );
        System.out.println(
                new WildcardMatching().isMatch("adceb", "*a*b")
        );
        System.out.println(
                new WildcardMatching().isMatch("adceb", "?a*b")
        );
        System.out.println(
                new WildcardMatching().isMatch("adceb", "?a?b")
        );
        System.out.println(
                new WildcardMatching().isMatch("", "***")
        );
        System.out.println(
                new WildcardMatching().isMatch("aa", "a")
        );
        System.out.println(
                new WildcardMatching().isMatch("aa", "*")
        );
        System.out.println(
                new WildcardMatching().isMatch("", "*?*")
        );
        System.out.println(
                new WildcardMatching().isMatch("a", "***")
        );
        System.out.println(
                new WildcardMatching().isMatch("a", "*?*")
        );
        System.out.println(
                new WildcardMatching().isMatch("a", "?**")
        );
        System.out.println(
                new WildcardMatching().isMatch("a", "**?")
        );
    }
}

package string.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(new String[]{"a"})
        );
        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"})
        );
        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(new String[]{"reflower","flow","flight"})
        );

        System.out.println(
                new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog","racecar","car"})
        );
    }
    public String longestCommonPrefix(String[] st) {
        if(st == null || st.length == 0) return "";
        String s = st[0];
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < st.length; i++) {
            if(i == 0) continue;
            int l = 0, fin = st[i].length() - 1;
            sb = new StringBuilder();
            while(l <= fin){
                if(s.length() > l && st[i].charAt(l) == s.charAt(l)) sb.append(s.charAt(l));
                else break;
                l++;
            }
            s = sb.toString();
        }
        return sb.toString();
    }
}

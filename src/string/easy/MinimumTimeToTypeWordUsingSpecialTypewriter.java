package string.easy;

public class MinimumTimeToTypeWordUsingSpecialTypewriter {
    // Unsolved

    // 1974. Minimum Time to Type Word Using Special Typewriter
    // https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
    // Easy
    // Tags: Greedy, String
    public int minimumTimeToType(String word) {
        char cur = 'a';
        int ck = 0, ack = 0;
        int ans = 0;
        for(char e : word.toCharArray()){
            ans += 1; // type
            if(cur == e) continue;
            ck = Math.abs(cur - e) ;
            ack = Math.abs('z' - 'a') - Math.abs('z' - cur);
            if(ck == 0) ck = 1;
            if(ack == 0) ack = 1;
            ans += Math.min(ck, ack);
            cur = e;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                'z' - 'a'
-                Math.abs('z' - 'b')
//                        - Math.abs('b' - 'a')
        );
        System.out.println(
                new MinimumTimeToTypeWordUsingSpecialTypewriter().minimumTimeToType("bza")
        );
    }
}

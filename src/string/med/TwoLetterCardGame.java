package string.med;

import java.util.Arrays;

public class TwoLetterCardGame {
    public static int score(String[] cards, char x) {
        Arrays.sort(cards);
        int ans = 0;
        int l = 0, r = cards.length - 1;
        while(l < r){
            if(cards[l].charAt(0) == x && cards[l + 1].charAt(0) == x || cards[l].charAt(1) == x && cards[l + 1].charAt(1) == x){
                ans++;
                l += 2;
                continue;
            }
           else if(cards[r].charAt(0) == x && cards[r - 1].charAt(0) == x || cards[r].charAt(1) == x && cards[r - 1].charAt(1) == x){
                ans++;
                r -= 2;
                continue;
            }
            l++;
            r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] cards = {"aa", "ab", "ba", "ac"};
        System.out.println(score(cards, 'a'));
        String[] cards1 = {"aa", "ab", "ba"};
        System.out.println(score(cards1, 'a'));
        String[] cards2 = {"aa", "ab", "ba", "ac"};
        System.out.println(score(cards2, 'b'));
    }
}

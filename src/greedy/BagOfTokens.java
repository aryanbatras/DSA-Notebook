package greedy;

import java.util.Arrays;

public class BagOfTokens {

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        // 2 ways: face-up or face-down
        int l = 0;
        int r = tokens.length - 1;
        int score = 0;
        while (l <= r) {
            // face-up first
            if (power >= tokens[l]) {
                power -= tokens[l];
                score++;
                l++;
            } else if (power < tokens[l]) {

                // cannot play face-up to add your score
                if(l == r){
                    break;
                }

                // face-down
                if(score > 0){
                    power += tokens[r];
                    score--;
                    r--;
                } else {
                    // face-down not possible
                    break;
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        // test-case 1
        System.out.println(
                bagOfTokensScore(new int[]{100},  50)
        );

        // test-case 2
        System.out.println(
                bagOfTokensScore(new int[]{200, 100}, 150)
        );


        // test-case 3
        System.out.println(
                bagOfTokensScore(new int[]{100, 200, 300, 400}, 200)
        );

    }
}

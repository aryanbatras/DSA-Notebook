package greedy.med;

import java.util.Arrays;

public class BagOfTokens {

//    You have some tokens and you have some power. Now there are two possibilities here. Either you can do face-up: where the power will be deducted the same as some token amount and score will increase by one. Or you can do face-down: where the power will be increased by the same as some token amount and score will be decreased by one. You have to find the maximum score possible from the array of tokens and the value power.
//
//            Example 1
//    tokens = [100], power = 50
//    output = 0 since power is less then tokens and score will be decreased by -1 if you do face-down here which is not necessary.
//
//    Example 2
//    tokens = [200, 100], power = 150
//    output = 1 since score can be increased by 1 by doing face-up with token 100 then there is no need to do face-down for token 200 since there are no other tokens lef
//
//    Example 3
//    tokens = [100, 200, 300, 400], power = 200
//    output = 2 since first power is consumed for token which takes least power, then power is increased for token which has most power, then power is used for other tokens.
//
//    Approach
//    Here the key is to be greedy. Literally. We do face-up for the tokens having least price. And we do face-down for the tokens having highest price. Since we have to know both low and high at the same time, we have to use two pointers on a sorted array.
//
//    Note
//    There are some edge cases in face-down approach, suppose if there are no further face-ups then why would we do face-down to decrease our existing score. And suppose if the score is already 0, then how can we do face-down from 0?


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

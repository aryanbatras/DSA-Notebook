package greedy.easy;

import java.util.Arrays;

public class BuyTwoChocolates {
//    You have some prices of chocolates in array and initial money. You have to find a way to buy two chocolates without going in debt. If you do not have that much money you will not buy chocolates and money remains same as answer.
//
//    Example 1:
//    Input: prices = [1,2,2], money = 3
//    Output: 0
//    Explanation: Purchase the chocolates priced at 1 and 2 units respectively. You will have 3 - 3 = 0 units of money afterwards. Thus, we return 0.
//
//    Example 2:
//    Input: prices = [3,2,3], money = 3
//    Output: 3
//    Explanation: You cannot buy 2 chocolates without going in debt, so we return 3.
//
//    Approach
//    Too Easy. Just sort the array. And do comparison.
    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices.length >= 2) {
            if (prices[0] + prices[1] <= money) {
                return money - (prices[0] + prices[1]);
            } else {
                return money;
            }
        } else {
            return money;
        }
    }
    public static void main(String[] args) {
        System.out.println(
                buyChoco(new int[]{1, 3, 2, 4, 1, 3, 2, 2}, 7)
        );
        System.out.println(
                buyChoco(new int[]{3, 2, 3, 4, 2}, 5)
        );
    }
}

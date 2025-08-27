package greedy.med;

public class BestTimeToBuyAndSellStockII {
//    We have array nums where each index i represents a day. On each day, the stock prices are changed and reflected in the array. The days are represented in array from 0 to n - 1. You can buy at any day and sell any day as per your convenience. The goal here is to maximize the profit and return the profit.
//
//    prices = [7,1,5,3,6,4]			output = 7
//    buy on day 2 & sell on day 3 and buy on day 4 & sell on day 5.
//
//    prices = [1,2,3,4,5]				output = 4
//    buy on day 1 and sell on day 5.
//
//    Approach
//    Not sure which approach. We just call it greedy.
    public static void main(String[] args) {
        System.out.println(
                maxProfit(new int[]{7,1,5,3,6,4})
        );
        System.out.println(
                maxProfit(new int[]{1,2,3,4,5})
        );
        System.out.println(
                maxProfit(new int[]{7,6,4,3,1})
        );
        System.out.println(
                maxProfit(new int[]{1,2})
        );
        System.out.println(
                maxProfit(new int[]{1})
        );
        System.out.println(
                maxProfit(new int[]{2,4,1})
        );
    }
    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        int sellerStock = 0;
        for(int i = 0; i < prices.length; i++) {
             if(i == 0){
                 sellerStock = prices[i];
                 continue;
             }
             if(sellerStock > prices[i]) {
                 sellerStock = prices[i];
             } else {
                 totalProfit += prices[i] - sellerStock;
                 sellerStock = prices[i];
             }
        }
        return totalProfit;
    }
}

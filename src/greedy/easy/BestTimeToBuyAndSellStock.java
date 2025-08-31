package greedy.easy;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices3 = {2,1,2,1,0,1,2};
        System.out.println(maxProfit(prices3));
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        int[] prices2 = {7,6,4,3,1};
        System.out.println(maxProfit(prices2));
    }
    public static int maxProfit(int[] prices) {
        int res = 0;
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(i < prices.length - 1 && prices[i] < buy){ buy = prices[i]; sell = 0; }
            if(buy >= 0 && prices[i] > sell) sell = prices[i];
            res = Math.max(res, sell - buy);
        }
        return res;
    }
}

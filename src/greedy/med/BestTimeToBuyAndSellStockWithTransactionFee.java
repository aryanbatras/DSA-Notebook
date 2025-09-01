package greedy.med;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    // 714. Best Time to Buy and Sell Stock with Transaction Fee
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < buy) buy = prices[i];
            else if(prices[i] - fee > buy){
                profit += prices[i] - fee - buy;
                buy = prices[i] - fee;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(prices, fee));
        int[] prices2 = {1,3,7,5,10,3};
        int fee2 = 3;
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(prices2, fee2));
    }
}

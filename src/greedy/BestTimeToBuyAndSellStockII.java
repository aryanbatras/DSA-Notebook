package greedy;

public class BestTimeToBuyAndSellStockII {
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

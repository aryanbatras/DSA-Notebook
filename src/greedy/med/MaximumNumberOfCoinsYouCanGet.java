package greedy.med;

import java.util.Arrays;

// 1561. Maximum Number of Coins You Can Get
public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int l = 0, r = piles.length - 2, ans = 0;
        while(l <= r){
            ans += piles[r];
            l++;
            r -= 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int piles[] = {2,4,1,2,7,8};
        System.out.println(
                new MaximumNumberOfCoinsYouCanGet().maxCoins(piles)
        );
        int piles2[] = {2,4,5};
        System.out.println(
                new MaximumNumberOfCoinsYouCanGet().maxCoins(piles2)
        );
        int piles1[] = {9,8,7,6,5,1,2,3,4};
        System.out.println(
                new MaximumNumberOfCoinsYouCanGet().maxCoins(piles1)
        );
    }
}

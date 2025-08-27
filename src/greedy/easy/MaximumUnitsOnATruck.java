package greedy.easy;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for(int i = 0; i < boxTypes.length && truckSize > 0; i++){
            int e = boxTypes[i][0];
            if(e <= truckSize) {
                ans += e * boxTypes[i][1];
                truckSize -= e;
            } else {
                e = truckSize;
                truckSize = 0;
                ans += e * boxTypes[i][1];
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4)
        );
        System.out.println(
                maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10)
        );
    }
}

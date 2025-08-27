package greedy;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {
    public static int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApples = 0;
        for(int e : apple){
            totalApples += e;
        }
        int minimumBoxes = 0;
        for(int i = capacity.length - 1; i >= 0; i--){
            if(totalApples > capacity[i]){
                minimumBoxes++;
                totalApples -= capacity[i];
            } else if(totalApples <= 0) {
                return minimumBoxes;
            } else {
                minimumBoxes++;
                totalApples -= capacity[i];
            }
        }
        return minimumBoxes;
    }

    public static void main(String[] args) {
        // test-case 1
        System.out.println(
                minimumBoxes(new int[]{1, 2, 3}, new int[]{4, 3, 1, 5, 2})
        );

        // test-case 2
        System.out.println(
                minimumBoxes(new int[]{5, 5, 5}, new int[]{2, 4, 2, 7})
        );

    }
}

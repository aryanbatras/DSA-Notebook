package greedy.easy;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {
//    We have some apples each having some size are packed in a packet of the same size. On the other hand, we have some boxes each with some definite capacity to store those packets of apple. Now we have to find the minimum number of boxes to store those packets of apples.
//
//    Example 1
//    apple = [1,3,2], capacity = [4,3,1,5,2]
//    output = 2 since the total size of applies is 6 so we can use boxes of size 5 and any other box size.
//
//    Example 2
//    apple = [5,5,5], capacity = [2,4,2,7]
//    output = 4 since total size of apple packets is 15 and we have to use all boxes to store these apples.
//
//     Approach
//    Since we need boxes of maximum capacity first, we can just sort the capacity array. Then run a loop to count total apples. And then run a loop again for capacity. Basically we are precomputing apples and also accumulating it first.

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

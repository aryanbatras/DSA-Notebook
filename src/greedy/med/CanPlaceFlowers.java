package greedy.med;

public class CanPlaceFlowers {

//    We have a flowerbed in some particular order represented by zeros and ones of an array, where zero represents flower is not here, and one represents flower is there. Now there is a rule that the order of flowerbed is fixed and flowers cannot be planted in adjacent plots. Means there has to be a zero between two ones. Now the problem says we have to find whether we can add n more flowers into the zeros following the no adjacent flowers role.
//
//    Example 1
//    flowerbed = [1,0,0,0,1], n = 1
//    output = true since we can place a flower in the middle
//
//    Example 2
//    flowerbed = [1,0,0,0,1], n = 2
//    output = false since only one flower can be here but two needed
//
//    Approach 1
//    No need to sort since order is fixed. Finding the number of zeros and ones won’t work here since order and adjacency rule matters here.
//
//    Approach 2
//    Greedily solving this for each step. Too many edge cases since we are checking the best answer for every loop. Most of the edge cases arise when index is first or last and also when size is either one or two.
//
//            Note
//    Edge cases are critical
//
//
    // Wrong Solution. It is not about the number of zeros and ones. It is about the order.
//    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
//
//        int zeros = 0;
//        int ones = 0;
//        for(int i = 0; i < flowerbed.length; i++){
//            if(flowerbed[i] == 0){
//                zeros++;
//            } else {
//                ones++;
//            }
//        }
//
//        int minZerosRequired = 2 * n + 1;
//
//        if(zeros >= minZerosRequired){
//            return true;
//        } else {
//            return false;
//        }
//
//    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int changed = 0;
        int flowerIndex = 0;
        while(flowerIndex < flowerbed.length){
            if(flowerIndex == 0 || flowerIndex == flowerbed.length - 1){
                if(flowerbed.length == 2 && flowerbed[0] == 0 && flowerbed[1] == 0 && n == 1){
                    return true;
                } else if(flowerbed.length == 1 && flowerbed[0] == 0 && n == 1){
                    return true;
                }
                if(flowerIndex == 0 && flowerbed.length == 1){
                  if(flowerbed[flowerIndex] == 0 && n == 1 || flowerbed[flowerIndex] == 0 && n == 0){
                      return true;
                  }
                } else if(flowerIndex == 0 && flowerbed[flowerIndex] == 0 && flowerbed[flowerIndex + 1] == 0){
                    flowerbed[flowerIndex] = 1;
                    changed++;
                } else if(flowerIndex == flowerbed.length - 1 && flowerbed[flowerIndex] == 0 && flowerbed[flowerIndex - 1] == 0){
                    flowerbed[flowerIndex] = 1;
                    changed++;
                }
            }
            else if(flowerbed[flowerIndex] == 0 && flowerbed[flowerIndex - 1] == 0 && flowerbed[flowerIndex + 1] == 0) {
                flowerbed[flowerIndex] = 1;
                changed++;
            }
            if(changed >= n){
                return true;
            }
            flowerIndex++;
        }
        return false;
    }

    public static void main(String[] args) {

        // test-case 1
        System.out.println(
                (canPlaceFlowers(new int[]{0}, 1) == true) ? "true" : "false"
        );

        // test-case 2
        System.out.println(
                (canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2) == false) ? "true" : "false"
        );

        // test-case 3
        System.out.println(
                (canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1) == true) ? "true" : "false"
        );

        // test-case 4
        System.out.println(
                (canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2) == false) ? "true" : "false"
        );

        // test-case 5
        System.out.println(
                (canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 1) == true) ? "true" : "false"
        );

        // test-case 6
        System.out.println(
                (canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 1) == false) ? "true" : "false"
        );
    }
}

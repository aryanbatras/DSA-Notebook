import java.util.Arrays;

public class CanPlaceFlowers {

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

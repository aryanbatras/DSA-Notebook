package greedy.med;

import java.util.List;
// Unsolved
// 624. Maximum Distance in Arrays
public class MaximumDistanceInArrays {
    public static int maximumDistance(List<List<Integer>> arrays) {
        // the trick here is that the min and max cannot be from the same array itself, these two numbers must be from two different arrays and still return max.

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int iGather = 0;
        for(int i = 0; i < arrays.size(); i++){
            if(arrays.get(i).get(0) <= min){
                min = arrays.get(i).get(0);
                iGather = i;
            }
        }

        int tempMax = arrays.get(iGather).get(arrays.get(iGather).size() - 1);

        int iGather2 = 0;
        for(int i = 0; i < arrays.size(); i++){
            if(i != iGather && arrays.get(i).get(arrays.get(i).size() - 1) >= max){
                max = arrays.get(i).get(arrays.get(i).size() - 1);
                iGather2 = i;
            }
        }
        int tempMin = arrays.get(iGather2).get(0);

        if(tempMax - tempMin > max - min){
            max = tempMax;
            min = tempMin;
        }

//        else if(tempMax - min > max - tempMin){
//            max = tempMax;
//        } else if (max - tempMin > tempMax - min){
//            min = tempMin;
//        }

        return max - min;
    }
    public static void main(String[] args) {
        // test-case 1
        System.out.println(
                maximumDistance(List.of(List.of(1,2,3), List.of(4,5), List.of(1,2,3)))
        );

        System.out.println(
                maximumDistance(List.of(List.of(-10,-9,-9,-9,-7,-2,-1,2,4), List.of(-9,-7,-6,-6,-3,0,1,3), List.of(-10,-9,-2,-1,1,3)))
        );
        System.out.println(
                maximumDistance(List.of(List.of(1, 4), List.of(0,5)))
        );



        // test-case 2
        System.out.println(
               maximumDistance(List.of(List.of(1), List.of(1)))
        );
    }
}

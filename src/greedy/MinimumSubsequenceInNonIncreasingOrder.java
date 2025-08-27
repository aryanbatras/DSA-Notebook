package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceInNonIncreasingOrder {

    public static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int Index = 0;
        List<Integer> l = new ArrayList<Integer>();
        int ansAccumulator = 0;
        while(Index < nums.length) {
            l.add(nums[Index]);
            ansAccumulator += nums[Index];
            int localAccumulator = 0;
            for (int i = Index + 1; i < nums.length; i++) {
                localAccumulator += nums[i];
            }
            if(localAccumulator < ansAccumulator) {
                return l;
            }
            Index++;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(
                minSubsequence(new int[]{6})
        );
        System.out.println(
                minSubsequence(new int[]{4, 3, 10, 9, 8})
        );

        System.out.println(
                minSubsequence(new int[]{4, 4, 7, 6, 7})
        );

    }
}
package greedy.easy;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    // Unsolved

    // 1005. Maximize Sum Of Array After K Negations
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            } else if(nums[i] > 0 && k > 0){
                nums[i] = - nums[i];
                k--;
            }
            while(nums[i] == 0 && k > 0) k--;
            while(i < nums.length - 1 && nums[i + 1] > 0 && nums[i] > 0 && k % 2 == 0 && k > 0) k -= 2;

        }
        for(int i = 0; i < nums.length; i++) ans += nums[i];
        return ans;
    }
    public static void main(String[] args) {
        int[] nums4 = {-2,9,9,8,4};
        int k4 = 5;
        System.out.println(new MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(nums4, k4));
        int[] nums = {4,2,3};
        int k = 1;
        System.out.println(new MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(nums, k));
        int[] nums2 = {3,-1,0,2};
        int k2 = 3;
        System.out.println(new MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(nums2, k2));
        int[] nums3 = {2,-3,-1,5,-4};
        int k3 = 2;
        System.out.println(new MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(nums3, k3));
    }
}

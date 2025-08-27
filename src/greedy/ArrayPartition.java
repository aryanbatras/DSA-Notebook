package greedy;

import java.util.Arrays;

public class ArrayPartition {
    public static int arrayPairSum(int[] nums){
        Arrays.sort(nums);
        int l = 0;
        int ans = 0;
        while(l < nums.length - 1){
            ans += Math.min(nums[l], nums[l + 1]);
            l += 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        System.out.println(arrayPairSum(nums));
        int[] nums1 = {6,2,6,5,1,2};
        System.out.println(arrayPairSum(nums1));
    }
}

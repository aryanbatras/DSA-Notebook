package greedy.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeArrayZeroBySubtractingEqualAmounts {
    // 2357. Make Array Zero by Subtracting Equal Amounts

    // Approach 1
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int e = 0, temp = 0, ans = 0;
        while(e < nums.length && nums[e] == 0) e++;
        for(int i = e; i < nums.length; i++){
            if(nums[i] == 0) continue;
            temp = nums[i];
            boolean flag = false;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 0) continue;
                else nums[j] = nums[j] - temp;
                flag = true;
            }
            if(flag){
                e++;
                ans++;
            }
        }
        return ans;
    }

    // Optimal Appraoch
    public int minimumOperationsOptimal(int[] nums) {
        int ans = 0;
        Set<Integer> s = new HashSet<>();
        for(int e : nums) if(e != 0) s.add(e);
        for(int t : s) ans++;
        return ans;
    }
    public static void main(String[] args) {
        // Approach 1
        int[] nums = {1,1,2,2,2,2,3,3};
        System.out.println(new MakeArrayZeroBySubtractingEqualAmounts().minimumOperations(nums));
        int[] nums1 = {1,5,0,3,5};
        System.out.println(new MakeArrayZeroBySubtractingEqualAmounts().minimumOperations(nums1));

        // Optimal
        int[] nums2 = {1,1,2,2,2,2,3,3};
        System.out.println(new MakeArrayZeroBySubtractingEqualAmounts().minimumOperationsOptimal(nums2));
        int[] nums3 = {1,5,0,3,5};
        System.out.println(new MakeArrayZeroBySubtractingEqualAmounts().minimumOperationsOptimal(nums3));
    }
}

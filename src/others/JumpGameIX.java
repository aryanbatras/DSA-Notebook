package others;

import java.util.Arrays;

// Weekly Contest 464
// Weekly Contest 464
public class JumpGameIX {
    public static int[] maxValue(int[] nums) {
        int[] ans = new int[nums.length];
        int max = 0;
       for(int i = 0; i < nums.length; i++){
           int j = nums[i];
           if(j >= 0 && j < nums.length - 1){
               if(j > i && nums[j] < nums[i]){
                   // jump
                   ans[i] = Math.max(nums[i], nums[j]);
                  ans = jump(nums, j, i, ans);
               } else if (j < i && nums[j] > nums[i]){
                   // jump
                   ans[i] = Math.max(nums[i], nums[j]);
                   ans = jump(nums, j, i, ans);
               } else if(i == j && j > 0 && nums[j - 1] > nums[j]){
                   // jump
                   ans[i] = Math.max(nums[i], nums[j - 1]);
                   ans = jump(nums, j - 1, i, ans);
               } else if(i == j && j < nums.length - 1 && nums[j + 1] > nums[j]){
                   // jump
                   ans[i] = Math.max(nums[i], nums[j + 1]);
                   ans = jump(nums, j + 1, i, ans);
               }
               else{
                   ans[i] = nums[i];
               }
           }  else {
               ans[i] = nums[i];
           }
       }
       return ans;
    }
    public static int[] jump(int[] nums, int i, int original, int[] ans) {
        if(i < 0 || i >= nums.length) return ans;
        if(nums[i] > 0 && nums[i] < nums.length) {
            int j = nums[i];
            if(j > i && nums[j] < nums[i]){
                // jump
                ans[original] = Math.max(nums[i], nums[j]);
               ans = jump(nums, j, original, ans);
            } else if (j < i && nums[j] > nums[i]){
                // jump
                ans[original] = Math.max(nums[i], nums[j]);
               ans = jump(nums, j, original, ans);
            } else {
                ans[original] = nums[i];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(maxValue(new int[]{7,5}))
        );
        System.out.println(
                Arrays.toString(maxValue(new int[]{2,1,3}))
        );
        System.out.println(
                Arrays.toString(maxValue(new int[]{2,3,1}))
        );
    }
}
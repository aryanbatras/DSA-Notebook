package greedy;

public class MinimumOperationsToMakeTheArrayIncreasing {
    public static int minOperations(int[] nums) {
        int ans = 0;
        if(nums.length == 1) return 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0) continue;
            if(nums[i] <= nums[i - 1]){
                int e = nums[i - 1] - nums[i] + 1;
                ans += e;
                nums[i] += e;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                minOperations(new int[]{1, 1, 1})
        );
        System.out.println(
                minOperations(new int[]{1, 5, 2, 4, 1})
        );
        System.out.println(
                minOperations(new int[]{8})
        );
    }
}

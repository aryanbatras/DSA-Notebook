package greedy.med;

public class MinimumArrayLengthAfterPairRemovals {
    // 2856. Minimum Array Length After Pair Removals
    public int minOperations(int[] nums) {
        int l = 0, r = nums.length -1, ans = 0;
        while(l <= r){
            if(nums[l] < nums[r]){
                l++;
                r--;
            } else if(nums[l] == nums[r]){
                l++;
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new MinimumArrayLengthAfterPairRemovals().minOperations(nums));
        int[] nums4 = {1,1,2,2,3,3};
        System.out.println(new MinimumArrayLengthAfterPairRemovals().minOperations(nums4));
        int[] nums1 = {1,1,100000};
        System.out.println(new MinimumArrayLengthAfterPairRemovals().minOperations(nums1));
        int[] nums2 = {2,3,4,4,4};

        System.out.println(new MinimumArrayLengthAfterPairRemovals().minOperations(nums2));
        int[] nums3 = {100000,100000,100000};
        System.out.println(new MinimumArrayLengthAfterPairRemovals().minOperations(nums3));
    }
}

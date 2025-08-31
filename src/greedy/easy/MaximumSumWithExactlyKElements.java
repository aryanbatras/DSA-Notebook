package greedy.easy;

// 2656. Maximum Subarray Sum With Exactly K Elements
// https://leetcode.com/problems/maximum-subarray-sum-with-exactly-k-elements/
// Easy
// Tags: Greedy, Array

/*
*  Given an integer array nums and an integer k, return the maximum subarray sum of size k.
*
* Example 1:
* Input: nums = [1,2,3,4,5], k = 3
* Output: 18 since 5 + 6 + 7 = 18
*
* Example 2:
* Input: nums = [5,6,7,8,9], k = 4
* Output: 42 since 9 + 10 + 11 + 12 = 42
*
* */
public class MaximumSumWithExactlyKElements {
    public static int maximizeSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int e = 0; e < nums.length; e++){
            if(nums[e] > max) max = nums[e];
        }
        int ans = 0;
        while(k > 0){
            ans += max;
            max++;
            k--;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
               maximizeSum(new int[]{1, 2, 3, 4, 5}, 3)
        );
        System.out.println(
               maximizeSum(new int[]{5, 6, 7, 8, 9}, 4)
        );
        System.out.println(
               maximizeSum(new int[]{11, 13, 15, 17}, 12)
        );
        System.out.println(
               maximizeSum(new int[]{5,5,5}, 2)
        );
    }
}

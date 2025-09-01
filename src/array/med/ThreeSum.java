package array.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 15. 3Sum
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int e = 0,  r = nums.length - 1;
        while(e < r){
            map.put(nums[e], map.getOrDefault(nums[e], 0) + 1);
            e++;
        }
        int l = 0;
       while(l < r){
            int temp = nums[l] + nums[r];
            Integer val = map.get(temp);
            if(val != null && val > 0){
               ans.add(Arrays.asList(nums[l], nums[r], temp));
               map.put(temp, val - 1);
               map.put(nums[l], map.getOrDefault(nums[l], 1) - 1);
               map.put(nums[r], map.getOrDefault(nums[r], 1) - 1);
               l++;
               r--;
            }
            else if(temp < 0){
                l++;
            } else if(temp > 0){
                r--;
            }
        }
       return ans;
    }
    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        int[] nums1 = {0,0,0};
        System.out.println(threeSum(nums1));
        int[] nums2 = {1,2,-2,-1};
        System.out.println(threeSum(nums2));
        int[] nums3 = {0,1,1};
        System.out.println(threeSum(nums3));
    }
}

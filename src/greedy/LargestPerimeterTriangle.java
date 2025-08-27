package greedy;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int e = i - 2;
            if(e < 0 || i < 2) break;
            int c = nums[i];
            int b = nums[i - 1];
            int a = nums[i - 2];
            if (a + b > c) {
                ans = Math.max(ans, a + b + c);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                largestPerimeter(new int[]{2, 1, 2})
        );
        System.out.println(
                largestPerimeter(new int[]{1, 2, 1})
        );
        System.out.println(
                largestPerimeter(new int[]{3, 2, 3, 4})
        );
        System.out.println(
                largestPerimeter(new int[]{3, 6, 2, 3})
        );
    }
}

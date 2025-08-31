package greedy.med;

import java.util.Arrays;

public class LargestNumber {
    // How comparator works in-depth
    public static String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) numStrs[i] = String.valueOf(nums[i]);
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));
        String ans = String.join("", numStrs);
        return ans.charAt(0) == '0' ? "0" : ans;
    }
    public static void main(String[] args) {
        System.out.println(
                largestNumber(new int[]{10,2})
        );
        System.out.println(
                largestNumber(new int[]{3,30,34,5,9})
        );
        System.out.println(
                largestNumber(new int[]{9,8,95,12,52,5,0})
        );
    }
}

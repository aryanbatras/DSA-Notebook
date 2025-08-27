package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumIncrementToMakeArrayUnique {
    public static int minIncrementForUnique(int[] nums) {
        int ans = 0;
        int e = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){

            if(nums[0] == 1) {
                e = i + 1;
            }  else if (nums[0] == 0){
                e = i;
            } else {
                e = i;
            }

            if (nums[i] == e && !map.containsKey(nums[i])) continue;
            else if ( nums[i] >= e){
                int t = nums[i];
                boolean flag = false;
                while(map.containsKey(nums[i])){
                    nums[i] = map.get(nums[i]) + 1;
                    flag = true;
                }
                if(flag){
                    ans += nums[i] - t;
                }
                map.put(nums[i], nums[i]);
                continue;
            }
            else {
                map.put(e, e);
                ans += e - nums[i];
                nums[i] = e;
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(
                        new int[]{0, 2, 2}
                )
        );
        System.out.println(minIncrementForUnique(
                new int[]{9,7,6,5,1,0}
            )
        );
        System.out.println(minIncrementForUnique(
                new int[]{12345,12345}
            )
        );
        System.out.println(minIncrementForUnique(
                new int[]{1,2,2}
            )
        );
        System.out.println(minIncrementForUnique(
                new int[]{3,2,1,2,1,7}
            )
        );
    }
}

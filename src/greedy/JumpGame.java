package greedy;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(
               canJump(new int[]{2,3,1,1,4})
        );
        System.out.println(
                canJump(new int[]{2,3,0,1,4})
        );
        System.out.println(
                canJump(new int[]{0})
        );
        System.out.println(
                canJump(new int[]{2,0})
        );
        System.out.println(
                canJump(new int[]{1,2,3})
        );
    }

    public static int canJump(int[] nums) {
        int jumps = 0;
        int finalI = nums.length - 1;
        while(finalI != 0){
            int maxJump = 0;
            int maxJumpIndex = 0;
            for(int i = finalI - 1; i >= 0; i--){
                if (nums[i] >= finalI - i) {
                    maxJump = Math.max(maxJump, nums[i]);
                    maxJumpIndex = i;
                }
            }
            jumps++;
            finalI = maxJumpIndex;
        }
       return jumps;
    }
}

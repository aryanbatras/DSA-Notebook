package greedy.med;

public class JumpGame {
//    We have array nums where each number represents max jump length. We are positioned at first index and we can jump any steps between 0 and the jump length at that index. Find out whether we can reach the end by jumping or not. Return true or false.
//
//    nums = [2,3,1,1,4]			output = true
//
//    nums = [3,2,1,0,4]			output = false
//
//    Approach O(n)
//    Assuming the best case that we have already reached the end. We start from the end index. Check whether the next number can really jump to our final index or not. If it can jump, that number is our new final index. And likewise we make sure final index becomes index 0 at end.

//    Jump Game II
//
//    Same as Jump Game. Here we have to return the minimum number of jumps required rather than just reaching the end. It is guaranteed that the solution will be there.
//
//[2,3,1,1,4]		output = 2
//
//            [2,3,0,1,4]		output = 2
//
//    Approach O(n^2)
//    Cannot sort here. We start by assuming we have reached the answer. Now we go backwards. And find the maximum jump at each iteration at the end. Mark that as final index and a jump.

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

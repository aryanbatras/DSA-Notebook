package array.easy;

// 27. Remove Element
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int ans = 0, v = 0;
        for(int e = 0; e < nums.length; e++){
            while(nums[v] != val) v++;
            if(nums[e] != val) ans++;
            if(e > v && nums[e] != val){
                int temp = nums[v];
                nums[v] = nums[e];
                nums[e] = temp;
                v++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(re.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}

package greedy.med;

public class ContainerWithMostWater {
    public static int maxArea(int[] h){
        int l = 0, r = h.length - 1;
        int x = 0, y = 0, area = 0;
        while(l < r){
            x = r - l;
            y = Math.min(h[l], h[r]);
            area = Math.max(area, x * y);
            if(h[l] < h[r]) l++;
            else r--;
        }
        return  area;
    }
    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
        int[] h1 = {1,1};
        System.out.println(maxArea(h1));
    }
}

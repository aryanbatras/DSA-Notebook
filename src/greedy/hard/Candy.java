package greedy.hard;

import java.util.Arrays;
public class Candy {
    // Solved - Best Question
    public static void main(String[] args) {
        System.out.println(
                candy(new int[]{100, 80, 70, 60, 70, 80, 90, 100, 90, 80, 70, 60, 60})
        );
        System.out.println(
                candy(new int[]{6, 7, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 0})
        );
        System.out.println(
                candy(new int[]{1,0,2})
        );
        System.out.println(
                candy(new int[]{1,2,2})
        );
        System.out.println(
                candy(new int[]{60, 80, 100, 100, 100, 100, 100})
        );
        System.out.println(
                candy(new int[]{20000, 20000, 16001, 16001, 16002, 16002, 16003, 16003, 16004, 16004, 16005, 16005, 16006, 16006, 16007, 16007, 16008, 16008, 16009, 16009, 16010, 16010, 16011, 16011, 16012, 16012, 16013, 16013, 16014, 16014, 16015, 16015, 16016, 16016, 16017, 16017, 16018, 16018, 16019, 16019, 16020, 16020, 16021, 16021, 16022, 16022, 16023, 16023, 16024, 16024})
        );
    }
    public static int candy(int[] r) {
        if(r.length == 0) return 0;
        else if(r.length == 1) return 1;
        int[] arr = new int[r.length];
        for(int i = 0; i < r.length; i++) arr[i] = 1;
        int ans = 0, acc = r[0], e = 1;
        for(int i = 1; i < r.length; i++){
            if (acc < r[i]){
                arr[i] += e;
                e++;
            }
            else e = 1;
            acc = r[i];
        }
        e = 1; acc = r[r.length - 1];
        for(int i = r.length - 2; i >= 0; i--){
            if(acc < r[i]){
                arr[i] = Math.max(arr[i], e + 1);
                e++;
            }
            else e = 1;
            acc = r[i];
        }
        for(int i = 0; i < r.length; i++) ans += arr[i];
        return ans;
    }
}



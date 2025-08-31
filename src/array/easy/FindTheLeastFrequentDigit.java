package array.easy;

import java.util.Arrays;
import java.util.HashMap;

public class FindTheLeastFrequentDigit {
    public static int getLeastFrequentDigit(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i] - '0', map.getOrDefault(arr[i] - '0', 0) + 1);
        }
        int digit = arr[0] - '0';
        int ans = map.get(arr[0] - '0');
        for(int i = 1; i < arr.length; i++){
            if(map.get(arr[i] - '0') < ans){
                ans = map.get(arr[i] - '0');
                digit = arr[i] - '0';
            }
        }
        return digit;
    }
    public static void main(String[] args) {
        System.out.println(getLeastFrequentDigit(1553322));
        System.out.println(getLeastFrequentDigit(723344511));
    }
}

package greedy.med;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class RemoveDuplicateLetters {
    // Unsolved
//    public static String removeDuplicateLetters(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < s.length(); i++){
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0 ) + 1);
//            if(map.get(s.charAt(i)) == 1) sb.append(s.charAt(i));
//        }
//        return new String(sb.toString().chars().distinct().sorted().toArray(), 0, sb.length());
//    }
    public static String removeDuplicateLetters(String s) {
        char arr[] = s.toCharArray(); Arrays.sort(arr);
        String sorted = new String(arr);
        int ptrOnSorted = 0;
        return "";
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));

        // after sorting it the occurance of the character changes
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}

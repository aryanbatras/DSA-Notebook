package greedy.easy;

import java.util.Arrays;

public class DIStringMatch {
//    We have a string s having letters ‘I’ and ‘D’. We have to return an integer array of length s + 1 where for every occurrence of ‘I’, the number in the corresponding index increases by one and for every occurrence of ‘D’, the number in the corresponding index decreases by one from the length of s. Since the length of integer array is s + 1, you have to assume the last letter for the additional index.
//
//            Example 1:
//    Input: s = "IDID"	Output: [0,4,1,3,2]
//
//    Example 2:
//    Input: s = "III"	Output: [0,1,2,3]
//    Approach
//    Greedy. A loop.


    public static int[] diStringMatch(String s) {
        int l = s.length();
        int[] ans = new int[l + 1];
        char[] arr = s.toCharArray();
        int dCounter = 0;
        int iCounter = 0;
        char last = '\0';
        for(int i = 0; i < arr.length; i++){
            last = arr[i];
            if(arr[i] == 'I'){
                ans[i] = iCounter++;
            }
            else if(arr[i] == 'D'){
                ans[i] = s.length() - dCounter++;
            }
        }
        if(last == 'I'){
            ans[l] = iCounter;
        }
        else if(last == 'D'){
            ans[l] = s.length() - dCounter;
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(
                diStringMatch("IDID")
        ));
        System.out.println(Arrays.toString(
                diStringMatch("III")
        ));
        System.out.println(Arrays.toString(
                diStringMatch("DDI")
        ));
    }
}

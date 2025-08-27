import java.util.Arrays;

public class DIStringMatch {
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

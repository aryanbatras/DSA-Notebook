package greedy;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int cookieIndex = 0;
        int childrenIndex = 0;
        while(childrenIndex < children.length) {
            if(cookieIndex == cookies.length) {
                break;
            }
            if(children[childrenIndex] <= cookies[cookieIndex]) {
                cookieIndex++;
                childrenIndex++;
            } else if(children[childrenIndex] > cookies[cookieIndex]) {
                cookieIndex++;
            }
        }
        return childrenIndex;
    }
}

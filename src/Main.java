import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println(
//                findContentChildren(
//                        new int[]{1, 2, 3},
//                        new int[]{1, 1}
//                )
                lemonadeChange(
                        new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5}
                )
        );
    }

    // https://leetcode.com/problems/assign-cookies/
    // Time Complexity: O(nlogn + mlogm) where n is the number of children and m is the number of cookies
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

    public static boolean lemonadeChange(int[] bills) {

        // 3 cases, 5$ 10$ 20$
        // [5,5,10,10,20]

        int billIndex = 0;
        int tenDollorChange = 0;
        int fiveDollorChange = 0;
        int twentyDollorChange = 0;
        while(billIndex < bills.length) {
            if(bills[billIndex] == 5) {
                billIndex++;
                fiveDollorChange++;
            } else if(bills[billIndex] == 10) {
                if(fiveDollorChange == 0){
                    return false;
                }
                tenDollorChange++;
                fiveDollorChange--;
                billIndex++;
            } else {
                if(fiveDollorChange == 0 || tenDollorChange == 0 && fiveDollorChange < 3){
                    return false;
                }
                // edge case
                if(tenDollorChange == 0 && fiveDollorChange >= 3){
                    fiveDollorChange -= 3;
                } else {
                    fiveDollorChange--;
                    tenDollorChange--;
                }
                twentyDollorChange++;
                billIndex++;
            }
        }
        return true;
    }
}

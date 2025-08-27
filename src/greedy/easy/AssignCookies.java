package greedy.easy;

import java.util.Arrays;

// Here, we have been given two arrays, children and cookies, where values in children array represent greediness of child and size of the cookie. Only the cookie with size equal to or greater than the greediness of a child can satisfy that child. Our goal here is to find the number of cookies to satisfy maximum children.

// Example 1 children = {1, 2, 3} cookies = {1, 1} output = 1 since only 1 child's greed can be satisfied

// Example 2 children = {3, 4, 5, 6} cookies = {5, 5, 3, 2, 1} output = 3 since only 3 children's greed can be satisfied

// Approach Greedy says check for best outcome at each step. To get the best, we'll sort both the arrays. Then we can easily compare children's greed with cookie's size.

// Note On sorting in ascending order, the children array's index is itself the maximum children that can be satisfied.

// Time Complexity: O(nlogn + mlogm)
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

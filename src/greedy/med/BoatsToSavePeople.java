package greedy.med;

import java.util.Arrays;

public class BoatsToSavePeople {

//    We have people array with their weights, and we have been limit of each boat, where limit represents the maximum weight each boat can hold. Here, we assume that the boats are infinite and we have to resume the people having different weights. We have to find the minimum number of boats required in order to save some people.
//
//    Example 1
//    people = [1, 2], limit = 3
//    output = 1 since minimum boats required are one.
//
//    Example 2
//    people = [3, 2, 2, 1], limit = 3
//    output = 3 since minimum boats required here are three.
//
//            Approach 1
//    Tried to solve it by sorting the array and simple traversing. Not sure why it was not solved in some test cases.
//
//            Approach 2
//    Solved it by using two pointer approach on a sorted array. First we compared the sum of both lowest and highest weight with limit. If not, then on the highest weight side, we compared two people, and then on the lowest weight side. Not sure why to use two pointer only.
//
//    Note
//    Not much edge cases. The intuition build up is challenging.


    // Wrong Answer
//    public static int numberOfRescueBoats(int[] people, int limit){
//        int index = 0;
//        int totalBoats = 0;
//        int weightForBoat = 0;
//        while(index < people.length){
//            if(weightForBoat + people[index] <= limit) {
//                weightForBoat += people[index];
//                index++;
//            }
//            else {
//                totalBoats++;
//                weightForBoat = 0;
//                weightForBoat += people[index];
//                index++;
//            }
//        }
//        if(weightForBoat != 0){
//            totalBoats++;
//        }
//        return totalBoats;
//    }

    /*
    * Time Complexity: O(nlogn + n) = O(nlogn)
    * The time complexity is O(nlogn) because sorting the array takes O(nlogn) time.
    * Then, iterating over the array takes O(n) time.
    */
    public static int numberOfRescueBoats(int[] people, int limit){
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;
        int totalBoats = 0;
        while(l <= r){
            if(people[l] + people[r] <= limit){
                l++;
                r--;
                totalBoats++;
            } else if(people[r] <= limit){
                if(r - 1 >= 0 && people[r - 1] + people[r] <= limit){
                    r--;
                }
                r--;
                totalBoats++;
            } else {
                l++;
                totalBoats++;
            }
        }
        return totalBoats;
    }

    public static void main(String[] args) {
        // test-case 1
        System.out.println(
            numberOfRescueBoats(
                new int[]{1,2}, 3
            )
        );

        // test-case 2
        System.out.println(
                numberOfRescueBoats(
                        new int[]{3,2,2,1}, 3
                )
        );


        // test-case 3
        System.out.println(
                numberOfRescueBoats(
                        new int[]{3,5,3,4}, 5
                )
        );

    }
}

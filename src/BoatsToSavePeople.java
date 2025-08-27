import java.util.Arrays;

public class BoatsToSavePeople {

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

package greedy.med;

public class EarliestFinishTimeForLandAndWaterRides {

//    These are two questions I & II with different constraints. The question I accepts brute force but II accepts only O(n) solution.
//
//    We have two theme parks, land rides and water rides. Both rides are having start time at different intervals and the duration of each ride. Now the tourist wants to take both rides from each category exactly once and it can be in any order. We have to find the earliest possible time for the tourist to finish both rides.
//
//    Note
//    When tourist completes one ride, the other ride not necessarily has to be included start time as well, since that ride may have already started (depends on the time tourist took to took one ride), but if the start time of other ride is still more, you might have to add only that much.
//
//    Example 1
//    landStartTime = [2,8], landDuration = [4,1]
//    waterStartTime = [6], waterDuration = [3]
//    output = 9 since the minimum time is land ride first 2 + 4, then water duration only since water ride has already started + 3.
//
//    Example 2
//    landStartTime = [5], landDuration = [3]
//    waterStartTime = [1], waterDuration = [10]
//    output = 14 since water start time is less, so 1 + 10, then land slide has already started so + 3.
//
//    Approach 1
//    Tried the classic sort the arrays. Use two pointer. And do comparisons to find the best possible solution. Nope failed here. When you are sorting it, there is a different start time and duration time, you cannot just accumulate them since for other ride, you have to discard start time.
//
//            Approach 2
//    Tried 2 pointer without sorting the arrays, just to get the minimum value index based on comparison and then running an accumulator. Did not worked.
//
//            Approach 3
//    Tried to precompute the earliest finish time by picking either land slide or water slide first, finding the minimum from there, and based on the minimum, trying to accumulate value from other slide for each case. Not sure why it did not worked since I’m trying to precompute the earliest finish time for one ride and not considering the minimum for other slide.
//
//    Approach 4
//    Using brute force, we ran two loops to check for all possible outcomes, and accumulating the value for first slide for each step, and then choosing the other slide, and storing the minimum value among all those possibilities. Pretty easy. Intuition is not easy.
//
//    Approach 5
//    Using O(n) solution to precompute again with earliest finish time, but now perfectly calculating the max and min wherever required among all the possibilities. We compute minimum for one slide first and check for all possibilities with the other slide to get minimum there as well.


//    public static int earliestFinishTime(
//            int[] landStartTime,
//            int[] landDuration,
//            int[] waterStartTime,
//            int[] waterDuration
//    ) {
//        Arrays.sort(landStartTime);
//        Arrays.sort(waterStartTime);
//        int l = 0;
//        int r = 0;
//        int time = 0;
//        boolean landCheck = false;
//        boolean waterCheck = false;
//        while (l < landStartTime.length && landCheck == false || r < waterStartTime.length && waterCheck == false) {
//            if(landCheck == true || waterCheck == true){
//                break;
//            }
//            if(l < landStartTime.length && r < waterStartTime.length){
//                if(landStartTime[l] < waterStartTime[r] && landCheck == false){
//                    time += (landStartTime[l] + landDuration[l]);
//                    landCheck = true;
//                    l++;
//                } else if(waterStartTime[r] < landStartTime[l] && waterCheck == false){
//                    time += (waterStartTime[r] + waterDuration[r]);
//                    waterCheck = true;
//                    r++;
//                }
//                // equal start time for land and water
//                else {
//                    if(landDuration[l] < waterDuration[r]){
//                        time += (landStartTime[l] + landDuration[l]);
//                        landCheck = true;
//                        l++;
//                    } else {
//                        time += (waterStartTime[r] + waterDuration[r]);
//                        waterCheck = true;
//                        r++;
//                    }
//                }
//            }
//            else if(l < landStartTime.length  && landCheck == false){
//                time += (landStartTime[l] + landDuration[l]);
//                landCheck = true;
//                l++;
//            }
//            else if(r < waterStartTime.length && waterCheck == false){
//                time += (waterStartTime[r] + waterDuration[r]);
//                waterCheck = true;
//                r++;
//            }
//        }
//
//        // not fully correct
//        if(landCheck == false){
//            time += (landDuration[l]);
//            landCheck = true;
//
//
//        } else if(waterCheck == false){
//            time += (waterDuration[r]);
//            waterCheck = true;
//        }
//
//        return time;
//    }


//    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
//
//        int accumulator = 0;
//        int minIndexLeft = 0;
//        int minIndexRight = 0;
//        for(int i = 0; i < landStartTime.length; i++){
//            for(int j = 0; j < waterStartTime.length; j++){
//                if(landStartTime[i] < waterStartTime[j]){
//                    minIndexLeft = i;
//                } else {
//                    minIndexRight = j;
//                }
//            }
//        }
//
//        if(landStartTime[minIndexLeft] < waterStartTime[minIndexRight]){
//            accumulator += landStartTime[minIndexLeft] + landDuration[minIndexLeft];
//            if(accumulator < waterStartTime[minIndexRight]){
//                accumulator += waterStartTime[minIndexRight] - accumulator;
//            }
//            accumulator += waterDuration[minIndexRight];
//        } else {
//            accumulator += waterStartTime[minIndexRight] + waterDuration[minIndexRight];
//            if(accumulator < landStartTime[minIndexLeft]){
//                accumulator += landStartTime[minIndexLeft] - accumulator;
//            }
//            accumulator += landDuration[minIndexLeft];
//        }
//
//        return accumulator;
//    }

    // Earlist Finishing Ride Wrong Solution
//    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

//        Case 1: Picking Land Slide First
//        int min = landStartTime[0] + landDuration[0];
//        for(int i = 0; i < landStartTime.length; i++){
//            if(i == 0) continue;
//            if(landStartTime[i] + landDuration[i] < min){
//                min = landStartTime[i] + landDuration[i];
//            }
//        }
//
//        int accumulator = min;
//        if(min < waterStartTime[0]){
//            min += waterStartTime[0] - min;
//        }
//        min += waterDuration[0];
//        for(int i = 0; i < waterStartTime.length; i++){
//            if(i == 0) continue;
//            if(accumulator < waterStartTime[i]){
//                accumulator += (waterStartTime[i] - accumulator);
//            }
//            accumulator += waterDuration[i];
//            if(accumulator < min){
//                min = accumulator;
//            }
//        }
//        int caseOne = min;
//
//        Case 2: Picking Water Slide First
//        min = waterStartTime[0] + waterDuration[0];
//        for(int i = 0; i < waterStartTime.length; i++){
//            if(i == 0) continue;
//            if(waterStartTime[i] + waterDuration[i] < min){
//                min = waterStartTime[i] + waterDuration[i];
//            }
//        }
//
//        accumulator = min;
//        if(min < landStartTime[0]){
//            min += landStartTime[0] - min;
//        }
//        min += landDuration[0];
//        for(int i = 0; i < landStartTime.length; i++){
//            if(i == 0) continue;
//            if(accumulator < landStartTime[i]){
//                accumulator += (landStartTime[i] - accumulator);
//            }
//            accumulator += landDuration[i];
//            if(accumulator < min){
//                min = accumulator;
//            }
//        }
//        int caseTwo = min;
//
//        return Math.min(caseOne, caseTwo);
//    }
//

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int caseOne = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++){
            for(int j = 0; j < waterStartTime.length; j++){
                int accumulator = landStartTime[i] + landDuration[i];
                int chooser = Math.max(accumulator, waterStartTime[j]);
                caseOne = Math.min(caseOne, chooser + waterDuration[j]);
            }
        }
        int caseTwo = Integer.MAX_VALUE;
        for(int i = 0; i < waterStartTime.length; i++){
            for(int j = 0; j < landStartTime.length; j++){
                int accumulator = waterStartTime[i] + waterDuration[i];
                int chooser = Math.max(accumulator, landStartTime[j]);
                caseTwo = Math.min(caseTwo, chooser + landDuration[j]);
            }
        }
        return Math.min(caseOne, caseTwo);
    }

    public static int earliestFinishTimeOptimal(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landMini = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++){
            landMini = Math.min(landMini, landStartTime[i] + landDuration[i]);
        }
        int waterMini = Integer.MAX_VALUE;
        for(int i = 0; i < waterStartTime.length; i++){
            waterMini = Math.min(waterMini, waterStartTime[i] + waterDuration[i]);
        }
        int waitTime = 0;
        int caseOne = Integer.MAX_VALUE;
        for(int i = 0; i < waterStartTime.length; i++) {
            waitTime = Math.max(0, waterStartTime[i] - landMini);
            caseOne = Math.min(caseOne, landMini + waitTime + waterDuration[i]);
        }
        int caseTwo = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++) {
            waitTime = Math.max(0, landStartTime[i] - waterMini);
            caseTwo = Math.min(caseTwo, waterMini + waitTime + landDuration[i]);
        }
        return Math.min(caseOne, caseTwo);
    }

    public static void main(String[] args) {
        // test-case 1
        System.out.println(
                earliestFinishTime(new int[]{2,8},new int[]{4, 1},new int[]{6},new int[]{3})
        );

        // test-case 2
        System.out.println(
                earliestFinishTime(new int[]{5},new int[]{3},new int[]{1},new int[]{10})
        );

        // test-case 3
        System.out.println(
                earliestFinishTime(new int[]{99},new int[]{59},new int[]{99,54},new int[]{85,20})
        );

    }
}

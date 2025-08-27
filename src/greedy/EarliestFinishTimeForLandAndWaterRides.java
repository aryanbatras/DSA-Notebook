package greedy;

public class EarliestFinishTimeForLandAndWaterRides {


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

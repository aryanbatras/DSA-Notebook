package greedy.med;

import java.util.ArrayList;
import java.util.List;

public class GasStation {
//    There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i]. You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations. Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.
//
//    Example 1:
//    Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//    Output: 3
//    Explanation:
//    Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//    Travel to station 4. Your tank = 4 - 1 + 5 = 8
//    Travel to station 0. Your tank = 8 - 2 + 1 = 7
//    Travel to station 1. Your tank = 7 - 3 + 2 = 6
//    Travel to station 2. Your tank = 6 - 4 + 3 = 5
//    Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
//    Therefore, return 3 as the starting index.
//
//    Example 2:
//    Input: gas = [2,3,4], cost = [3,4,3]
//    Output: -1
//    Explanation:
//    You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
//    Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//    Travel to station 0. Your tank = 4 - 3 + 2 = 3
//    Travel to station 1. Your tank = 3 - 3 + 3 = 3
//    You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
//    Therefore, you can't travel around the circuit once no matter where you start.
//
//    Approach
//    Tried many approaches. Over-complicated the answer. Initially I tried to sort both arrays. It not always works. Then I tried to precompute starting position first, and then run a loop from there. The starting position is not always the maximum position here. Didn’t worked. Then I worked upon the kandane’s solution. Still not sure.


    // O(n^2) solution But Accepted Soln O(n)
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> maxGas = new ArrayList<Integer>();
        List<Integer> maxGasIndex = new ArrayList<Integer>();

        int nextIndex = 0;
        int currentGas = 0;
        int currentIndex = 0;
        int finalAnsIndex = -1;
        for(int i = 0; i < gas.length; i++) {
            if(gas[i] - cost[i] < 0){
                if(gas[(i + 1) % gas.length] - cost[(i + 1) % gas.length] >= 0){
                    maxGasIndex.add((i + 1) % gas.length);
                    maxGas.add(gas[(i + 1) % gas.length]);
                }
            } else {
                maxGasIndex.add(i);
                maxGas.add(gas[i]);
            }
        }
        for(int i = maxGas.size() - 1; i >= 0; i--) {
            int ansIndex = 0;
            currentGas = maxGas.get(i);
            currentIndex = maxGasIndex.get(i);
            nextIndex = (maxGasIndex.get(i) + 1) % gas.length;
            currentGas = currentGas - cost[currentIndex];
            if (currentGas < 0){
                ansIndex = -1;
            };
            currentGas = currentGas + gas[nextIndex];
            while (nextIndex != maxGasIndex.get(i)) {
                currentIndex = (currentIndex + 1) % gas.length;
                nextIndex = (nextIndex + 1) % gas.length;
                currentGas = currentGas - cost[currentIndex];
                if (currentGas < 0){
                    ansIndex = -1;
                };
                currentGas = currentGas + gas[nextIndex];
            }
            if(ansIndex != -1){
                return maxGasIndex.get(i);
            } else {
                finalAnsIndex = -1;
            }
        }
        return finalAnsIndex;
    }

    // O(n) solution
    public static int canCompleteCircuitOptimal(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startingIndex = 0;
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];
            if(currentGas < 0) {
                startingIndex = i + 1;
                currentGas = 0;
            }
        }
        if(totalGas < totalCost) {
            return -1;
        }
        return startingIndex;
    }
    public static void main(String[] args) {
        System.out.println(
                canCompleteCircuit(new int[]{5}, new int[]{4})
        );
        System.out.println(
                canCompleteCircuit(new int[]{4}, new int[]{5})
        );
        System.out.println(
                canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2})
        );
        System.out.println(
                canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2})
        );
        System.out.println(
                canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3})
        );
        System.out.println(
                canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1})
        );
        System.out.println(
                canCompleteCircuit(new int[]{1, 2}, new int[]{2, 1})
        );
        System.out.println(
                canCompleteCircuit(new int[]{4,5,2,6,5,3}, new int[]{3,2,7,3,2,9})
        );
    }
}



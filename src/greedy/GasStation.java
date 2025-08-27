package greedy;

import java.util.ArrayList;
import java.util.List;

public class GasStation {

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



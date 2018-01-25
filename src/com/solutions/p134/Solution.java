package com.solutions.p134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int start = -1;
        int netSum = 0;
        int subSum = 0;
        for (int i = 0; i < gas.length; i++) {
            netSum += gas[i] - cost[i];
            subSum += gas[i] - cost[i];
            if (subSum < 0 || start == -1) {
                if (gas[i] >= cost[i]) {
                    start = i;
                    subSum = gas[i] - cost[i];
                } else
                    start = -1;
            }
        }

        return netSum >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canCompleteCircuit(
                new int[]{6,1,4,3,5},
                new int[]{3,8,2,4,2}
        ));
    }
}

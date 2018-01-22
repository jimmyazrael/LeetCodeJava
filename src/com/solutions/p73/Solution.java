package com.solutions.p73;

import java.util.Arrays;

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowHas0 = false;
        boolean rowHas0 = false;

        for (int i = 0; i < matrix.length; i++) {
            rowHas0 = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRowHas0 = true;
                        break;
                    } else {
                        rowHas0 = true;
                        matrix[0][j] = 0;
                    }
                }
            }

            if (i > 0 && rowHas0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowHas0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] test = new int[][]{{1, 0, 7}, {2, 5, 8}, {0, 6, 9}};
        sol.setZeroes(test);
        for (int[] m : test)
            System.out.println(Arrays.toString(m));
    }
}

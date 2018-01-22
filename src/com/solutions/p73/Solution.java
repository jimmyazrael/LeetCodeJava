package com.solutions.p73;

import java.util.Arrays;

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowHas0 = false;
        boolean rowHas0 = false;

        int height = matrix.length;
        if (height == 0) return;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            rowHas0 = false;
            for (int j = 0; j < width; j++) {
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
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = 0;
                }
            }
        }


        for (int j = 0; j < width; j++) {
            for (int i = 1; i < height; i++) {
                if (matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        if (firstRowHas0) {
            for (int j = 0; j < width; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] test = new int[][]{{1, 0, 7, 4}, {2, 5, 3, 8}, {0, 6, 9, 2}};
        sol.setZeroes(test);
        for (int[] m : test)
            System.out.println(Arrays.toString(m));
    }
}

package com.solutions.p48;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) return;

        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j * 2 < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mat = new int[][]{{5, 1}, {2, 4}};
        sol.rotate(mat);
        for (int[] aMat : mat) {
            for (int j = 0; j < mat.length; j++) {
                System.out.printf("%d ", aMat[j]);
            }
            System.out.printf("%n");
        }
    }
}

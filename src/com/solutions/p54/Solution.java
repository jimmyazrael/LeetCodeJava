package com.solutions.p54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;

        int row = 0, col = 0;
        int height = matrix.length, width = matrix[0].length;
        int total = height * width;
        int minRow = 0, minCol = 0, maxCol = width - 1;
        int minSum = 1, maxSum = height + width - 2;

        while (res.size() < total) {
            while (row + col <= maxSum && row < height && col < width) {
                res.add(matrix[row][col]);
                if (col < maxCol) {
                    col++;
                } else {
                    row++;
                }
            }

            row--;
            col--;
            maxCol--;
            maxSum -= 2;
            minRow++;

            while (row + col >= minSum && row >= minRow && col >= minCol) {
                res.add(matrix[row][col]);
                if (col > minCol) {
                    col--;
                } else {
                    row--;
                }
            }

            row++;
            col++;
            minCol++;
            minSum += 2;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] test = new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        System.out.println(sol.spiralOrder(test));
    }
}

package com.solutions.p34;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = -1, right = -1, lo, hi, mid;
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                left = mid;
                right = mid;
                break;
            }
        }

        if (left != -1) {
            lo = 0;
            hi = left - 1;
            while (lo <= hi) {
                mid = (lo + hi) / 2;
                if (nums[mid] > target) {
                    hi = mid - 1;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    left = mid;
                    hi = left - 1;
                }
            }

            lo = right + 1;
            hi = nums.length - 1;
            while (lo <= hi) {
                mid = (lo + hi) / 2;
                if (nums[mid] > target) {
                    hi = mid - 1;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    right = mid;
                    lo = right + 1;
                }
            }
        }

        return new int[]{left, right};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test = new int[]{ 8, 8, 8, 8, 8, 8};
        System.out.println(Arrays.toString(sol.searchRange(test, 8)));
    }
}

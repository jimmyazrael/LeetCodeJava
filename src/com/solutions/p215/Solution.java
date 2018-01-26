package com.solutions.p215;

import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}

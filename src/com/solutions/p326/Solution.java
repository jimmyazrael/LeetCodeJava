package com.solutions.p326;

public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        else if (n == 1) return true;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfThree(3));
        System.out.println(sol.isPowerOfThree(32));
        System.out.println(sol.isPowerOfThree(243));
        System.out.println(sol.isPowerOfThree(1));
        System.out.println(sol.isPowerOfThree(0));
        System.out.println(sol.isPowerOfThree(-3));
    }

}



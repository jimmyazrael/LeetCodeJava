package com.solutions.p94;

import com.solutions.p102.TreeBuilder;
import com.solutions.p102.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> nodeStack = new ArrayDeque<>();

        TreeNode ptr = root;
        do {
            if (ptr.left != null) {
                nodeStack.push(ptr);
                ptr = ptr.left;
            } else {
                res.add(ptr.val);
                ptr = ptr.right;
                while (ptr == null && !nodeStack.isEmpty()) {
                    ptr = nodeStack.pop();
                    res.add(ptr.val);
                    ptr = ptr.right;
                }
            }
        } while (ptr != null);

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.inorderTraversal(TreeBuilder.arrayToTree(
                new Integer[]{1, 2, 3, 4, 5, 6, 7}
        )));
    }
}
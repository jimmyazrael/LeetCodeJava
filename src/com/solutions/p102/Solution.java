package com.solutions.p102;

import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queLen = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < queLen; i++) {
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                if (tmpNode.left != null) queue.add(tmpNode.left);
                if (tmpNode.right != null) queue.add(tmpNode.right);
            }

            res.add(tmpList);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeBuilder.arrayToTree(
                new Integer[]{3, 9, 20, null, 15, 7});

        System.out.println(sol.levelOrder(root));
    }
}

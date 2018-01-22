package com.solutions.p102;

import java.util.Stack;

public class TreeBuilder {
    public static TreeNode arrayToTree(Integer[] treeArray) {
        int numOfNodes = treeArray.length;
        TreeNode root;
        if (numOfNodes == 0) return null;
        else root = new TreeNode(treeArray[0]);

        int index;
        TreeNode ptr;
        Stack<Integer> idxStack = new Stack<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        idxStack.push(0);
        nodeStack.push(root);
        while (!idxStack.empty()) {
            index = idxStack.pop();
            ptr = nodeStack.pop();
            int leftIdx = index * 2 + 1;
            int rightIdx = index * 2 + 2;

            if (leftIdx < numOfNodes && treeArray[leftIdx] != null){
                ptr.left = new TreeNode(treeArray[leftIdx]);
                nodeStack.push(ptr.left);
                idxStack.push(leftIdx);
            }
            if (rightIdx < numOfNodes && treeArray[rightIdx] != null){
                ptr.right = new TreeNode(treeArray[rightIdx]);
                nodeStack.push(ptr.right);
                idxStack.push(rightIdx);
            }
        }

        return root;
    }
}

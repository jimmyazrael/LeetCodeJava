package com.solutions.p19;

public class SimpleLinkedList {
    public static ListNode arrayToLinkedList(Integer[] intArray) {
        ListNode root = null;
        ListNode ptr = null;

        for (Integer i : intArray) {
            if (ptr == null) {
                ptr = new ListNode(i);
                root = ptr;
            } else {
                ptr.next = new ListNode(i);
                ptr = ptr.next;
            }
        }
        return root;
    }

    public static String linkedlistToString(ListNode root) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        while (root != null) {
            if (isFirst) {
                isFirst = false;
                sb.append(root.val);
            } else {
                sb.append("->");
                sb.append(root.val);
            }
            root = root.next;
        }
        return sb.toString();
    }
}

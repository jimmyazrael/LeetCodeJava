package com.solutions.p19;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowPtr = new ListNode(0);
        slowPtr.next = head;
        ListNode fastPtr = slowPtr;

        for (int i = 0; i < n + 1; i++) {
            fastPtr = fastPtr.next;
        }

        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        if (slowPtr.next == head) {
            return head.next;
        } else {
            slowPtr.next = slowPtr.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode test = SimpleLinkedList.arrayToLinkedList(
                new Integer[]{1,2});
        Solution sol = new Solution();
        test = sol.removeNthFromEnd(test, 2);
        System.out.println(SimpleLinkedList.linkedlistToString(test));
    }
}

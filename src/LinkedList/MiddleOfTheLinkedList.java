package LinkedList;

import java.util.ArrayList;
import java.util.List;


public class MiddleOfTheLinkedList {

    // the mid changes every other step
    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        ListNode end = head;

        while (end != null && end.next != null) {
            mid = mid.next;
            end = end.next.next;
        }

        return mid;
    }

    public ListNode middleNodeWithArrays(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        do {
            list.add(head);
            head = head.next;
        } while (head != null);

        int index = list.size() / 2;
        return list.get(index);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem2 {
    public ListNode add(ListNode l1, ListNode l2, boolean hasCarry) {
        ListNode lNode = new ListNode();
        boolean hasCarry2 = false;

        int v = l1.val + l2.val + (hasCarry ? 1 : 0);

        if(v >= 10) {
            hasCarry2 = true;
            v -= 10;
        }

        lNode.val = v;

        if (l1.next == null && l2.next == null) {
            if (hasCarry2) lNode.next = new ListNode(1);

            return lNode;
        }

        lNode.next = add(
                l1.next != null ? l1.next : new ListNode(0),
                l2.next != null ? l2.next : new ListNode(0),
                hasCarry2);

        return lNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, false);
    }
}

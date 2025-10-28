class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problem2 {
    String ListNodeToString(ListNode node) {
        if(node.next != null) return ListNodeToString(node.next) + node.val;

        return ""+node.val;
    }
    ListNode StringToListNode(String s) {
        ListNode node = null;

        for (int i = 0; i < s.length(); i++) {
            ListNode temp = new ListNode(Integer.parseInt("" + s.charAt(i)));

            if (node != null)
                temp.next = node;

            node = temp;
        }

        return node;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = Integer.parseInt(ListNodeToString(l1));
        int b = Integer.parseInt(ListNodeToString(l2));

        int v = a + b;

        return StringToListNode(""+v);
    }
}

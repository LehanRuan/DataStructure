package LinkList;

import java.util.List;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        ListNode p1;
        ListNode p2;
        ListNode temp;
        while (cur.next != null && cur.next.next != null) {
            p1 = cur.next;
            p2 = cur.next.next;
            temp = cur.next.next;
            cur.next = p2;
            p2.next = p1;
            p1.next = temp;
        }

        return dummyNode.next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummpNode = new ListNode(-1);
        dummpNode.next = head;
        ListNode cur = dummpNode;
        process(cur);
        return dummpNode.next;
    }

    public void process(ListNode cur) {
        if (cur.next == null) {
            return;
        }
        if  (cur.next.next!= null) {
            ListNode l1 = cur.next;
            ListNode l2 = cur.next.next;
            ListNode temp = l2.next;
            cur.next = l2;
            l2.next = l1;
            l1.next = temp;
            process(cur);
        } else {
            return;
        }
    }
}


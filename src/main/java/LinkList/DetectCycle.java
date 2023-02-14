package LinkList;

import java.util.List;

//leetcode address: https://leetcode.cn/problems/linked-list-cycle-ii/submissions/
public class DetectCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = head;
        ListNode result = DetectCycle.detectCycle(head);
        System.out.println(result.val);
    }

    //error v1 while循环的条件若已经相交的两个节点已经是入环节点就没必要往下继续寻找入环节点了；
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode head1 = head;
                ListNode head2 = fast;

                while (true) {
                    head1 = head1.next;
                    head2 = head2.next;
                    if (head1 == head2) {
                        return head1;
                    }
                }
            }
        }
        return null;
    }

    //right v1
    public static ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //寻找两节点相交即为判断链表是否有环
            if (slow == fast) {
                ListNode head1 = head;
                ListNode head2 = fast;
//                如果有环就让两节点一个从头节点开始往下走,一个从相交处往下走,直到两节点相交即入环节点
                while (true) {
                    head1 = head1.next;
                    head2 = head2.next;
                    if (head1 == head2) {
                        return head1;
                    }
                }
            }
        }
        return null;
    }
}

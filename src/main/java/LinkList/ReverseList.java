package LinkList;

import java.util.List;

public class ReverseList {

    //双指针法
    public static ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = null;
        while (cur != null) {
            //存储下一个节点的值
            temp = cur.next;
            //翻转链表
            cur.next = pre;
            //重新赋值
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //递归法
    public  static ListNode reverseList2(ListNode head) {
        return process(head, null);
    }
    public static ListNode process(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
        return process(cur, pre);
    }
}


package LinkList;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //永远指向cur的前一个位置
        ListNode pre = dummyNode;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            //只有没删除元素时需要往后移动pre
            if(cur.val == val) {
                pre.next = temp;
            } else {
                pre = cur;
            }
            //让cur指向下一个位置
            cur = temp;
        }
        return dummyNode.next;
    }
}

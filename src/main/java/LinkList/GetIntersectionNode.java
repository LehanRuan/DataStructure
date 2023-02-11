package LinkList;

/*&leetcode address:https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/

   这题需要注意判断相等的条件是地址而不是元素的值！！！
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode temp = headA;
        ListNode result = null;
        //算出A链表的长度
        while(temp != null) {
            temp = temp.next;
            lenA++;
        }
        temp = headB;
        //算出B链表的长度
        while (temp != null) {
            temp = temp.next;
            lenB++;
        }
        //如果lenA大于lenB就交换头节点，并且交换长度
        int len = lenA - lenB;
        //lenA长
        if (len > 0) {
            while (len > 0) {
                headA = headA.next;
                len--;
            }
            //lenB比较长
        } else {
            while (len < 0) {
                headB = headB.next;
                len++;
            }
        }

        //判断是否相等
        while (headA != null) {
            if (headA == headB) {
                result = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return result;
    }
}

package LinkList;

// leetcode address: https://leetcode.c\n/problems/remove-nth-node-from-end-of-list/
public class RemoveNthFromEnd {

    /*思路：
        快指针与慢指针相差n个位置，当快指针指向空位置的时候，慢指针指向需要删除的位置的前一个位置！
        再让慢指针指向他的下下个节点即可
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummpyNode = new ListNode(-1);
        dummpyNode.next = head;
        ListNode fast = dummpyNode;
        ListNode low = dummpyNode;
        int flag = n;
        while (flag > 0) {
            fast = fast.next;
            flag--;
        }

        while(fast.next != null) {
            fast = fast.next;
            low = low.next;
        }

        low.next = low.next.next;
        return dummpyNode.next;
    }
}

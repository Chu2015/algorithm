package leetCode;

/**
 * Created by chupengcheng on 2021/7/19.
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next !=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode slow1 = head;
                ListNode slow2 = slow;
                while (slow1 != slow2) {
                    slow1 = slow1.next;
                    slow2 = slow2.next;
                }
                return slow1;
            }
        }

        return null;

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

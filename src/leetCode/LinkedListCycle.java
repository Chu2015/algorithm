package leetCode;

/**
 * Created by chupengcheng on 2021/6/18.
 */
public class LinkedListCycle {

    //1、错误的使用递归
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        } else  {
//            ListNode nextListNode = head.next;
//            if (hasCycle(nextListNode)) {
//                return true;
//            } else {
//                return canReachAgain(head);
//            }
//        }
//    }

    //2、耗时过大
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//
//        if (canReachAgain(head)) {
//            return true;
//        } else  {
//            return hasCycle(head.next);
//        }
//    }

    //3、快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next !=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private boolean canReachAgain(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode first = head;
        while (head.next != null) {
            if (head.next == first) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        LinkedListCycle linkedListCycle = new LinkedListCycle();

        System.out.println(linkedListCycle.hasCycle(node1));

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

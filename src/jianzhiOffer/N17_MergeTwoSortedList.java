package jianzhiOffer;

/**
 * Created by chupengcheng on 2022/4/30.
 */
public class N17_MergeTwoSortedList {

    /**
     * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
     数据范围： 0 \le n \le 10000≤n≤1000，-1000 \le 节点值 \le 1000−1000≤节点值≤1000
     要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode result = null;
        ListNode traverseNode = null;
        ListNode staticNode = null;
        if (list1.val <= list2.val) {
            result = list1;
            traverseNode = list1;
            staticNode = list2;
        } else {
            result = list2;
            traverseNode = list2;
            staticNode = list1;
        }

        while (traverseNode != null && staticNode != null) {
            while (traverseNode.next != null && traverseNode.next.val <= staticNode.val) {
                traverseNode = traverseNode.next;
            }
            ListNode temp = traverseNode.next;
            traverseNode.next = staticNode;
            traverseNode = staticNode;
            staticNode = temp;
        }

        return result;
    }


    public ListNode Merge2(ListNode list1,ListNode list2) {
            if(list1 == null){
                return list2;
            }
            if(list2 == null){
                return list1;
            }

            ListNode mergeHead= new ListNode(0);
            ListNode mergeTail = mergeHead;
            while(list1!=null && list2!=null){
                if(list1.val<list2.val){
                    mergeTail.next = list1;
                    list1 = list1.next;
                }else{
                    mergeTail.next = list2;
                    list2 = list2.next;
                }
                mergeTail = mergeTail.next;
            }
            if(list2!=null){
                mergeTail.next = list2;
            }
            if(list1!=null){
                mergeTail.next = list1;
            }
            return mergeHead.next;
    }

    //recursively
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //boundary condition
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {

    }

}

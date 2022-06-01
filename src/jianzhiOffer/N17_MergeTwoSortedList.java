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

        ListNode result = list1.val <= list2.val ? list1 : list2;

        while (list1 != null && list2 != null) {
            while (list1.next != null && list1.next.val <= list2.val) {
                list1 = list1.next;
            }
            ListNode temp = list1.next;
            list1.next = list2;
            list1 = temp;
            while (list2.next != null && list2.next.val <= list1.val) {
                list2 = list2.next;
            }
            ListNode temp2 = list2.next;
            list2.next = list1;
            list2 = temp2;
        }

        return result;
    }

    public ListNode MergeRecursivel(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

       if (l) {

       }


        return result;
    }

}

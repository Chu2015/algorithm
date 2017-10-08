package zzz_BiShiTi;


public class ≈–∂œ¡¥±Ì”–ª∑ {

	public boolean hasHuan(ListNode node) {
		if(node==null || node.next==null) {
			return false;
		}
		ListNode fast = node;
		ListNode slow = node;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return !(fast==null || fast.next==null);	
	}
	
	public static void main(String[] args) {
		
	}
	
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
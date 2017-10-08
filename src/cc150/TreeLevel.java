package cc150;

import java.util.*;

public class TreeLevel {
    public ListNode getTreeLevel(TreeNode root, int dep) {
    	if(root==null) {
    		return null;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	Queue<TreeNode> queue2 = null;
    	queue.offer(root);
    	
    	while(--dep>0) {
    		queue2 = new LinkedList<TreeNode>();
    		while(!queue.isEmpty()) {
    			TreeNode node = queue.poll();
    			if(node.left!=null) {
    				queue2.offer(node.left);
    			}
    			if(node.right!=null) {
    				queue2.offer(node.right);
    			}
    		}	
			queue = queue2;
    	}
    	ListNode head = new ListNode(0);
    	ListNode tail = head;
    	while(!queue.isEmpty()) {
    		tail.next = new ListNode(queue.poll().val);
    		tail = tail.next;
    	}
    	
        return head.next;
    }
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(0);
    	root.left = new TreeNode(1);
    	root.left.left = new TreeNode(3);
    	root.left.right = new TreeNode(4);
    	root.right = new TreeNode(2);
    	root.right.left = new TreeNode(5);
    	root.right.right = new TreeNode(6);
    	TreeLevel tl = new TreeLevel();
    	ListNode  result = tl.getTreeLevel(root, 1);
    	while(result!=null) {
    		System.out.println(result.val);
    		result = result.next;
    	}
	}
}
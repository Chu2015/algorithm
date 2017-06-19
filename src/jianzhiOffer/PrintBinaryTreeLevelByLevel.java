package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTreeLevelByLevel {
	
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	if(root==null){
    		return null;
    	}
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		TreeNode cur =  queue.poll();
    		list.add(cur.val);
    		if(cur.left!=null){
    			queue.offer(cur.left);
    		}
    		if(cur.right!=null){
        		queue.offer(cur.right);
    		}
    	}
		return list;
    }
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(6);
    	root.right.right  = new TreeNode(7);
    	
    	PrintBinaryTreeLevelByLevel p = new PrintBinaryTreeLevelByLevel();
    	
    	ArrayList<Integer> list = p.PrintFromTopToBottom(root);
    	
    	for(int i:list){
    		System.out.println(i+" ");
    	}
    	
    }
    
}

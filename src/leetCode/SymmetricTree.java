package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chupengcheng on 2021/7/20.
 */
public class SymmetricTree {

    // recursively
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return false;
//        }
//        return isSymmetric(root.left, root.right);
//    }
//
//    public boolean isSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
//        if (leftRoot == null && rightRoot == null) {
//            return true;
//        }
//        if (leftRoot == null || rightRoot == null || !(leftRoot.val == rightRoot.val)) {
//            return false;
//        }
//
//        return isSymmetric(leftRoot.left, rightRoot.right) && isSymmetric(leftRoot.right, rightRoot.left);
//    }

    //iteratively-using two queue
    public boolean isSymmetric(TreeNode root) {

        TreeNode left = root.left;
        TreeNode right = root.right;

        Queue<TreeNode> queue1 = new LinkedList();
        queue1.offer(left);
        Queue<TreeNode> queue2 = new LinkedList();
        queue2.offer(right);

        //以队列是否都有元素作为判断指标
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            //出队列
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            //进行校验操作
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            //放入队列
            queue1.offer(node1.left);
            queue1.offer(node1.right);
            queue2.offer(node2.right);
            queue2.offer(node2.left);
        }

        return true;
    }

    //iteratively-using one queue
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(treeNode));
    }




    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}





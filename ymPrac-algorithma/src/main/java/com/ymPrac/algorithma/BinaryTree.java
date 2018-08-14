package com.ymPrac.algorithma;

import javax.xml.transform.TransformerException;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Yan Meng
 * @date 2018/8/14.
 */
public class BinaryTree {

    public TreeNode createPre(LinkedList<Object> rowData) {
        TreeNode root = null;
        Object o = rowData.removeFirst();
        if (o != null) {
            root = new TreeNode(o, null, null);
            root.left = createPre(rowData);
            root.right = createPre(rowData);
        }
        return root;
    }

    public void preSearch(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preSearch(root.left);
            preSearch(root.right);
        }
    }

    public void pre(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                System.out.println(root.val);
                stack.push(root);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
    }


    public void midSearch(TreeNode root) {
        if (root != null) {
            midSearch(root.left);
            System.out.println(root.val);
            midSearch(root.right);
        }
    }

    public void backSearch(TreeNode root) {
        if (root != null) {
            backSearch(root.left);
            backSearch(root.right);
            System.out.println(root.val);
        }
    }




    class TreeNode {
        Object val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(Object val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

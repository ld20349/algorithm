package datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;

    /**
     * 新建一棵二叉树 A B C D E F
     */
    public BinaryTree() {
        root = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }

    public int size() {
        return size(root);
    }

    private int size(TreeNode node) {
        return node == null ? 0 : 1 + size(node.left) + size(node.right);
    }

    public TreeNode parent(TreeNode node) {
        return parent(root, node);
    }

    private TreeNode parent(TreeNode root, TreeNode node) {
        if (root == null)
            return null;
        if (root.left == node || root.right == node)
            return root;
        TreeNode l = parent(root.left, node);
        return l != null ? l : parent(root.right, node);
    }

    public TreeNode getLeftChildNode(TreeNode node) {
        return node == null ? null : node.left;
    }

    public TreeNode getRightChildNode(TreeNode node) {
        return (node == null) ? null : node.right;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void destory() {
        destory(root);
    }

    public void destory(TreeNode node) {
        if (node != null) {
            destory(node.left);
            destory(node.right);
            node = null;
        }
    }

    /**
     * 递归先序遍历 结果应为：A B D E C F
     */
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /**
     * 递归中序遍历 结果应为：D B E A C F
     */
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null)
            return;
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    /**
     * 递归后序遍历 结果应为：D E B F C A
     */
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(TreeNode node) {
        if (node == null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * 非递归先序遍历，借用栈来实现
     */
    public void preorderTraversalNonRecursive() {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p != null || !s.empty()) {
            while (p != null) {
                System.out.print(p.data + " ");
                s.push(p);
                p = p.left;
            }
            if (!s.empty())
                p = s.pop().right;
        }
    }

    /**
     * 非递归中序遍历，借用栈来实现
     */
    public void inorderTraversalNonRecursive() {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p != null || !s.empty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            if (!s.empty()) {
                p = s.pop();
                System.out.print(p.data + " ");
                p = p.right;
            }
        }
    }

    /**
     * 非递归后序遍历，借用栈来实现
     */
    public void postorderTraversalNonRecursive() {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode cur;
        TreeNode pre = null;
        while (!s.empty()) {
            cur = s.peek();
            if ((cur.left == null && cur.right == null)
                    || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.print(cur.data + " ");
                s.pop();
                pre = cur;
            } else {
                if (cur.right != null)
                    s.push(cur.right);
                if (cur.left != null)
                    s.push(cur.left);
            }
        }
    }

    /**
     * 广度优先遍历（层序遍历），借用队列来实现 结果应为：A B C D E F
     */
    public void breadthFirstTraversal() {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode p = q.poll();
            System.out.print(p.data + " ");
            if (p.left != null)
                q.offer(p.left);
            if (p.right != null)
                q.offer(p.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.preorderTraversal();
        System.out.println();
        tree.inorderTraversal();
        System.out.println();
        tree.postorderTraversal();
    }
}

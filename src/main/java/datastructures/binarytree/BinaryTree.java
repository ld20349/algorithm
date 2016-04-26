package datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private TreeNode root;

	/**
	 * 新建一棵二叉树
	 *           A 
     *     B          C 
     *  D     E            F
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

	public TreeNode parent(TreeNode element) {
		return parent(root, element);
	}

	private TreeNode parent(TreeNode subTree, TreeNode element) {
		if (subTree == null)
			return null;
		if (subTree.left == element || subTree.right == element)
			return subTree;
		TreeNode p = parent(subTree.left, element);
		return p != null ? p : parent(subTree.right, element);
	}

	public TreeNode getLeftChildNode(TreeNode element) {
		return element == null ? null : element.left;
	}

	public TreeNode getRightChildNode(TreeNode element) {
		return (element == null) ? null : element.right;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void destroy(TreeNode subTree) {
		if (subTree != null) {
			destroy(subTree.left);
			destroy(subTree.right);
			subTree = null;
		}
	}

	private void preorderTraversal(TreeNode subTree) {
		if (subTree == null)
			return;
		System.out.print(subTree.data + " ");
		preorderTraversal(subTree.left);
		preorderTraversal(subTree.right);
	}

	private void inorderTraversal(TreeNode subTree) {
		if (subTree == null)
			return;
		inorderTraversal(subTree.left);
		System.out.print(subTree.data + " ");
		inorderTraversal(subTree.right);
	}

	private void postorderTraversal(TreeNode subTree) {
		if (subTree == null)
			return;
		postorderTraversal(subTree.left);
		postorderTraversal(subTree.right);
		System.out.print(subTree.data + " ");
	}

	/**
	 * 递归先序遍历
	 */
	public void preorderTraversal() {
		preorderTraversal(root);
	}

	/**
	 * 递归中序遍历
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
	}

	/**
	 * 递归后序遍历
	 */
	public void postorderTraversal() {
		postorderTraversal(root);
	}

	/**
	 * 非递归先序遍历，借用栈来实现
	 */
	public void preorderTraversalNonRecursive() {
		Stack<TreeNode> s = new Stack<>();
		TreeNode p = root;
		while (p != null || !s.isEmpty()) {
			while (p != null) {
				System.out.print(p.data + " ");
				s.push(p);
				p = p.left;
			}
			if (!s.isEmpty()) {
				p = s.pop().right;
			}
		}
	}

	/**
	 * 非递归中序遍历，借用栈来实现
	 */
	public void inorderTraversalNonRecursive() {
		Stack<TreeNode> s = new Stack<>();
		TreeNode p = root;
		while (p != null || !s.isEmpty()) {
			while (p != null) {
				s.push(p);
				p = p.left;
			}
			if (!s.isEmpty()) {
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
		TreeNode cur = null;
		TreeNode pre = null;
		s.push(root);
		while (!s.isEmpty()) {
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
	 * 广度优先遍历（层序遍历），借用队列来实现
	 */
	public void breadthFirstTraversal() {
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			System.out.print(p.data + " ");
			if (p.left != null)
				queue.add(p.left);
			if (p.right != null)
				queue.add(p.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.breadthFirstTraversal();
	}
}

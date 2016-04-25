package datastructures.binarytree;

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

	public void preOrder(TreeNode subTree) {
		if (subTree == null)
			return;
		System.out.println(subTree.data);
		preOrder(subTree.left);
		preOrder(subTree.right);
	}

	public void inOrder(TreeNode subTree) {
		if (subTree == null)
			return;
		inOrder(subTree.left);
		System.out.println(subTree.data);
		inOrder(subTree.right);
	}

	public void postOrder(TreeNode subTree) {
		if (subTree == null)
			return;
		postOrder(subTree.left);
		postOrder(subTree.right);
		System.out.println(subTree.data);
	}
}

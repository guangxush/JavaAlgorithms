package cn.shgx.binarytreenode;

public class BinaryTree {
	private BinaryTreeNode root;
	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}
	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}
	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	/**
	 * 清空某个子树的所有节点
	 * @param node
	 */
	public void clear(BinaryTreeNode node) {
		if(node!=null) {
			clear(node.getLeftChild());//递归删除左节点
			clear(node.getRightChild());//递归删除右节点
			node = null;//删除节点
		}
	}
	/**
	 * 清空树
	 */
	public void clear() {
		clear(root);
	}
	/**
	 * 判断二叉树是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return root==null;
	}
	/**
	 * 调用求高度算法，获取根节点的高度
	 * @return
	 */
	public int height() {
		return height(root);
	}
	/**
	 * 获取某节点为子树的高度
	 * @param node
	 * @return
	 */
	public int height(BinaryTreeNode node) {
		if(node == null) {
			return 0;//递归结束。空子树的高度为0
		}else {
			//递归获取左子树的高度
			int l = height(node.getLeftChild());
			//递归获取右子树的高度
			int r = height(node.getRightChild());
			//高度是更高的一边，加上自己本身一层的高度因此需要加一
			return l<r?r+1:l+1;
		}
	}
	/**
	 * 获取二叉树的节点数
	 * @return
	 */
	public int size() {
		return size(root);
	}
	public int size(BinaryTreeNode node) {
		if(node==null) {
			//如果节点为空，那么返回节点数为0
			return 0;
		}else {
			//递归左子树和右子树的节点数
			//需要计算本节点，所以需要加一
			return 1+size(node.getLeftChild())+size(node.getRightChild());
		}
	}
	/**
	 * 查找node节点在二叉树中的父节点
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode node) {
		return (root==null||root==node)?null:getParent(root,node);
	}
	/**
	 * 查找node节点在二叉树中的父节点
	 * @param subTree
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode subTree,BinaryTreeNode node) {
		if(subTree == null) {
			//如果子树为空，那么没有父节点
			return null;
		}
		if(subTree.getLeftChild()==node||subTree.getRightChild()==node) {
			//如果子树的左右节点之一是待查节点，那么子树的根节点即为待查节点的父节点
			return subTree;
		}
		BinaryTreeNode parent = null;
		//先递归左子树
		if((parent=getParent(subTree.getLeftChild(),node))!=null) {
			return parent;
		}else {
			//递归在右子树找
			return getParent(subTree.getRightChild(), node);
		}
	}
	/**
	 * 获取某个节点的左子树
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getLeftTree(BinaryTreeNode node) {
		return node.getLeftChild();
	}
	/**
	 * 获取某个节点的右子树
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getRightTree(BinaryTreeNode node) {
		return node.getRightChild();
	}
	/**
	 * 给某节点插入子节点
	 * 当这个节点本身含有子节点的时候，会覆盖原来的节点
	 * 插入的节点本身可能还有子节点，因此可能插入的是树
	 * @param parent
	 * @param newNode
	 */
	public void insertLeft(BinaryTreeNode parent,BinaryTreeNode newNode) {
		parent.setLeftChild(newNode);
	}
	/**
	 * 给某节点插入右节点
	 * @param parent
	 * @param newNode
	 */
	public void insertRight(BinaryTreeNode parent,BinaryTreeNode newNode) {
		parent.setRightChild(newNode);
	}
	/**
	 * 访问当前节点，并输出其值
	 * @param node
	 */
	public void visited(BinaryTreeNode node) {
		System.out.println(node.getData());
	}
	/**
	 * 先根遍历:根左右
	 * @param node
	 */
	public void preOrder(BinaryTreeNode node) {
		if(node!=null) {
			visited(node);
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	/**
	 * 中序遍历：左根右
	 * @param node
	 */
	public void inOrder(BinaryTreeNode node) {
		if(node!=null) {
			inOrder(node.getLeftChild());
			visited(node);
			inOrder(node.getRightChild());
		}
	}
	/**
	 * 后序遍历：左右根
	 * @param node
	 */
	public void postOrder(BinaryTreeNode node) {
		if(node!=null) {
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			visited(node);
		}
	}
}

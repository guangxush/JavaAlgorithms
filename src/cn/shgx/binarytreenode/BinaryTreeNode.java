package cn.shgx.binarytreenode;
//二叉树的左右链表示法
public class BinaryTreeNode {
	private int data;//数据
	private BinaryTreeNode leftChild;//左孩子
	private BinaryTreeNode rightChild;//右孩子
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryTreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
}
//二叉树的数组表示法
/*public class BinaryTreeNode2{
	private int leftChild;
	private int rightChild;
	public int getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(int leftChild) {
		this.leftChild = leftChild;
	}
	public int getRightChild() {
		return rightChild;
	}
	public void setRightChild(int rightChild) {
		this.rightChild = rightChild;
	}
}
*/
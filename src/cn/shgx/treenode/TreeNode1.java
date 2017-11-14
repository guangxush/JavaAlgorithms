package cn.shgx.treenode;

public class TreeNode1 {
	private int data;//节点上存储的数据
	private int parent;//节点的父节点（一个节点只有一个父节点）
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
}

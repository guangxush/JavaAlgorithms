package cn.shgx.graph;

public class ListGraphNode {
	int index;
	//值
	int value;
	//指向下一节点的指针（引用）
	ListGraphNode next;
	public ListGraphNode(int value ,ListGraphNode next) {
		this.value = value;
		this.next = next;
	}
	public ListGraphNode(int index,int value ,ListGraphNode next) {
		this.index = index;
		this.value = value;
		this.next = next;
	}
}

package cn.shgx.staticlink;

public class Element {
	private int data;//用于记录当前元素的数据
	private int cur;//用于记录指向下一个节点的位置
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getCur() {
		return cur;
	}
	public void setCur(int cur) {
		this.cur = cur;
	}
	
}

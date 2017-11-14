package cn.shgx.queue;

public class ArrayQueue {
	private final Object[] items ;//= new Object[0];
	private int head = 0;//表示队头，出队列需要从何这个位置，然后head后移
	private int tail = 0;//表示队尾，新插入的元素放到这个位置，然后tail后移
	/**
	 * 初始化队列
	 * @param capacity队列长度
	 */
	public ArrayQueue(int capacity) {
		this.items = new Object[capacity];
	}
	/**
	 * 入队
	 * @param item
	 * @return
	 */
	public boolean put (Object item) {
		if(head==(tail+1)%items.length) {
			return false;//队列已满,队列要保留一个空位置
		}
		items[tail]=item;//元素放入队尾位置
		tail = (tail+1)%items.length;//队尾tail往后移动
		return true;
	}
	/**
	 * 获取队头元素不出队
	 * @return
	 */
	public Object peek() {
		if(head==tail) {
			//说明队空
			return null;
		}
		return items[head];
	}
	/**
	 * 出队
	 * @return
	 */
	public Object pull() {
		if(head==tail) {
			return null;//队空
		}
		Object item  = items[head];
		items[head]=null;//把出队的元素置空值
		head = (head+1)%items.length;//head标记往后移动一位
		return item;
	}
	public boolean isFull() {
		return head==(tail+1)%items.length;
	}
	public boolean isEmpty() {
		return head == tail;
	}
	/**
	 * 队列的元素个数
	 * @return
	 */
	public int size() {
		if(tail>head) {
			return tail-head;
		}else {
			return tail+items.length-head;
		}
	}
}

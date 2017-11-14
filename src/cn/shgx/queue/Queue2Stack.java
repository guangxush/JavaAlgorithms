package cn.shgx.queue;
/**
 * 队列实现栈
 * 入栈：两个队列中哪个不为空，就把元素全部放入哪个队列，如果都为空，就任选一个入队，假设是queue1
 * 出栈：把不为空的队列中除去最后一个元素，其他元素都放入另一个队列中，然后最后一个元素出队
 * @author Consule
 *
 */
public class Queue2Stack {
	private ArrayQueue queue1;
	private ArrayQueue queue2;
	private int maxLength;
	public Queue2Stack(int capacity) {
		maxLength = capacity;
		queue1 = new ArrayQueue(capacity);
		queue2 = new ArrayQueue(capacity);
	}
	public int size() {
		return queue1.size()+queue2.size();
	}
	/**
	 * 入栈
	 * @param item
	 * @return 入栈结果
	 */
	public boolean push(int item) {
		if(size()==maxLength) {
			return false;
		}
		if(queue2.isEmpty()) {
			queue1.put(item);
		}else {
			queue2.put(item);
		}
		return true;
	}
	/**
	 * 出栈
	 * @return
	 */
	public Object pop() {
		if(size()==0) {
			throw new IndexOutOfBoundsException("栈为空");
		}else {
			if(queue2.isEmpty()) {
				while(queue1.size()>1) {
					queue2.put(queue1.pull());
				}
				return queue1.pull();
			}else{
				while(queue2.size()>1) {
					queue1.put(queue2.pull());
				}
				return queue2.pull();
			}
		}
		
	}
}

package cn.shgx.stack;
/**
 * 两个栈实现队列
 * 入队：直接把元素压入Stack1中
 * 出队：如果Stack2不为空，直接弹出Stack2中的元素，如果Stack2为空，则将Stack1所有的元素倒入Stack2中
 *     然后弹出栈顶元素，同样，如果两个栈都为空则队列为空队列，无法出队
 * @author Consule
 *
 */
public class Stack2Queue {
	private Stack stack1;
	private Stack stack2;
	private int maxLength;
	public Stack2Queue(int capacity) {
		maxLength = capacity;
		stack1 = new Stack(capacity);
		stack2 = new Stack(capacity);
	}
	public boolean put(int item) {
		if(stack1.isFull()||maxLength==size()) {
			return false;//栈满了
		}
		stack1.push(item);
		return true;
	}
	public int pull() {
		if(!stack2.isEmpty()) {
			return stack2.pop();
		}else {
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());//将stack1的元素弹出放入stack2
			}
			return stack2.pop();
		}
	}
	public int size() {
		return stack1.size()+stack2.size();
	}
}

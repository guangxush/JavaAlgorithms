package cn.shgx.stack;

public class Stack2QueueTest {
	public static void main(String[] args) {
		Stack2Queue queue = new Stack2Queue(5);
		queue.put(1);
		queue.put(2);
		System.out.println(queue.pull());//1
		queue.put(3);
		queue.put(4);
		System.out.println(queue.pull());//2
		System.out.println(queue.pull());//4
	}
}

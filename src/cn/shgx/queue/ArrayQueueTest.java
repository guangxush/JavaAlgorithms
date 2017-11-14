package cn.shgx.queue;

public class ArrayQueueTest {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(4);
		System.out.println(queue.put("A"));
		System.out.println(queue.put("B"));
		System.out.println(queue.put("C"));
		System.out.println(queue.put("D"));
		System.out.println(queue.isFull());
		System.out.println(queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.isEmpty());
	}
}

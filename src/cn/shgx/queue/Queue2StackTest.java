package cn.shgx.queue;

public class Queue2StackTest {
	public static void main(String[] args) {
		Queue2Stack stack = new Queue2Stack(5);
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}

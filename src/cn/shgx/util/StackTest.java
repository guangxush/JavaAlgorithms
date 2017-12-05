package cn.shgx.util;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("a");
		stack.push("b");
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}

}

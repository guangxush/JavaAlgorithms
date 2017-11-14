package cn.shgx.staticlink;

public class StaticLinkedListTest {
	public static void main(String[] args) {
		StaticLinkedList link = new StaticLinkedList(10);
		link.insertFirst(1);
		link.insertFirst(2);
		link.insertLast(4);
		link.insertLast(5);
		link.insert(3, 1);//在下标元素为1的地方插入3
		System.out.println("----------");
		link.printAll();
		link.deleteFirst();
		link.deleteLast();
		link.delete(1);
		System.out.println("----------");
		link.printAll();
		System.out.println("----------");
		System.out.println(link.get(1).getData());
		System.out.println("----------");
		link.deleteFirst();
		link.deleteLast();
		System.out.println(link.size());
	}
}

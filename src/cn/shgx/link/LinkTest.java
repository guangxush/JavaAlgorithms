package cn.shgx.link;

public class LinkTest {
	public static void main(String[] args) {
		Link link = new Link();
		link.addFirst(2);
		link.addFirst(1);
		link.addLast(4);
		link.addLast(5);
		link.add(3, 1);
		printAllElements(link);
		link.reverse();
		link.printAll();//效率会更高
		link.removeFirst();
		link.removeLast();
		link.removeMiddle(2);
		link.removeFirst();
		link.removeFirst();
		System.out.println(link.size());
	}
	public static void printAllElements(Link link) {
		for(int i=0;i<link.size();i++) {
			System.out.println(link.get(i).getData());
		}
	}
}

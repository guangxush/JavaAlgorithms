package cn.shgx.sort;

public class BubbleSortTest {
	public static void main(String[] args) {
		testBubbleSort();
	}

	private static void testBubbleSort() {
		int[] array = {5,9,1,9,5,3,7,6,1};
		BubbleSort bubbleSort = new BubbleSort(array);
		bubbleSort.sort();
		bubbleSort.print();
		bubbleSort.sort1();
		bubbleSort.print();
	}

}

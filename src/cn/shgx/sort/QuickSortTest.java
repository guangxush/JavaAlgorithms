package cn.shgx.sort;

public class QuickSortTest {
	public static void main(String[] args) {
		testQuickSort();
	}
	/**
	 * 快速排序测试
	 */
	public static void testQuickSort() {
		int[] array = {5,9,1,9,5,3,7,6,1};
		QuickSort quickSort = new QuickSort(array);
		quickSort.sort();
		quickSort.print();
	}
}

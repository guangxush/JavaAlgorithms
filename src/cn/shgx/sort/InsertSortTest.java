package cn.shgx.sort;

public class InsertSortTest {
	public static void main(String[] args) {
		testInsertSort();
	}
	private static void testInsertSort() {
		int[] array = {5,9,1,9,5,3,7,6,1};
		InsertSort insertSort = new InsertSort(array);
		insertSort.sort();
		insertSort.print();
	}
}

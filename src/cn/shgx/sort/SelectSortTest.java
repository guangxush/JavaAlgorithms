package cn.shgx.sort;
public class SelectSortTest {
	public static void main(String[] args) {
		testSelectSort();
	}
	/**
	 * 希尔排序测试
	 */
	public static void testSelectSort() {
		int[] array = {5,9,1,9,5,3,7,6,1};
		SelectSort selectSort = new SelectSort(array);
		selectSort.sort();
		selectSort.print();
	}
}

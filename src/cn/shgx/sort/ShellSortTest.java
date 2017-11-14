package cn.shgx.sort;

public class ShellSortTest {
	public static void main(String[] args) {
		testShellSort();
	}
	/**
	 * 希尔排序测试
	 */
	public static void testShellSort() {
		int[] array = {5,9,1,9,5,3,7,6,1};
		ShellSort shellSort = new ShellSort(array);
		shellSort.sort();
		shellSort.print();
	}
}

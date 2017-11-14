package cn.shgx.sort;

public class BinaryInsertSortTest {
	public static void main(String[] args) {
		testBinaryInsert();
	}
	private static void testBinaryInsert() {
		int[] array = {5,9,1,9,5,3,7,6,1};
		BinaryInsertSort binarySort = new BinaryInsertSort(array);
		binarySort.sort();
		binarySort.print();
	}
}

package cn.shgx.sort;

public class BucketSortTest {
	public static void main(String[] args) {
		testBucketSort();
	}
	/**
	 * 桶排序
	 */
	private static void testBucketSort() {
		int[] array = {5,9,1,9,5,3,7,6,1};
		BucketSort bucketSort = new BucketSort(11, array);
		bucketSort.sort();
		bucketSort.print();
	}
}

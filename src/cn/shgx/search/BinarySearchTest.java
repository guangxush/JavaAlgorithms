package cn.shgx.search;

public class BinarySearchTest {
	public static void main(String[] args) {
		int[] array =new int[] {1,3,5,7,9,11,19};
		BinarySearch binarySearch = new BinarySearch(array);
		System.out.println(binarySearch.search(0));
		System.out.println(binarySearch.search(3));
		System.out.println(binarySearch.searchRecursion(11));
		System.out.println(binarySearch.searchRecursion(0));
	}
}

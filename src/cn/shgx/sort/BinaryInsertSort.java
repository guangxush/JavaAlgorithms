package cn.shgx.sort;

public class BinaryInsertSort {
	private int[] array;
	public BinaryInsertSort(int[] array) {
		this.array = array;
	}
	public void sort() {
		if(array == null) {
			throw new RuntimeException("array is null");
		}
		if(array.length>0) {
			for(int i=0;i<array.length;i++) {
				int temp = array[i];
				//二分查找插入的位置
				int insertindex = binarySearch(i-1,temp);
				//前面都是排好序的元素。所以直接插入即可
				int j = i;//插入的值的位置
				//移动需要移动的元素
				while(j>insertindex) {
					array[j] = array[j-1];
					j--;
				}
				//插入元素
				array[insertindex]=temp;
			}
		}
	}
	/**
	 * 二分查找插入索引值
	 * @param maxIndex 有序区的最大索引
	 * @param data 要查找的值
	 * @return
	 */
	private int binarySearch(int maxIndex,int data) {
		int start = 0;
		int end = maxIndex;
		int mid = -1;
		while(start<=end) {
			mid = (start+end)/2;
			if(array[mid]>data) {
				end = mid -1;
			}else {
				//如果相等也插入到他的后面
				start = mid+1;
			}
		}
		return start;
	}
	public void print() {
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
}

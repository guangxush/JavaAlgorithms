package cn.shgx.sort;
/**
 * 插入排序实现
 * O(n^2)
 */
public class InsertSort {
	private int[] array;

	public InsertSort(int[] array) {
		this.array = array;
	}
	
	public void print() {
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	/**
	 * 插入排序实现
	 */
	public void sort() {
		if(array==null) {
			throw new RuntimeException("array is null");
		}
		int length = array.length;
		if(length>0) {
			for(int i = 0;i<length;i++) {
				int temp = array[i];//将当前元素拿出来
				int j = i;//记录当前下标
				while(j>0&&array[j-1]>temp){//前面都是排好序的元素
					array[j] = array[j-1];//后移一个元素
					j--;
				}
				array[j]=temp;//空出来的值给temp
			}
		}
	}
}

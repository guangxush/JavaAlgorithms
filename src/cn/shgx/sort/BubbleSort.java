package cn.shgx.sort;
/**
 * 算法复杂度O(n^2)
 * @author Consule
 *
 */
public class BubbleSort {
	private int[] array;
	public BubbleSort(int[] array) {
		this.array=array;
	}
	/**
	 * 从小到大排序
	 */
	public void sort() {
		int length = array.length;
		if(length>0) {
			for(int j=0;j<length;j++) {
				for(int i=0;i<length-1-j;i++) {
					if(array[i]>array[i+1]) {
						int temp = array[i];
						array[i] = array[i+1];
						array[i+1] = temp;
					}
				}
			}
		}
	}
	/**
	 * 从大到小排序
	 */
	public void sort1() {
		int length = array.length;
		if(length>0) {
			for(int j=length-1;j>0;j--) {
				for(int i=length-1;i>length-j-1;i--) {
					if(array[i]>array[i-1]) {
						int temp = array[i];
						array[i] = array[i-1];
						array[i-1] = temp;
					}
				}
			}
		}
	}
	public void print() {
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
}

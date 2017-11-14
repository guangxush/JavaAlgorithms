package cn.shgx.search;
/**
 * 只是针对排好序的数组进行查找
 * @author Consule
 *
 */
public class BinarySearch {
	private int[] array;
	/**
	 * 初始化数组
	 * @param array
	 */
	public BinarySearch(int[] array) {
		this.array=array;
	}
	public int searchRecursion(int target) {
		if(array!=null) {
			return searchRecursion(target,0,array.length);
		}
		return -1;
	}
	/**
	 * 递归实现二分查找
	 * @param target
	 * @param start
	 * @param end
	 * @return
	 */
	private int searchRecursion(int target,int start,int end) {
		if(start>end) {
			return -1;
		}
		int mid = (start+end)/2;
		if(array[mid]==target) {
			return mid;
		}else if(array[mid]>target) {
			return  searchRecursion(target,start,mid-1);
		}else {
			return  searchRecursion(target,mid+1,end);
		}
	}
	/**
	 * 非递归查找算法
	 * @param target
	 * @return
	 */
	public int search(int target) {
		if(array==null) {
			return -1;
		}
		int start = 0; 
		int end = array.length-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(array[mid]==target) {
				return mid;
			}else if(target<array[mid]){
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return -1;
	}
}

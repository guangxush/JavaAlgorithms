package cn.shgx.sort;
/**
 * 时间复杂度O(n+m),n是待排序元素的个数，m是桶的个数
 * @author Consule
 *
 */
public class BucketSort {
	private int[] buckets;
	private int[] array;
	public BucketSort(int range,int[] array) {
		this.buckets = new int[range];
		this.array = array;
	}
	/**
	 * 桶排序
	 */
	public void sort() {
		//如果数组不为空，则进行排序
		if(array!=null&&array.length>1) {
			for(int i =0;i<array.length;i++) {
				buckets[array[i]]++;//根据array对索引处的值赋值
			}
		}
	}
	/**
	 * 从小到大排序
	 */
	public void print() {
		//倒序输出数据
		for(int i=0;i<buckets.length;i++) {
			//元素中的值为几就说明元素中有几个相同的值，就输出几遍
			for(int j =0 ;j<buckets[i];j++) {
				System.out.println(i);
			}
		}
	}
}

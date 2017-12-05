package cn.shgx.array;
/**
 * 题意：数组中只含有数字0,1,2;移动元素使得0在前，1在中间，2在最后面
 * (1)current指针移动到元素0时，其指元素与begin处的元素交换，之后current++,begin++
 * (2)current指针移动到元素1时，什么都不交换，current++
 * (3)current指针移动到元素2时，与end指针所指的元素进行交换，之后end--,current不动
 * (4)当current与end汇合之后，移动结束，排序已经完成
 */
public class DutchFlag {
	/**
	 * 荷兰国旗问题
	 * 复杂度O(n)
	 * @param array
	 */
	public static void sort(int[] array) {
		int begin = 0;
		int end = array.length-1;
		int current = 0;
		while(current<=end) {
			if(array[current]==0) {
				swap(array,current,begin);
				begin++;
				current++;
			}else if(array[current]==1) {
				current++;
			}else if(array[current]==2) {
				swap(array,current,end);
				end--;//注意此处current不能移动
			}
		}
		System.out.println("排序后的结果：");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
			if(i!=array.length-1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	public static void swap(int[] array,int begin, int end) {
		int temp = array[begin];
		array[begin] = array[end];
		array[end] = temp;
	}
}

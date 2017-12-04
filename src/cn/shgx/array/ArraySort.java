package cn.shgx.array;
//数组正负值排序
public class ArraySort {
	/**
	 * 两次遍历填充法 O(n)
	 * @param array
	 */
	public static void sort1(int[] array) {
		int[] result = new int[array.length];
		int index = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i]<0) {
				result[index++] = array[i];
			}
		}
		for(int i=0;i<array.length;i++) {
			if(array[i]>0) {
				result[index++] = array[i];
			}
		}
		System.out.println("两次遍历填充法排序之后的结果：");
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]);
			if(i!=result.length-1) {
				System.out.print(',');
			}
		}
		System.out.println();
	}
	/**
	 * 借鉴简单插入排序思想，空间复杂度O(1)，时间复杂度O(n^2)
	 * @param array
	 */
	public static void sort2(int[] array) {
		int index = 0;//分界index
		for(int i=0;i<array.length;i++) {
			if(array[i]<0) {
				//如果是负数，依次前移到分界处
				for(int j=i;j>index;j--) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
				//分界指针后移
				index++;
			}
		}
		System.out.println("两次遍历填充法排序之后的结果：");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
			if(i!=array.length-1) {
				System.out.print(',');
			}
		}
		System.out.println();
	}
	public static void sort3(int[] array) {
		int i = 0;
		int j = array.length-1;
		while(i!=j) {
			while(i<j&&array[i]<0) {
				i++;
			}
			while(i<j&&array[j]>=0) {
				j--;
			}
			if(i<j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		System.out.println("两次遍历填充法排序之后的结果：");
		for(i=0;i<array.length;i++) {
			System.out.print(array[i]);
			if(i!=array.length-1) {
				System.out.print(',');
			}
		}
		System.out.println();
	}
}

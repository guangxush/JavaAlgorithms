package cn.shgx.array;
//寻找旋转数组的拐点
public class ArrayDot {
	/**
	 * 直接遍历法
	 * 时间复杂度O(n)
	 * @param array
	 */
	public static void findDot1(int[] array) {
		for(int i=1;i<array.length;i++) {
			if(array[i]<array[i-1]) {
				System.out.println("拐点元素为："+array[i]+"下标为："+i);
				return;
			}
		}
	}
	public static void findDot2(int[] array) {
		int low = 0;
		int high = array.length-1;
		while(low<high) {
			if(high-low==1) {
				//如果只剩两个元素
				if(array[low]<array[0]) {
					System.out.println("拐点元素为："+array[low]+"下标为："+low);
					return;
				}else {
					System.out.println("拐点元素为："+array[high]+"下标为："+high);
					return;
				}
			}
			int middle = (low+high)/2;
			if(array[middle]>=array[low]) {
				//说明左边是非递减的，拐点在右边
				low = middle;
			}else {
				high = middle;
			}
		}
	}
}

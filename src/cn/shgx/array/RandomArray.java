package cn.shgx.array;
//对数组进行重新排序
import java.util.Random;

public class RandomArray {
	/**
	 * 随便糊弄一下算法,数组长度遍历，随机选两个元素交换
	 * 时间O(n),空间O(1)
	 * @param array
	 */
	public static void random1(int[] array) {
		Random random  = new Random();
		int n = array.length;
		for(int i=0;i<n;i++) {
			int j = random.nextInt(n);
			int k = random.nextInt(n);
			int temp = array[j];
			array[j] = array[k];
			array[k] = temp;
		}
		System.out.println("随机后的结果：");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
			if(i!=array.length-1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	/**
	 * 借鉴插入排序的思想
	 * 时间O(n),空间O(1)
	 * 每个元素的随机交换机率是1/n
	 * @param array
	 */
	public static void random2(int[] array) {
		Random random = new Random();
		//这里的i每次就是分界指针
		for(int i=0;i<array.length;i++) {
			//在未随机排序的部分随机获得一个元素的下标
			int j = random.nextInt(array.length-i)+i;
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		System.out.println("随机后的结果：");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);
			if(i!=array.length-1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
}

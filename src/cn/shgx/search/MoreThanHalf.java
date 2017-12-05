package cn.shgx.search;

import cn.shgx.hashtable.HashTable;
import cn.shgx.sort.QuickSort;

//查找 数组中出现次数超过一半的数字
public class MoreThanHalf {
	/**
	 * 快速排序O(nlogn)+查找O(n)=O(nlogn)
	 * 其实找的那个元素一定是中间的元素array[length/2]
	 * @param array
	 */
	public static void find1(int[] array) {
		QuickSort quickSort = new QuickSort(array);
		quickSort.sort();
		int count = 1;//初始化为1，因为下面要忽略第一个元素并开始累加
		//这里从下标为1的元素开始
		for(int i=1;i<array.length;i++) {
			//如果不同则需要进行判断
			if(array[i]!=array[i-1]) {
				//如果大于一半的次数
				if(count>array.length/2) {
					System.out.println("找到了，这个元素是："+array[i-1]);
					return;
				}else {
					count=1;//重置count为1
				}
			}else {
				//如果相同，则需要累加
				count++;
			}
		}
		if(count>array.length/2) {
			//如果遍历到最后都是相同的，且元素个数大于一半
			//说明最后一次遍历的得到的元素就是要找的元素
			System.out.println("找到了，这个元素是："+array[array.length-1]);
			return;
		}else {
			//说明这个数组中没有元素数目超过一半
			System.out.println("没有找到");
		}
	}
	/**
	 * 借助散列表查找
	 * @param array
	 */
	public static void find2(int[] array) {
		//如果元素只有一个
		if(array.length==1) {
			System.out.println("找到了，这个元素是："+array[0]);
			return;
		}
		HashTable hashTable = new HashTable();
		for(int i=0;i<array.length;i++) {
			int count = hashTable.get(array[i]);
			if(count>0) {
				count++;
				//说明元素存在，如果条件达到直接输出
				if(count>array.length/2) {
					System.out.println("找到了，这个元素是："+array[i]);
					return;
				}
				hashTable.put(array[i], count);
			}else {
				hashTable.put(array[i], 1);
			}
		}
		System.out.println("没有找到");
	}
	/**
	 * 时间复杂度O(n)，空间复杂度O(1)
	 * @param array
	 */
	public static void find3(int[] array) {
		int t = array[0];//用来保存想要查找到的元素的值
		int n = 0;//用来保存元素出现的次数
		for(int i=0;i<array.length;i++) {
			if(array[i]==t) {
				n++;
			}else {
				n--;
			}
			if(n==0) {
				t=array[i];
				n =1;
			}
		}
		System.out.println("找到了，这个元素是："+t);
	}
}

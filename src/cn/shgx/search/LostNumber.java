package cn.shgx.search;

import cn.shgx.hashtable.HashTable;
import cn.shgx.sort.QuickSort;

//寻找打乱后的连续的数字中缺失的一个数字
//题目给出了1-100中缺失的一个数字，并找出他
public class LostNumber {
	/**
	 * 借助于快速排序
	 * 时间复杂度等于快速排序的时间复杂度O(nlogn)+O(n)=O(nlogn)
	 * 空间复杂度为O(1)
	 * @param array
	 */
	public static void find1(int[] array) {
		QuickSort sort = new QuickSort(array);
		sort.sort();
		for(int i=1;i<array.length;i++) {
			if(array[i]-array[i-1]!=1) {
				System.out.println("缺失的数字是："+(array[i]-1));
				return;
			}
		}
	}
	/**
	 * 借助与快速排序，防止find1中的对于数字1,100这种无法检测
	 * @param array
	 */
	public static void find2(int[] array) {
		QuickSort sort = new QuickSort(array);
		sort.sort();
		for(int i=0;i<array.length;i++) {
			if(array[i]!=i+1) {
				System.out.println("缺失的数字是："+(array[i]-1));
				return;
			}
		}
	}
	/**
	 * 借助散列表实现 O(n)
	 * @param array
	 */
	public static void find3(int[] array) {
		HashTable hashTable = new HashTable();
		for(int i=0;i<array.length;i++) {
			hashTable.put(array[i], 1);
		}
		for(int i=1;i<=100;i++) {
			//不存在
			if(hashTable.get(i)==-1) {
				System.out.println("缺失的数字是："+i);
				return;
			}
		}
	}
	/**
	 * 借助1-100的和的技巧，利用减法
	 * @param array
	 */
	public static void find4(int[] array) {
		int all = (1+100)*100/2;
		for(int i=0;i<array.length;i++) {
			all-=array[i];
		}
		System.out.println("缺失的数字是："+all);
	}
}

package cn.shgx.search;

import cn.shgx.array.RandomArray;

public class FindKTest {
	public static void main(String[] args) {
		int[] array = {1,3,5,7,9,2,4,6,8,10,12,11,15,14,13};
		RandomArray.random2(array);
		FindK.find(array, 0, array.length-1, 10);
	}
}

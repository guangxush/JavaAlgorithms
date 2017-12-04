package cn.shgx.array;

public class TwoSumTest {
	public static void main(String[] args) {
		int[] array = {1,9,6,5,15,3};
		int sum = 10;
		TwoSum.find1(array, sum);
		TwoSum.find2(array, sum);
		TwoSum.find3(array, sum);//数组已经排序了，因此索引是新数组的
		TwoSum.find4(array, sum);
	}

}

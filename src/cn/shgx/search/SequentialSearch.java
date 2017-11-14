package cn.shgx.search;
/**
 * 平均时间复杂度O(n)
 */
public class SequentialSearch {
	private int[] array;
	public SequentialSearch(int[] array) {
		this.array = array;
	}
	/**
	 * 直接顺序查找
	 * @param key
	 * @return
	 */
	public int search(int key) {
		for(int i =0 ;i<array.length;i++) {
			if(array[i]==key) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 哨兵方式顺序查找
	 * @param key
	 * @return
	 */
	public int search2(int key) {
		//先判断是否等于下标为0的元素
		if(key==array[0])
			return 0;
		//临时保存array[0]的值
		int temp = array[0];
		//赋值给下标为0的元素
		array[0] = key;//设置哨兵
		int i = array.length-1;
		//倒序比较
		while(array[i]!=key) {//如果没有找到会到array[0]停止循环
			i--;//减少了之前比较的操作
		}
		//把array[0]原本的值赋回去
		array[0] = temp;
		//比较到最后也没有找到，则返回-1
		if(i==0) {
			return -1;
		}
		//找到的话，返回元素的下标值
		return i;
	}
}

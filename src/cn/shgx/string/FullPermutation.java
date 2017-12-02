package cn.shgx.string;
/**
 * 递归实现字符的全排列
 */
public class FullPermutation {
	/**
	 * 字符全排列的递归实现
	 * @param str
	 */
	public static void recursivePermutation(String str) {
		char[] array = str.toCharArray();
		recursivePermutation(array,0,array.length-1);
	}
	/**
	 * 字符串全排列的递归实现
	 * @param array 字符数组
	 * @param start 起始下标
	 * @param end 结束下标
	 */
	private static void recursivePermutation(char[] array,int start,int end) {
		//当递归到最后一位的时候start与end相等，这时输出排列
		if(start==end) {
			for(int i=0;i<=end;i++) {
				System.out.print(array[i]);
			}
			System.out.println();
		}else {
			//一直遍历并递归执行部分的全排列
			for(int j=start;j<=end;j++) {
				//与当前递归部分的第一位进行交换
				swap(array,j,start);
				//递归全排列后面的部分
				recursivePermutation(array,start+1,end);
				//交换回去保持原样
				swap(array,j,start);
			}
		}
	}
	/**
	 * 字符数组指定位置互换
	 * @param array
	 * @param left
	 * @param right
	 */
	private static void swap(char[] array, int left ,int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	public static void asciiPermutation(String str) {
		//获取字符串的每个ASCII码
		char[] array = str.toCharArray();
		//需要先排序
		shellSort(array);
		int length = array.length;
		int i = 0;
		while(true){
			System.out.println(array);
			//找到数组中的第一个被打乱次序的坏人的位置
			for(i = length-2;(i>=0)&&(array[i]>=array[i+1]);--i){
				;
			}
			//当i<0时，说明已经遍历到第一个元素的前面了，结束
			if(i<0){
				return;
			}
			int j;
			//找到排列中第i位右边最后一个比其大的数的位置j
			for(j=length-1;(j>i)&&(array[j]<=array[i]);--j){
				;
			}
			//交换i,j的值
			swap(array,i,j);
			//把i位置后面的部分内容翻转
			reverse(array,i+1,length-1);
		}
	}
	
	/**
	 * 字符串指定区间的翻转
	 * @param array [description]
	 * @param start [description]
	 * @param end   [description]
	 */
	private static void reverse(char[] array,int start, int end){
		int mid = (end-start)/2+start;
		for (int i=0;i<=mid-start;i++){
			swap(array,start+i,end-i);
		}
	}
	/**
	 * 根据字符串ASCII码进行希尔排序
	 * @param array [description]
	 */
	private static void shellSort(char[] array){
		char temp;
		for(int k=array.length/2;k>0;k/=2){
			for(int i=k;i<array.length;i++){
				for(int j=i;j>=k;j-=k){
					if(array[j-k]>array[j]){
						temp = array[j-k];
						array[j-k] = array[j];
						array[j] = temp;
					}
				}
			}
		}
	}
}

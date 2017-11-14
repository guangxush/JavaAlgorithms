package cn.shgx.sort;
/**
 * 希尔排序
 * O(n^2)
 */
public class ShellSort {
	private int[] array;
	public ShellSort(int[] array) {
		this.array=array;
	}
	public void print() {
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	public void sort() {
		for(int k = array.length/2;k>0;k/=2) {//用于控制每次排序的元素间隔
			for(int i =0;i<k;i++) {//控制元素的遍历,从k往前
				//插入排序
				for(int j=i+k;j<array.length;j+=k) {
					if(array[j]<array[j-k]){
						int temp = array[j];
						int x = j-k;
						while(x>=0&&array[x]>temp) {
							array[x+k]=array[x];
							x-=k;
						}
						array[x+k]=temp;
					}
				}
			}
		}
	}
}

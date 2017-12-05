package cn.shgx.array;
//数组赋值
public class AssignArray {
	public static void assign(int[] a) {
		int[] b = new int[a.length];
		b[0] = 1;//用作临时变量
		for(int i=1;i<a.length;i++) {
			b[0]*=a[i-1];//从前往后乘得到Ba
			b[i]=b[0];//此时b[i]为对应的Ba值
		}
		b[0] = 1;//重置
		for(int i=a.length-2;i>0;i--) {
			b[0]*=a[i+1];//从后往前乘得到Bb
			b[i]*=b[0];//将之间得到的Ba乘这次得到的Bb
		}
		//此时的b[0]就是a[2]*...*a[n-1]了
		b[0]*=a[1];//计算b[0],乘以a[1]
		System.out.println("随机后的结果：");
		for(int i=0;i<b.length;i++) {
			System.out.print(b[i]);
			if(i!=b.length-1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
}

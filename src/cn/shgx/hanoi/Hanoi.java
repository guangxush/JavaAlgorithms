package cn.shgx.hanoi;
/**
 * 把A上面的所有圆盘通过B移动到C上
 * @author Consule
 *
 */
public class Hanoi {
	/**
	 * 把A最上面的圆盘移动到C上面去
	 * @param A
	 * @param C
	 */
	public static void move(char A,char C) {
		System.out.println(A+"-->"+C);
	}
	public static void hanoi(int n,char A,char B,char C) {
		if(n==1) {
			//只有一个圆盘需要移动时，直接移动即可结束
			move(A, C);
			return ;
		}
		//先把A上的n-1个圆盘通过C移动到B上
		hanoi(n-1, A, C, B);
		//把A上的最后一个圆盘移动到C上
		move(A, C);
		//接下来递归，把B上的n-1个圆盘通过A移动到C上
		hanoi(n-1, B, A, C);
	}
	public static void main(String[] args) {
		hanoi(5, 'A', 'B', 'C');
	}
}

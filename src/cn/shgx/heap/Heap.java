package cn.shgx.heap;
/*
 * 堆本身是个完全二叉树，可以用一维数组的方式去存储
 * 0位置用来存储元素的个数，1-n用来存储元素
 * 对于任意一个元素i来说，如果他有左孩子那么左孩子一定是2i,右孩子一定是2i+1
 */
public class Heap {
	private int[] elements;
	public Heap(int maxSize) {
		elements = new int[maxSize+1];
		elements[0]=0;//java本身会给所有的值赋0
	}
	/**
	 * 判断是否为空堆，直接判断下标为0的元素即可
	 * @return
	 */
	public boolean isEmpty() {
		return elements[0]==0;
	}
	/**
	 * 判断是都堆满
	 * @return
	 */
	public boolean isFull() {
		return elements[0]==elements.length-1;
	}
	/**
	 * 大顶堆添加元素
	 * @param value
	 */
	public void insert(int value) {
		if(isFull()) {
			throw new IndexOutOfBoundsException("大顶堆已满");
		}
		int i = elements[0]+1;//确认新元素的下标
		while(i!=1&&value>elements[i/2]) {
			//如果比父节点值大，则父节点的值下移
			elements[i]=elements[i/2];
			i/=2;
		}
		//最终把值插入到指定位置
		elements[i]=value;
		elements[0]++;
	}
	/**
	 * 删除大顶堆根节点元素
	 * @return
	 */
	public int delete() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("大顶堆已空");
		}
		//删除元素,先赋值为最后一个有效元素
		int deleteElement = elements[1];
		elements[1] = elements[elements[0]];
		elements[0]--;
		int temp = elements[1];
		//重建堆
		int parent =1 ;
		int child = 2;
		//循环制叶子节点
		while(child<=elements[0]) {
			if(child<elements[0]&&elements[child]<elements[child+1]) {
				//首先要确保child+1之后不能越界
				//接着如果左孩子的值小于右孩子的值，那么选择右孩子的值进行比较合交换
				child++;
			}
			if(temp>elements[child]) {
				break;
			}else {
				elements[parent]=elements[child];
				parent = child;
				child*=2;
			}
		}
		//把最后一个有效元素放到该放的位置
		elements[parent] = temp;
		return deleteElement;
	}
	/**
	 * 打印堆内存信息
	 */
	public void printALL() {
		for(int i=0;i<elements[0]-1;i++) {
			System.out.print(elements[i]);
			if(i!=elements[0]) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	public void sort() {
		//首先需要初始化元素
		if(isEmpty()) {
			throw new RuntimeException("请初始化数据");
		}
		//依次删除元素，放在数组最后
		int size = elements[0];
		for(int i=0;i<size;i++) {
			int deleteElement = delete();
			elements[elements[0]+1]=deleteElement;
		}
		//输出排序后的元素
		for(int i=1;i<size+1;i++) {
			System.out.print(elements[i]);
			if(i!=size) {
				System.out.print(",");
			}
		}
	}
}

package cn.shgx.link;

public class Link {
	private int size =0;//链表元素数目
	private Node first;//头节点
	private Node last;//尾节点
	/**
	 * 链表初始化
	 */
	public Link() {
		
	}
	/**
	 * 在链表中插入第一个元素，此时头部和尾部都是一个元素
	 * @param data
	 */
	public void fillStart(int data) {
		first = new Node();
		first.setData(data);
		last = first;
	}
	/**
	 * 返回链表中元素的数目
	 */
	public int size() {
		return size;
	}
	/**
	 * 元素只有一个时，清除first和last元素
	 */
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}
	/**
	 * 获取指定元素
	 * @param index
	 * @return 
	 */
	public Node get(int index) {
		Node temp = first;
		for(int i=0;i<index;i++) {
			temp = temp.getNext();
		}
		return temp;
	}
	/**
	 * 打印所有的元素
	 */
	public void printAll() {
		Node temp = first;
		System.out.println(temp.getData());
		for(int i=0;i<size-1;i++) {//遍历0-size个元素
			temp = temp.getNext();
			System.out.println(temp.getData());
		}
	}
	/**
	 * 链表尾部插入元素
	 * @param
	 */
	public void addLast(int data) {
		if(size==0) {
			//链表元素为空
			fillStart(data);
		}else {
			Node node = new Node();
			node.setData(data);
			last.setNext(node);
			last = node;//将插入的最后一个元素作为链表尾部元素
		}
		size++;
	}
	/**
	 * 链表头部插入元素
	 * @param data
	 */
	public void addFirst(int data) {
		if(size==0) {
			fillStart(data);
		}else{
			Node node = new Node();
			node.setData(data);
			node.setNext(first);//把插入元素的下一个元素的指针指向目前的头元素
			first = node;//把刚插入的元素设置为链表头元素
		}
		size++;
	}
	/**
	 * 在链表指定的位置插入元素
	 * @param data需要插入的数据
	 * @param index 插入元素的位置（注：下标从0开始）
	 */
	public void add (int data,int index) {
		if(size>index) {
			if(size==0) {
				//数组元素为空
				fillStart(data);
				size++;
			}else if(index == 0) {
				addFirst(data);//直接调用在头部插入元素的函数
			}else if(index==size-1) {
				addLast(data);//直接调用在尾部插入元素的函数
			}else {
				Node temp = this.get(index);
				Node node = new Node();
				node.setData(data);
				node.setNext(temp.getNext());
				temp.setNext(node);
				size++;
			}
		}else{
			throw new IndexOutOfBoundsException("链表元素溢出");
		}
	}
	/**
	 * 删除链表头部元素
	 */
	public void removeFirst() {
		if(size==0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		}else if(size==1) {
			clear();//只剩一个元素时需要清除头部和尾部
		}else {
			Node temp = first;
			first.setNext(temp.getNext());
			temp=null;//释放空间
			size--;
		}
	}
	/**
	 * 删除尾部元素
	 */
	public void removeLast() {
		if(size==0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		}else if(size==1) {
			clear();
		}else {
			Node temp =get(size-2);
			temp.setNext(null);//回收空间
			size--;
		}
	}
	/**
	 * 删除链表中间元素
	 * @param index
	 */
	public void removeMiddle(int index) {
		if(size==0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		}else if(size==1) {
			clear();
		}else {
			if(index==0) {
				removeFirst();
			}else if(index==size+1) {
				removeLast();
			}else {
				Node temp = get(index-1);//获取要删除元素的前一个元素
				Node next = temp.getNext();//要删除的元素
				temp.setNext(next.getNext());
				next = null;
				size--;	
			}
		}
	}
	/**
	 * 链表反转
	 */
	public void reverse() {
		Node temp = first;
		last = temp;
		Node next = first.getNext();
		for(int i=0;i<size-1;i++) {
			Node nextNext = next.getNext();//获取下下个
			next.setNext(temp);
			temp=next;
			next = nextNext;
		}
		last.setNext(null);
		first= temp;
	}
	
}

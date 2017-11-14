package cn.shgx.staticlink;

public class StaticLinkedList {
	private Element[] elements;
	private int head;//链表头
	private int tail;//链表尾
	private int unUsed;//链表未使用的空间
	private int size;//链表已使用空间
	/**
	 * 初始化操作
	 * @param capacity
	 */
	public StaticLinkedList(int capacity) {
		elements = new Element[capacity];//备用链表
		unUsed = 0;
		for(int i=0;i<capacity-1;i++) {
			elements[i] = new Element();
			elements[i].setCur(i+1);
		}//出最后一个元素外其余的要循环赋值，用备用链表串起来
		elements[capacity-1]=new Element();
		elements[capacity-1].setCur(-1);//最后一个元素的指针需要赋值为-1，表示后面没有元素了
	}
	/*
	 * 获取元素的个数
	 */
	public int size() {
		return size;
	}
	/**
	 * 检测链表是否为空
	 */
	public  void checkEmpty() {
		if(size==0)
			throw new IndexOutOfBoundsException("链表元素为空");
	}
	/**
	 * 检测链表元素是否已满
	 */
	public void checkFull() {
		if(size==elements.length) {
			throw new IndexOutOfBoundsException("链表元素已满");
		}
	}
	/**
	 * 获取链表元素
	 * @param index 链表的第几个元素，不是数组下标
	 * @return 
	 */
	public Element get(int index) {
		checkEmpty();
		Element element = elements[head];
		for(int i=0;i<index;i++) {
			element = elements[element.getCur()];
		}//循环遍历
		return element;
	}
	/**
	 * 按顺序打印链表中所有元素的值
	 */
	public  void printAll() {
		Element element = elements[head];
		System.out.println(element.getData());
		for(int i=1;i<size;i++) {
			element=elements[element.getCur()];
			System.out.println(element.getData());
		}
	}
	/*
	 * 链表前端插入
	 * @param data
	 */
	public void insertFirst(int data) {
		checkFull();
		//首先从备用链表的头部拿出一个元素
		Element unUsedElement = elements[unUsed];
		int temp = unUsed;
		//把备用链表的头部指向备用链表的第二个元素的下标
		unUsed = unUsedElement.getCur();//指针后移
		//把这个拿出元素的cur设置为链表头标记的位置
		unUsedElement.setCur(head);
		unUsedElement.setData(data);
		//头元素的标记指向这个新数组元素的下标
		head=temp;//head指针前移
		size++;
	}
	/**
	 * 链表尾部插入元素
	 * @param data
	 */
	public void insertLast(int data) {
		checkFull();
		Element unUsedElement = elements[unUsed];
		//用于保存当前未使用元素的位置
		int temp = unUsed;
		//得到未使用元素的下一个位置，并赋值
		unUsed = unUsedElement.getCur();
		//将未使用的元素链接到原链表的尾部
		elements[tail].setCur(temp);
		unUsedElement.setData(data);
		//链表尾部后移
		tail = temp;
		size++;
	}
	/**
	 * 在链表指定位置的后面插入元素
	 * @param data要插入的元素值
	 * @param index要插入的链表位置（不是数组下标）
	 */
	public void insert(int data,int index) {
		if(index==0) {
			insertFirst(data);
		}else if(index==size) {
			insertLast(data);
		}else {
			checkFull();
			//获取要插入元素的前一个元素
			Element prElement = get(index);
			//获取一个未被使用的元素作为要插入的元素
			Element unUsedElement = elements[unUsed];
			//记录要插入元素的下标
			int temp = unUsed;
			//将备用链表拿出来元素的下一个元素的数组下标设置为备用链表的表头
			unUsed = unUsedElement.getCur();
			//将要插入的元素的指针设为原来前一个元素指针所指向的下标值
			unUsedElement.setCur(prElement.getCur());
			//将前一个元素的指针指向插入元素的下标
			prElement.setCur(temp);
			//赋值
			unUsedElement.setData(data);
			//链表长度增加1
			size++;
		}
	}
	/**
	 * 链表头部删除
	 */
	public void deleteFirst() {
		checkEmpty();
		//获得要删除元素
		Element deleteElement = elements[head];
		//将删除的元素索引临时赋值给temp
		int temp = head;
		//头部指针后移,指向要删除元素的后一个元素
		head = deleteElement.getCur();
		//将要删除的元素头部指针指向未使用元素的头部
		deleteElement.setCur(unUsed);
		//未使用元素索引设置为删除元素的索引
		unUsed = temp;
		size--;
	}
	/**
	 * 删除指定位置的元素
	 * @param index 链表中第几个元素(不是数组下标)
	 */
	public void delete(int index) {
		if(index==0) {
			deleteFirst();
		}else {
			checkEmpty();
			//获取要删除元素的前一个元素
			Element pre = get(index-1);
			//获取删除元素真正的数组下标
			int del = pre.getCur();
			//获取要删除的元素
			Element deleteElemet = elements[del];
			//将
			pre.setCur(deleteElemet.getCur());
			if(index==size-1) {
				tail = index-1;//如果正好是最后一个元素，需要将链表尾部前移
			}
			//删除的元素回收
			deleteElemet.setCur(unUsed);
			//未使用元素的索引设置为当前的删除元素
			unUsed = del;
			size--;
		}
	}
	/**
	 * 尾删除
	 * 需要把tail前移
	 * 但是由于不知道前一个元素的下标是什么，所以尾删除和中间删除一样，都需要遍历操作
	 * 遍历到要删除元素的前一个元素时，把这个元素的cur设置为要删除元素的后一个的数组下标
	 * 如果没有自动设置为空，这时要删除的元素肯定是链表的最后一个元素
	 * 如果要删除的元素是最后一个元素需要将链表尾部标记tail前移
	 */
	public void deleteLast() {
		delete(size-1);
	}
}

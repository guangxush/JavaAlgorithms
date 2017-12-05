package cn.shgx.util;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class ArrayList<T> {
	/**
	 * 默认初始化数组长度
	 */
	private static final int INITIAL_CAPACITY = 10;
	private int size = 0;
	private Object[] array;
	
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	public ArrayList(int initial) {
		if(initial<=0) {
			throw new RuntimeException("初始化边长数组空间错误");
		}
		array = new Object[initial];
	}
	
	/**
	 * 添加元素
	 * @param o
	 */
	public void add(Object o) {
		ensureCapacityHelper(size+1);
		array[size++] = o;
	}
	
	/**
	 * 获取指定位置元素的元素值
	 * @param i
	 * @return
	 */
	public T get(int i) {
		rangeCheck(i);
		return elementData(i);
	}
	
	/**
	 * 设置指定元素的值
	 * @param i
	 * @param o
	 * @return
	 */
	public T set(int i,Object o) {
		rangeCheck(i);
		T old = elementData(i);
		array[i] = o;
		return old;
	}
	
	public T remove(int i) {
		rangeCheck(i);
		//要删除的元素
		T old = elementData(i);
		//需要移动的元素的数量
		int numMoved = size-i-1;
		if(numMoved>0) {
			//在调用系统函数之前，移动元素所有后面的元素
			System.arraycopy(array, i+1, array, i, numMoved);
		}
		//size一定要-1
		array[--size]=null;
		return old;
	}
	
	/**
	 * 清空数组
	 */
	public void clear() {
		for(int i=0;i<size;i++) {
			array[i] = null;
		}
		//size置0
		size = 0;
	}
	
	/**
	 * 获取指定元素的下标，不存在返回-1
	 * @param o
	 * @return
	 */
	public int indexOf(Object o) {
		if(o==null) {
			for(int i=0;i<size;i++) {
				if(array[i]==null) {
					return i;
				}
			}
		}else {
			for(int i=0;i<size;i++) {
				if(o.equals(array[i])) {
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 判断指定的元素是否存在与数组中
	 * @param o
	 * @return
	 */
	public boolean contains(Object o) {
		return indexOf(o)>=0;
	}
	
	public T getFirst() {
		return get(0);
	}
	
	public T getLast() {
		return get(size-1);
	}
	
	/**
	 * 判断栈是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	/**
	 * 确保空间够用
	 * @param minCapacity
	 */
	private void ensureCapacityHelper(int minCapacity) {
		if(minCapacity>array.length) {
			//说明需要的空间不够了
		    grow();
		}
	}
	
	/**
	 * 涨空间
	 */
	private void grow() {
		int oldCapacity = array.length;
		int newCapacity = oldCapacity*2;
		if(newCapacity<oldCapacity) {
			//说明溢出了
			throw new OutOfMemoryError();
		}else {
			array = Arrays.copyOf(array, newCapacity);
		}
	}
	
	/**
	 * 确认指定元素的下标是否符合数组的实际长度
	 * @param index
	 */
	private void rangeCheck(int index) {
		if(index>=size) {
			throw new IndexOutOfBoundsException("当前下标不存在");
		}
	}
	
	/**
	 * 获取指定的下标元素
	 * 这里强制转型一次就好
	 * @param index
	 * @return
	 */
	private T elementData(int index) {
		return (T)array[index];
	}
}

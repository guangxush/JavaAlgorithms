package cn.shgx.heap;

public class HeapTest {
	public static void main(String[] args) {
		Heap heap  = new Heap(100);
		heap.insert(9);
		heap.insert(18);
		heap.insert(34);
		heap.insert(15);
		heap.insert(29);
		heap.insert(66);
		heap.insert(12);
		heap.insert(48);
		heap.printALL();
		//heap.delete();
		heap.printALL();
		heap.sort();
	}
}

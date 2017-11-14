package cn.shgx.hashtable;

public class HashTableTest {
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		hashTable.put(1, 10);
		hashTable.put(2, 20);
		hashTable.put(5, 50);//与1落到了同一个hash地址，实际使用长度为2
		System.out.println(hashTable.getLength());
		hashTable.put(3, 30);//总长度为4，添加该元素之后相当于扩容了
		System.out.println(hashTable.getLength());
		hashTable.put(6, 60);
		hashTable.put(7, 70);//又需要扩容
		System.out.println(hashTable.getLength());
		System.out.println(hashTable.get(1));
		System.out.println(hashTable.get(3));
		System.out.println(hashTable.get(5));
		System.out.println(hashTable.get(6));
	}
}

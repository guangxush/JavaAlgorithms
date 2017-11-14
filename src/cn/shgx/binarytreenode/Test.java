package cn.shgx.binarytreenode;

public class Test {
	public static void main(String[] args) {
		BinarySearchingTree tree = new BinarySearchingTree(null);
		tree.insert(42);
		tree.insert(14);
		tree.insert(65);
		tree.insert(9);
		tree.insert(23);
		tree.insert(55);
		tree.insert(72);
		tree.insert(1);
		tree.insert(68);
		tree.insert(88);
		tree.insert(70);
		System.out.println(tree.search(9).getData());
		System.out.println(tree.search(1).getData());
		System.out.println(tree.search(23).getData());
		tree.delete(65);
		BinaryTreeNode tree2 = tree.getRoot();
		BinaryTree tree3 = new BinaryTree(tree2);
		tree3.inOrder(tree2);
	}

}

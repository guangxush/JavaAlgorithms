package cn.shgx.binarytreenode;
/**
 * 二叉查找树
 * @author Consule
 *
 */
public class BinarySearchingTree {
	private BinaryTreeNode root;

	public BinarySearchingTree(BinaryTreeNode root) {
		this.root = root;
	}
	/**
	 * 二叉查找树的查找
	 * @param data
	 * @return 
	 */
	public BinaryTreeNode search(int data) {
		return search(root,data);
	}
	/**
	 * 递归二叉查找树
	 * @param node
	 * @param data
	 * @return
	 */
	public BinaryTreeNode search(BinaryTreeNode node,int data) {
		if(node==null) {
			return null;
		}else if(node.getData()==data) {
			return node;	
		}else if(data>node.getData()) {
			return search(node.getRightChild(),data);
		}else {
			return search(node.getLeftChild(),data);
		}
	}
	public void insert(int data) {
		if(root==null) {
			root = new BinaryTreeNode();
			root.setData(data);
		}else {
			searchAndInsert(null, root, data);
		}
	}
	/**
	 * 递归二叉查找树（如果没有找到，建立一个新的最终位置节点）
	 * @param parent
	 * @param node
	 * @param data
	 * @return
	 */
	private BinaryTreeNode searchAndInsert(BinaryTreeNode parent,BinaryTreeNode node,int data) {
		if(node==null) {
			node = new BinaryTreeNode();
			node.setData(data);
			if(data>parent.getData()) {
				parent.setRightChild(node);
			}else{
				parent.setLeftChild(node);
			}
			return node;
		}else if(node.getData()==data){
			return node;
		}else if(data>node.getData()) {
			return searchAndInsert(node, node.getRightChild(), data);
		}else{
			return searchAndInsert(node, node.getLeftChild(), data);
		}
	}
	
	/**
	 * 二叉树查找父节点
	 * @param data
	 * @return
	 */
	public  BinaryTreeNode searchParent(int data) {
		return searchParent(null,root,data);
	}
	/**
	 * 递归查找二叉树的父节点
	 * @param parent
	 * @param node
	 * @param data
	 * @return
	 */
	private BinaryTreeNode searchParent(BinaryTreeNode parent,BinaryTreeNode node,int data) {
		if(node==null) {
			return null;
		}else if(node.getData()==data) {
			return parent;
		}else if(data>node.getData()) {
			return searchParent(node, node.getRightChild(),data);
		}else {
			return searchParent(node, node.getLeftChild(), data);
		}
	}
	
	public BinaryTreeNode getRoot() {
		return root;
	}
	public void delete(int data) {
		//对根节点直接赋空值
		if(root.getData()==data) {
			root=null;
			return;
		}
		//整个过程都需要知道父节点，因为java是引用传递，不能直接赋值
		BinaryTreeNode parent = searchParent(data);
		if(parent == null) {
			return;
		}
		BinaryTreeNode node = search(parent, data);
		if(node.getLeftChild()==null&&node.getRightChild()==null) {
			//左右子树都为空，叶子节点直接删除
			if(parent.getLeftChild()!=null&&parent.getLeftChild().getData()==data) {
				parent.setLeftChild(null);
			}else {
				parent.setRightChild(null);
			}
		}else if(node.getLeftChild()!=null&&node.getRightChild()==null) {
			//左子树不为空
			if(parent.getLeftChild()!=null&&parent.getLeftChild().getData()==data) {
				parent.setLeftChild(node.getLeftChild());
			}else{
				parent.setRightChild(node.getLeftChild());
			}
		}else if(node.getLeftChild()==null&&node.getRightChild()!=null) {
			//右子树不为空
			if(parent.getLeftChild()!=null&&parent.getRightChild()!=null) {
				parent.setLeftChild(node.getRightChild());
			}else {
				parent.setRightChild(node.getRightChild());
			}
		}else {
			//左右子树都不为空
			//1.查找右子树中最左的节点
			BinaryTreeNode deleteNode = node;//要删除的节点
			BinaryTreeNode temp = node.getRightChild();//要删除节点的右子树树根
			if(temp.getLeftChild()==null) {
				//如果右子树没有左孩子，直接上移
				temp.setLeftChild(deleteNode.getLeftChild());
			}else {
				//右子树的左孩子不为空
				while(temp.getLeftChild()!=null) {
					node = temp;
					temp = temp.getLeftChild();
				}
				//2.继承节点原右子树上移
				node.setLeftChild(temp.getRightChild());
				//3.继承节点就位
				temp.setLeftChild(deleteNode.getLeftChild());
				temp.setRightChild(deleteNode.getRightChild());
			}
			//4.更新父节点为删除节点的原父节点
			if(parent.getLeftChild()!=null&&parent.getLeftChild().getData()==data) {
				parent.setLeftChild(temp);
			}else {
				parent.setRightChild(temp);
			}
		}
	}
}

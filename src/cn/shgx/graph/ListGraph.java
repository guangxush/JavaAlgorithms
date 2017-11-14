package cn.shgx.graph;

import cn.shgx.hashtable.HashTable;
import cn.shgx.queue.ArrayQueue;
import cn.shgx.stack.Stack;

public class ListGraph {
	//图的顶点数组
	private ListGraphNode[] nodes;
	private HashTable value2index = new HashTable();
	/**
	 * 初始化图的顶点
	 * @param vertexes
	 */
	public ListGraph(int[] vertexes) {
		nodes = new ListGraphNode[vertexes.length];
		for(int i=0;i<vertexes.length;i++) {
			nodes[i] = new ListGraphNode(vertexes[i], null);
			value2index.put(vertexes[i], i);
		}
	}
	/**
	 * 添加start到可达的边
	 * @param start起始顶点
	 * @param end可到达的顶点数组
	 */
	public void addEdges(int start,int[] end) {
		int index = value2index.get(start);
		if(index<0) {
			throw new RuntimeException("未找到指定的起始顶点");
		}
		ListGraphNode node = nodes[index];
		for(int j=0;j<end.length;j++) {
			int i = value2index.get(end[j]);
			if(i<0) {
				throw new RuntimeException("未找到指定的到达顶点");
			}
			node.next = new ListGraphNode(i, end[j],null);
			node = node.next;
		}
		/*for(int i=0;i<nodes.length;i++) {
			if(nodes[i].value==start) {
				ListGraphNode node = nodes[i];
				for(int j=0;j<end.length;j++) {
					node.next = new ListGraphNode(end[j], null);
					node = node.next;
				}
			}
		}*/
	}
	public void printListGraph() {
		for(int i=0;i<nodes.length;i++) {
			ListGraphNode node =nodes[i];
			do {
				System.out.print(node.value+" ");
				node = node.next;
			}while(node!=null);
			System.out.println();
		}
	}
	/**
	 * 邻接表广度优先遍历
	 */
	public void breadthFirstTravel() {
		System.out.println("邻接表广度优先遍历:");
		//初始化队列
		ArrayQueue queue = new ArrayQueue(nodes.length);
		//初始化各顶点访问状态
		int[] visited = new int[nodes.length];
		//从未被访问过的节点中任选一个顶点作为起始顶点
		int unvisited = getUnVisited(visited);
		while(unvisited>=0) {
			queue.put(unvisited);//起始顶点入队
			while(!queue.isEmpty()) {
				int index = (Integer)queue.pull();
				System.out.println(nodes[index].value+",");
				//标记被访问
				visited[index]=1;
				//遍历所有未被访问的邻接顶点，放入队列中
				ListGraphNode node = nodes[index].next;
				while(node!=null) {
					if(visited[node.value]==0) {
						queue.put(node.value);
					}
					node = node.next;
				}
			}
			unvisited = getUnVisited(visited);
		}
		System.out.println();
	}
	/**
	 * 从访问标记数组中获取第一个发现的未被访问的顶点下标
	 * @param visited
	 * @return 都被访问了就返回-1
	 */
	private int getUnVisited(int[] visited) {
		int index = -1;
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==0) {
				index= i ;
				break;
			}
		}
		return index;
	}
	/**
	 * 邻接表深度优先遍历
	 */
	public void depthFirstTravel() {
		System.out.println("邻接表的深度优先遍历：");
		//初始化栈
		Stack stack = new Stack(nodes.length);
		//初始化各顶点的访问状态
		int[] visited = new int[nodes.length];
		//从未访问过的顶点中任选一个顶点作为起始顶点
		int unvisited = getUnVisited(visited);
		while(unvisited>=0) {
			visited[unvisited]=1;
			stack.push(unvisited);
			System.out.print(nodes[unvisited].value+",");
			while(!stack.isEmpty()) {
				//获取栈顶元素不出栈 
				int index = stack.peek();
				//找到未被访问的邻接顶点
				boolean found = false;
				ListGraphNode node = nodes[index];
				while(node!=null) {
					if(node.next!=null&&visited[node.next.index]==0) {
						//如果找到，则访问并入栈
						visited[node.next.index]=1;
						stack.push(node.next.index);
						System.out.print(node.next.value+",");
						found = true;
						break;
					}
					node = node.next;
				}
				//如果未找到，则该元素出栈
				if(!found) {
					stack.pop();
				}
				unvisited = getUnVisited(visited);
			}
			System.out.println();
		}
	}
	
}

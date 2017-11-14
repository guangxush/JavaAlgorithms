package cn.shgx.graph;

import cn.shgx.stack.Stack;

import cn.shgx.queue.ArrayQueue;

public class MatrixGraph {
	//通过下标映射元素的值
	private int[] mapping;
	//图的二维数组
	private int[][] matrix;
	/**
	 * 初始化图的顶点
	 * @param vertexes 顶点数组
	 */
	public MatrixGraph(int[] vertexes) {
		int length = vertexes.length;
		mapping = new int[length];
		matrix = new int[length][length];
		for(int i = 0;i<length;i++) {
			mapping[i] = vertexes[i];
		}
	}
	public void addEdge(int start,int end) {
		int x = -1;
		int y = -1;
		//寻找坐标
		for(int i=0;i<mapping.length;i++) {
			if(x!=-1&&y!=-1) {
				break;
			}
			if(start==mapping[i]) {
				x = i;
			}
			if(end == mapping[i]) {
				y=i;
			}
		}
		//判断顶点是否存在
		if(x==-1||y==-1||x>mapping.length-1||y>mapping.length-1) {
			throw new IndexOutOfBoundsException("边的订单不存在");
		}
		//增加边
		matrix[x][y]=1;
	}
	public void printMatrix() {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	/**
	 * 邻接矩阵广度优先遍历
	 */
	public void breadthFirstTravel() {
		System.out.println("邻接矩阵广度优先遍历:");
		//初始化队列
		ArrayQueue queue  = new ArrayQueue(mapping.length);
		//初始化各顶点的访问状态
		int[] visited = new int[mapping.length];
		//从未被访问过的顶点中任选一个顶点作为起始顶点
		int unvisited = getUnVisited(visited);
		while(unvisited>=0) {
			queue.put(unvisited);//起始顶点入队
			while(!queue.isEmpty()) {
				//出队顶点并访问
				int index = (Integer)queue.pull();
				if(visited[index]==1) {
					continue;
				}
				System.out.println(mapping[index]+",");
				//标记被访问
				visited[index] = -1;
				//遍历所有未被访问的邻接节点，放入队列中
				for(int i=0;i<mapping.length;i++) {
					//不是自己、未访问、可到达
					if(index!=i&&visited[i]==0&&matrix[index][i]>0) {
						queue.put(i);
					}
				}
			}
			unvisited = getUnVisited(visited);
		}
		System.out.println();
	}
	/**
	 * 从访问标记数组中获取第一个发现的未被访问过的顶点下标
	 * @param visited
	 * @return 都被访问就返回-1
	 */
	private int getUnVisited(int[] visited) {
		int index = -1;
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==0) {
				index = i;
				break;
			}
		}
		return index;
	}
	/**
	 * 邻接矩阵的深度优先遍历
	 */
	public void depthFirstTravel() {
		System.out.println("邻接矩阵的深度优先遍历：");
		//初始化栈
		Stack stack = new Stack(mapping.length);
		//初始化各顶点的访问状态
		int[] visited = new int[mapping.length];
		//从未访问的节点中任选一个顶点作为起始顶点
		int unvisited = getUnVisited(visited);
		while(unvisited>=0) {
			//访问起始顶点并入栈
			visited[unvisited]=1;
			stack.push(unvisited);
			System.out.print(mapping[unvisited]+",");
			while(!stack.isEmpty()) {
				//获取栈顶元素，不出栈
				int index = stack.peek();
				//遍历未被找到的邻接顶点
				boolean found = false;
				for(int i=0;i<mapping.length;i++) {
					//不是自己，未被访问，可到达
					if(index!=i&&visited[i]==0&&matrix[index][i]>0) {
						//如果找到则访问并入栈
						visited[i]=1;
						stack.push(i);
						System.out.print(mapping[i]+",");
						found=true;
						break;
					}
				}
				//如果未找到，则出栈元素
				if(!found) {
					stack.pop();
				}
			}
			unvisited = getUnVisited(visited);
		}
		System.out.println();
	}
	
}

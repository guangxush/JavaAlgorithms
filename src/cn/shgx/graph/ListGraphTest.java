package cn.shgx.graph;

public class ListGraphTest {
	public static void main(String[] args) {
		int[] vertexes = {1,2,3,4,5,6};
		ListGraph graph = new ListGraph(vertexes);
		graph.addEdges(1, new int[] {2,3,5,6},new int[] {16,1,12,15});
		graph.addEdges(2, new int[] {1,4,6},new int[] {16,2,8});
		graph.addEdges(3, new int[] {1,5},new int[] {1,5});
		graph.addEdges(4, new int[] {2,5,6},new int[] {2,9,3});
		graph.addEdges(5, new int[] {1,3,4,6},new int[] {12,5,9,8});
		graph.addEdges(6, new int[] {1,2,4,5},new int[] {15,8,3,8});
		graph.dijkstra(1);
		
	}
}

//package graph;
//
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.ListIterator;
//import java.util.Queue;
//import java.util.concurrent.ArrayBlockingQueue;
//
//class Graph{
//	private int vertecies;
//	private List<Integer> adjacentList[];
//	public Graph(int vertieces) {
//		this.vertecies = vertieces;
//		adjacentList = new LinkedList[vertieces];
//	
//		for(int i=0;i<vertieces;i++){
//			adjacentList[i] = new LinkedList<Integer>();
//		}
//	}
//	public int getVertecies() {
//		return vertecies;
//	}
//	public void setVertecies(int vertecies) {
//		this.vertecies = vertecies;
//	}
//	public List<Integer>[] getAdjacentList() {
//		return adjacentList;
//	}
//	public void setAdjacentList(List<Integer>[] adjacentList) {
//		this.adjacentList = adjacentList;
//	}
//	void addEdge(int u, int v){
//		adjacentList[u].add(v);
//	}
//	void bfsRun(int src){
//		boolean visited[]= new boolean[vertecies];
//		Queue<Integer> queue= new ArrayBlockingQueue<Integer>(4);
//		queue.add(src);
//		while(!queue.isEmpty()){
//			int val = queue.poll();
//			System.out.println(val);
//			ListIterator<E>
//		}
//	}
//}
//public class BFS {
//
//	public static void main(String[] args) {
//		Graph graph = new Graph(4);
//		graph.addEdge(0, 1);
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 1);
//		graph.addEdge(0, 2);
//	}
//}

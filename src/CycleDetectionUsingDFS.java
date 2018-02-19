import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;
public class CycleDetectionUsingDFS {
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter number of vertices in graph");
		Graph6 graph=new Graph6(input.nextInt());
		System.out.println("Enter number of edges");
		int n=input.nextInt();
		System.out.println("Enter source and destination of edge and then hit enter");

		for(int i=0;i<n;i++)
			graph.addEdge(input.nextInt(), input.nextInt());
		System.out.println("Cycle in graph = "+graph.isCycle(0));
	}
}
class Graph6{
	int vertices;
	LinkedList<Integer> graph[];
	Graph6(int n){
		graph=new LinkedList[n];
		vertices=n;
		for(int i=0;i<n;i++)
			graph[i]=new LinkedList<Integer>();
	}
	void addEdge(int src,int des) {
		graph[src].add(des);
	}
	boolean isCycle(int v) {
		boolean visited[]=new boolean[vertices];
		visited[v]=true;
		return isCycle(visited,v);
	}
	boolean isCycle(boolean visited[],int v) {
		Iterator<Integer> it=graph[v].listIterator();
		while(it.hasNext()) {
			int k=it.next();
			if(visited[k]) 
				return true;
			visited[k]=true;
			return isCycle(visited,k);
			
		}
		return false;
	}
}

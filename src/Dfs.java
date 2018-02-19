import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;
public class Dfs {
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter no. of vertices");
		int v=input.nextInt();
		Graph mygraph=new Graph(v);
		System.out.println("Enter no. of edges");
		int edges=input.nextInt();
		System.out.println("Enter source and destination of edge and then hit enter");
		for(int i=0;i<edges;i++) 
			mygraph.addEdge(input.nextInt(), input.nextInt());
		
		System.out.println("Enter starting vertex of Dfs");
		mygraph.Dfs(input.nextInt());
	
	}
}
class Graph{
	int vertices;
	LinkedList<Integer> graph[];
	Graph(int n){
		vertices=n;
		graph=new LinkedList[n];
		for(int i=0;i<vertices;i++)
			graph[i]=new LinkedList<Integer>();
	}
	public void addEdge(int src,int des) {
		graph[src].addFirst(des);
	}
	public void Dfs(int v) {
		boolean visited[]=new boolean[vertices];
		visited[v]=true;
		dfs(v,visited);
		
	}
	public void dfs(int v,boolean visited[]) {
		System.out.println(v+" ");
		Iterator<Integer> i = graph[v].listIterator();
		while(i.hasNext()) {
			int n=i.next();
			if(!visited[n]) {
				visited[n]=true;
				dfs(n,visited);
			}
			
		}
		
	}
}

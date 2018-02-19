import java.util.Stack;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;

public class ShortestPathInDirectedAcyclicGraph {
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter no. of vertices");
		int v=input.nextInt();
		Graph4 mygraph=new Graph4(v);
		System.out.println("Enter no. of edges");
		int edges=input.nextInt();
		System.out.println("Enter source and destination of edge and then hit enter");
		for(int i=0;i<edges;i++) 
			mygraph.addEdge(input.nextInt(), input.nextInt(),input.nextInt());
		System.out.println("Enter vertex from which you want shortest distance");
		mygraph.shortest(input.nextInt());
	}
}
class Edge{
	int data;
	int weight;
	Edge(int d,int w){
		data=d;
		weight=w;
	}
	int getData() {return data;}
	int getWeight() {return weight;}
}
class Graph4{
	int vertices;
	LinkedList<Edge>graph[];
	Graph4(int n){
		vertices=n;
		graph=new LinkedList[vertices];
		for(int i=0;i<n;i++) {
			graph[i]=new LinkedList<Edge>();
		}
	}
	public void addEdge(int src, int des, int wt) {
		graph[src].add(new Edge(des,wt));
	}
	public void TOrder(int v,boolean visited[],Stack mystack) {
		
		visited[v]=true;
		Iterator<Edge>it=graph[v].listIterator();
		while(it.hasNext()) {
			int d=it.next().getData();
			if(!visited[d])
			TOrder(d,visited,mystack);
		}
		mystack.push(v);
	}
		
	void shortest(int u) {
		final int INF=Integer.MAX_VALUE;
		boolean visited[]=new boolean[vertices];
		Stack<Integer> mystack=new Stack<>();
		Arrays.fill(visited, false);
		for(int i=0;i<vertices;i++)
			if(!visited[i])
				TOrder(i,visited,mystack);
		//System.out.println(mystack);
		int dist[]=new int[vertices];
		Arrays.fill(dist,INF);
		dist[u]=0;
		
		
		while(!mystack.isEmpty()) {
			int v=mystack.pop();
			if(dist[v]!=INF) {
				Iterator<Edge>it=graph[v].listIterator();
				while(it.hasNext()) {
					Edge d=it.next();
					if(dist[d.getData()]>dist[v]+d.getWeight())
						dist[d.getData()]=dist[v]+d.getWeight();
				}
			}
		}
		for(int i:dist)
			if(i==INF)
				System.out.print("INF"+" ");
			else
			System.out.print(i+" ");
		
	}
}
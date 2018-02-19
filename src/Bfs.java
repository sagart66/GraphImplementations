import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator;
public class Bfs {
	public static void main(String []args) {
	Scanner input=new Scanner(System.in);
	System.out.println("Enter no. of vertices");
	int v=input.nextInt();
	Graph2 mygraph=new Graph2(v);
	System.out.println("Enter no. of edges");
	int edges=input.nextInt();
	System.out.println("Enter source and destination of edge and then hit enter");
	for(int i=0;i<edges;i++) 
		mygraph.addEdge(input.nextInt(), input.nextInt());
	
	System.out.println("Enter starting vertex of Dfs");
	//mygraph.print();
	mygraph.Bfs(input.nextInt());
}
}
class Graph2{
	int vertices;
	LinkedList<Integer> graph[];
	Graph2(int n){
		vertices=n;
		graph=new LinkedList[n];
		for(int i=0;i<vertices;i++)
			graph[i]=new LinkedList<Integer>();
	}
	public void addEdge(int src,int des) {
		graph[src].addFirst(des);
	}
	public void print() {
		for(int i=0;i<vertices;i++) {
			System.out.println(i+" "+graph[i]);
			
		}
	}
	public void Bfs(int v) {
		boolean visited[]=new boolean[vertices];
		LinkedList<Integer>queue=new LinkedList<>();
		visited[v]=true;
		queue.addFirst(v);
		while(!queue.isEmpty()) {
			int l=queue.removeFirst();
			System.out.println(l);
			Iterator<Integer> i=graph[l].listIterator();
			while(i.hasNext()) {
				int j=i.next();
				if(!visited[j]) {
					visited[j]=true;
					queue.addLast(j);
				
				}
			}
		}
	}
}
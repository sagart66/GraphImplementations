import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator;
public class TopologicalSorting {
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter no. of vertices");
		int v=input.nextInt();
		Graph1 mygraph=new Graph1(v);
		System.out.println("Enter no. of edges");
		int edges=input.nextInt();
		System.out.println("Enter source and destination of edge and then hit enter");
		for(int i=0;i<edges;i++) 
			mygraph.addEdge(input.nextInt(), input.nextInt());
		
		System.out.println("Enter starting vertex of Dfs");
		mygraph.TO();
		
	}

}
class Graph1{
	int vertices;
	LinkedList<Integer>graph[];
	Graph1(int v){
		vertices=v;
		graph=new LinkedList[v];
		for(int i=0;i<v;i++)
			graph[i]=new LinkedList<Integer>();
	}
	public void addEdge(int src,int des) {
		graph[src].addFirst(des);
		
		
	}
	public void TO() {
		boolean visited[]=new boolean[vertices];
		Arrays.fill(visited, false);
		Stack<Integer> mystack=new Stack<Integer>();
		//don't miss this step this is very important
		for(int i=0;i<vertices;i++)
			if(!visited[i])
				Torder(i,visited,mystack);
		
		
		while(!mystack.isEmpty())
			System.out.println(mystack.pop());
	
	}
	public void Torder(int v,boolean visited[], Stack<Integer> mystack) {
		visited[v]=true;
		Iterator<Integer> i= graph[v].listIterator();
		while(i.hasNext()) {
			int j=i.next();
			if(!visited[j]) {
				Torder(j,visited,mystack);
			}
		}
		mystack.push(v);
		
	}
	
	
}
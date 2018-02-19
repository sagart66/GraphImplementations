//self implemented all the data structures
//arrange all the edges in non decreasing order and then apply discrete set union and find algorithm to select edges for MST
//this is non recursive solution  O(V*E)
//recursive solution takes O(ElogV) or (ElogE)
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
public class KruskalsAlgorithm {
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		System.out.println("This program is implementation of Kruskals algorithm\n "
				+ "Its Minimum Spanning Tree algorithm");
		System.out.println("Enter number of vertices & number of edges");
		Graph7 graph=new Graph7(input.nextInt(),input.nextInt());
		System.out.println("Enter "+graph.getEdges()+" Edges each having"
				+ " source, destination and weight of the edge");
		for(int i=0;i<graph.getEdges();i++)
			graph.addEdge(i, input.nextInt(), input.nextInt(), input.nextInt());
	//	graph.print();//print the edges in sorted order by weigth;
	//	System.out.println("---------------");
		graph.printSelected();
		
	}
}
class Graph7{
	final private int vertices;
	final private int edges;
	Edge1 edge[];
	public int getEdges() {
		return edges;
	}
	
	
	
	Graph7(int v, int e){
		vertices=v;
		edges=e;
		edge=new Edge1[e];
		for(int i=0;i<edges;i++)
			edge[i] = new Edge1();
	}
	static class Edge1 implements Comparable<Edge1>{
		int src;
		int des;
		boolean selected;
		int wt;
		public int compareTo(Edge1 e) {
		return this.wt-e.wt;
	}
		
		public static Comparator<Edge1> myComparator= new Comparator<Edge1>() {
			public int compare(Edge1 e, Edge1 f) {
			return e.compareTo(f);
			}
			};
	}
	void addEdge(int i,int x,int y,int wt) {
		 edge[i].src=x;
		 edge[i].des=y;
		 edge[i].wt=wt;
		 edge[i].selected=false;
	}
	void print() {
		Arrays.sort(edge, Edge1.myComparator);
		for(Edge1 i:edge)
			System.out.println(i.src+"   "+i.des+"   "+i.wt);
	}
	void kruskal() {
		int []parent=new int[vertices];
		int numOfElements[]=new int[vertices];
		for(int i=0;i<parent.length;i++) {
			parent[i]=i;
			numOfElements[i]=0;
		}
		for(int i=0;i<edges;i++) {
			int x=parent[edge[i].src];
			int y=parent[edge[i].des];
			if(x!=y) {
				edge[i].selected=true;
				union(x,y,parent,numOfElements);
				
			}
		}
	}
	void union(int x,int y,int []parent,int []numOfElements) {
		int i=parent[x];
		int j=parent[y];if(numOfElements[i]>numOfElements[j]) {
			numOfElements[i]+=numOfElements[j];
			for(int k=0;k<parent.length;k++) {
				if(parent[k]==j)
					parent[k]=i;
			}
			parent[j]=i;
			
		}else{
			numOfElements[j]+=numOfElements[i];
			for(int 	k=0;k<parent.length;k++) {
				if(parent[k]==i)
					parent[k]=j;
			}
			parent[i]=j;
		}
	}
	void printSelected() {
		Arrays.sort(edge, Edge1.myComparator);
		kruskal();
		System.out.println("Edges in Minimum Spanning Tree are:");
		for(Edge1 i:edge) {
			if(i.selected)
			System.out.println(i.src+" "+i.des);
		}
		
	}
}
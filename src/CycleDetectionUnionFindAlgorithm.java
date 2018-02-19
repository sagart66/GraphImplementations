//two ways of implementation 
//ALL COMMENTED CODE BELONGS TO RECURSSIVE IMPLEMENTATION
//and other one is iterative method
//efficient method is by using rank and compression
import java.util.Scanner;
public class CycleDetectionUnionFindAlgorithm {
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
	System.out.println("Enter number of vertices && number of edges");
		Graph5 graph=new Graph5(input.nextInt(),input.nextInt());
		System.out.println("Enter "+graph.Edges+ " edges space seperated source and destination\n Note here edges start with 0 ordering");
		for(int i=0;i<graph.Edges;i++) {
			graph.addEdge(input.nextInt(), input.nextInt(), i);
		}
		System.out.println("Cycle present in graph "+graph.isCycleEfficient());
	}
}
class Graph5{
	int Edges,Vertices;
	Edge edge[];
	class Edge{
		int src;
		int des;
	}
	Graph5(int n,int e){
		Vertices=n;	
		Edges=e;
		edge=new Edge[Edges];
		for(int i=0;i<e;i++)
			edge[i]=new Edge();
	}
	void addEdge(int src,int des,int i) {
		edge[i].src=src;
		edge[i].des=des;
	}
	boolean isCycle() {
		int parent[]=new int[Vertices];
		for(int i=0;i<Vertices;i++)
			parent[i]=i;//parent[i]=-1;
		for(int i=0;i<Edges;i++) {
			int x=parent[edge[i].src];//find(parent,edge[i].src);
			int y=parent[edge[i].des];//find(parent,edge[i].des);
		
		if(x==y)
			return true;
		union(x,y,parent);
		}
		return false;
	}
	int find(int parent[],int a) {
		if(parent[a]==-1)
				return a;
		return find(parent,parent[a]);
	}
	void union(int x,int y,int parent[]) {
		int i=parent[x];//find(parent,x);
		int j=parent[y];//find(parent,y);
		for(int k=0;k<parent.length;k++) {
			if(parent[k]==i)
				parent[k]=j;
		}
		parent[i]=j;
	}
	boolean isCycleEfficient() {
		int parent[]=new int[Vertices];
		int numOfElements[]=new int[Vertices];
		for(int i=0;i<Vertices;i++) {
			parent[i]=i;
			numOfElements[i]=0;
		}
		for(int i=0;i<Edges;i++) {
			int x=parent[edge[i].src];
			int y=parent[edge[i].des];
			
			if(x==y)
				return true;
			unionEfficient(x,y,parent,numOfElements);
			
			}
			return false;
		}
	void unionEfficient(int x,int y,int parent[],int numOfElements[]) {
		int i=parent[x];
		int j=parent[y];
		if(numOfElements[i]>numOfElements[j]) {
			numOfElements[i]+=numOfElements[j];
			for(int k=0;k<parent.length;k++) {
				if(parent[k]==j)
					parent[k]=i;
			}
			parent[j]=i;
			
		}else{
			numOfElements[j]+=numOfElements[i];
			for(int k=0;k<parent.length;k++) {
				if(parent[k]==i)
					parent[k]=j;
			}
			parent[i]=j;
			
			
		}
		
		
	}
	}
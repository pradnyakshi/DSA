import java.util.*;
public class TopologicalSort
{
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
    
    public static void createGraph(ArrayList<Edge> graph[],int V){
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<Edge>();
        }
        
        graph[2].add(new Edge(2,3));
        
        graph[3].add(new Edge(3,1));
        
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
        
    }
    
    public static void topologicalSort(ArrayList<Edge> graph[],Stack<Integer> s,boolean[] vis,int curr){    //O(V+E)
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topologicalSort(graph,s,vis,e.dest);
            }
        }
        s.push(curr);
    }
    
	public static void main(String[] args) {
		int V = 6;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph,V);
		boolean[] vis = new boolean[V];
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<V;i++){
		    if(!vis[i]){
		        topologicalSort(graph,s,vis,i);
		    }
		}
		while(!s.isEmpty()){
		    System.out.print(s.pop() + " ");
		}
	}
}

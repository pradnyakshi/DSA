import java.util.*;

public class DetectCycleUndirected
{
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
    
    public static void creategraph(ArrayList<Edge> graph[],int V){
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<Edge>();
        }
        
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));
        
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        
        graph[3].add(new Edge(3,2));
    }
    
    public static boolean detectCycle(ArrayList<Edge> graph[],boolean[] vis,int curr,int par){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == true && e.dest != par){
                return true;
            }
            if(!vis[e.dest]){
                if(detectCycle(graph,vis,e.dest,curr)){
                    return true;
                }
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		int V = 4;
		ArrayList<Edge> graph[] = new ArrayList[V];
	    creategraph(graph,V);
		boolean[] vis = new boolean[V];
		System.out.println(detectCycle(graph,vis,0,-1));
	}
}

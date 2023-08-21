import java.util.*;

public class DetectCycleDirected
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
        
        graph[0].add(new Edge(0,2));
        
        graph[1].add(new Edge(1,0));
        
        graph[2].add(new Edge(2,3));
        
        graph[3].add(new Edge(3,0));
    }
    
    public static boolean detectCycle(ArrayList<Edge> graph[],boolean[] vis,int curr,boolean[] rec){    //O(V+E)
        vis[curr] = true;
        rec[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }
            if(!vis[e.dest]){
                if(detectCycle(graph,vis,e.dest,rec)){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }
    
	public static void main(String[] args) {
		int V = 4;
		ArrayList<Edge> graph[] = new ArrayList[V];
	    creategraph(graph,V);
		boolean[] vis = new boolean[V];
		boolean[] rec = new boolean[V];
		System.out.println(detectCycle(graph,vis,0,rec));
	}
}

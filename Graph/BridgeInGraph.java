import java.util.*;
public class BridgeInGraph
{
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
    
    public static void createGraph(ArrayList<Edge> graph[],int V){
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
    }
    
    public static void dfs(ArrayList<Edge> graph[],boolean[] vis,int[] dt,int[] ldt,int curr,int par,int time){
        vis[curr] = true;
        dt[curr] = ldt[curr] = ++time;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(e.dest == par)
                continue;
            if(vis[e.dest]){
                ldt[curr] = Math.min(ldt[curr],dt[e.dest]);
            }else if(!vis[e.dest]){
                dfs(graph,vis,dt,ldt,e.dest,curr,time);
                ldt[curr] = Math.min(ldt[curr],ldt[e.dest]);
                if(dt[curr] < ldt[e.dest]){
                    System.out.println(curr + " -> " + e.dest);
                }
            }
        }
    }
    
    public static void tarjan(ArrayList<Edge> graph[],int V){    //O(V+E)
        int[] dt = new int[V];
        int[] ldt = new int[V];
        boolean[] vis = new boolean[V];
        dfs(graph,vis,dt,ldt,0,-1,0);
    }
    
	public static void main(String[] args) {
	    int V = 6;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph,V);
		tarjan(graph,V);
	}
}

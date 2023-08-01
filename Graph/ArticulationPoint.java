// Articulation Point - A vertex in an undirected connected graph is an articulation point if removing it disconnects the graph.
// tarjan's algorithm

import java.util.*;

public class ArticulationPoint
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
    }
    
    public static void dfs(ArrayList<Edge> graph[],int curr,int par,boolean vis[],int dt[],int ldt[],int time,boolean ap[]){
        vis[curr] = true;
        dt[curr] = ldt[curr] = ++time;
        int children = 0;
        
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(e.dest == par){
                continue;
            }
            else if(vis[e.dest]){
                ldt[curr] = Math.min(ldt[curr],dt[e.dest]);
            }else{
                dfs(graph,e.dest,curr,vis,dt,ldt,time,ap);
                ldt[curr] = Math.min(ldt[curr],ldt[e.dest]);
                if(dt[curr] <= ldt[e.dest] && par != -1){
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1 && children > 1){
            ap[curr] = true;
        }
    }
    
    public static void findArticulationPoint(ArrayList<Edge> graph[],int V){
        boolean vis[] = new boolean[V];
        int dt[] = new int[V];
        int ldt[] = new int[V];
        int time = 0;
        boolean ap[] = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(graph,i,-1,vis,dt,ldt,time,ap);
            }
        }
        
        for(int i=0;i<V;i++){
            if(ap[i]){
                System.out.println(i);
            }
        }
    }
    
	public static void main(String[] args) {
	    int V = 5;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph,V);
		findArticulationPoint(graph,V);
	}
}

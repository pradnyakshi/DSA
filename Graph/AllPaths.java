import java.util.*;
public class AllPaths
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
        
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        
        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));
        
        graph[2].add(new Edge(2,4));
        graph[2].add(new Edge(2,0));
        
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));
        
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));
        
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
        
        graph[6].add(new Edge(6,5));
    }
    
    public static void allPaths(ArrayList<Edge> graph[],boolean[] vis,int curr,int dest,String path){   //O(V^2)
        if(curr == dest){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr] = true;
                allPaths(graph,vis,e.dest,dest,path+e.dest);
                vis[curr] = false;
            }
        }
    }
    
	public static void main(String[] args) {
		int V = 7;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph,V);
		boolean[] vis = new boolean[V];
		allPaths(graph,vis,0,5,"0");
	}
}

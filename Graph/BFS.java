import java.util.*;
public class BFS
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
    
    public static void bfs(ArrayList<Edge> graph[],boolean[] vis,int curr){     //O(V+E)
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        
        while(!q.isEmpty()){
            int node = q.remove();
            if(!vis[node]){
                System.out.print(node+ " ");
                vis[node] = true;
                for(int i=0;i<graph[node].size();i++){
                    Edge e = graph[node].get(i);
                    if(!vis[e.dest]){
                        q.add(e.dest);
                    }
                }
            }
        }
    }
    
	public static void main(String[] args) {
		int V = 7;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph,V);
		boolean[] vis = new boolean[V];
		for(int i=0;i<V;i++){
		    if(!vis[i]){
		        bfs(graph,vis,i);
		    }
		}
	}
}

import java.util.*;
public class PrimsAlgorithm
{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int n,int d){
            this.node = n;
            this.dist = d;
        }
        
        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }
    
    public static void createGraph(ArrayList<Edge> graph[],int V){
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<Edge>();
        }
        
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));
        
        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,5));
        
        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,1,5));
        graph[3].add(new Edge(3,2,50));
        
        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));
    }
    
    public static void prims(ArrayList<Edge> graph[],int V){    //)(Elog(E))
        PriorityQueue<Pair> pq = new PriorityQueue<>(); //non-mst set
        boolean[] vis = new boolean[V]; //mst set
        
        pq.add(new Pair(0,0));
        int cost=0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int currNode = curr.node;
            if(!vis[currNode]){
                cost+=curr.dist;
                vis[currNode] = true;
                for(int i=0;i<graph[currNode].size();i++){
                    Edge e = graph[currNode].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        System.out.println(cost);
    }
    
	public static void main(String[] args) {
		int V = 4;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph,V);
		prims(graph,V);
	}
}

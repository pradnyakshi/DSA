//O(E + Elog(V))
import java.util.*;

public class DijstrasAlgorithm
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
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }
    
    public static void createGraph(ArrayList<Edge> graph[],int V){
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));
        
        graph[2].add(new Edge(2,4,3));
        
        graph[3].add(new Edge(3,5,1));
        
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    
    public static void dijkstrasAlgo(ArrayList<Edge> graph[],int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int currNode = curr.node;
            if(!vis[currNode]){
                vis[currNode] = true;
                for(int i=0;i<graph[currNode].size();i++){
                    Edge e = graph[currNode].get(i);
                    if(dist[currNode] + e.wt < dist[e.dest]){
                        dist[e.dest] = dist[currNode] + e.wt;
                        pq.add(new Pair(e.dest,dist[e.dest]));
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.println("0 ->" + i + " " + dist[i]);
        }
    }
    
	public static void main(String[] args) {
		int V = 6;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph,V);
		dijkstrasAlgo(graph,V);
	}
}

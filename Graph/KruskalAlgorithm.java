/******************************************************************************
Kruskal's Algorithm - MST
*******************************************************************************/
import java.util.*;

public class KruskalAlgorithm
{
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }
    
    static class UnionFind{
        static int[] parent;
        
        UnionFind(int size){
            parent = new int[size];
            for(int i=0;i<size;i++){
                parent[i] = i;
            }
        }
        
        public static int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public static void union(int x,int y){
            int xRoot = find(x);
            int yRoot = find(y);
            
            if(xRoot != yRoot){
                parent[xRoot] = yRoot;
            }
        }
    }
    
    public static ArrayList<Edge> kruskalAlgorithm(ArrayList<Edge> edges,int V){
        ArrayList<Edge> mst = new ArrayList<>();
        UnionFind uf = new UnionFind(V);
        
        Collections.sort(edges);
        
        for(Edge e: edges){
            int srcRoot = uf.find(e.src);
            int destRoot = uf.find(e.dest);
            if(srcRoot != destRoot){
                mst.add(e);
                uf.union(srcRoot,destRoot);
            }
        }
        return mst;
    }
    
	public static void main(String[] args) {
		ArrayList<Edge> edges = new ArrayList<>();
		int V= 4;
		edges.add(new Edge(3,1,40));
		edges.add(new Edge(0,1,10));
		edges.add(new Edge(0,3,30));
		edges.add(new Edge(0,2,15));
		edges.add(new Edge(2,3,50));
		ArrayList<Edge> mst = kruskalAlgorithm(edges,V);
		for(Edge e : mst){
		    System.out.println(e.src + " -> " + e.dest + " = " + e.wt);
		}
	}
}

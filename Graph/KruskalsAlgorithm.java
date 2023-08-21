import java.util.*;
public class KruskalsAlgorithm
{
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
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
        public UnionFind(int size){
            parent = new int[size];
            for(int i=0;i<size;i++){
                parent[i] = i;
            }
        }
        
        public static int find(int x){
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        
        public static void union(int x,int y){
            int xroot = find(x);
            int yroot = find(y);
            if(xroot != yroot){
                parent[xroot] = yroot;
            }
        }
    }
    
    public static void createGraph(ArrayList<Edge> edges,int V){
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        
        edges.add(new Edge(1,0,10));
        edges.add(new Edge(1,3,40));
        
        edges.add(new Edge(2,0,15));
        edges.add(new Edge(2,3,50));
        
        edges.add(new Edge(3,0,30));
        edges.add(new Edge(3,1,40));
        edges.add(new Edge(3,2,50));
    }
    
    public static void kruskalsAlgo(ArrayList<Edge> edges,int V){
        Collections.sort(edges);
        ArrayList<Edge> mst = new ArrayList<>();
        UnionFind uf = new UnionFind(V);
        
        for(Edge e : edges){
            int srcRoot = uf.find(e.src);
            int destRoot = uf.find(e.dest);
            if(srcRoot != destRoot){
                mst.add(e);
                uf.union(srcRoot,destRoot);
            }
        }
        
        for(Edge e : mst){
            System.out.println(e.src + " -> " + e.dest + " = " + e.wt);
        }
    }
    
	public static void main(String[] args) {
		int V = 4;
		ArrayList<Edge> edges = new ArrayList<>();
		createGraph(edges,V);
		kruskalsAlgo(edges,V);
	}
}

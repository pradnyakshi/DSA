import java.util.*;

public class DiameterOfTree
{
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    public static int height(Node root){	//O(n)
    	if(root == null){
    		return 0;
    	}
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public static int diameter1(Node root){		//O(n^2)
    	if(root == null){
    		return 0;
    	}
    	int d1 = diameter1(root.left);
    	int d2 = diameter1(root.right);
    	int d3 = height(root.left) + height(root.right) + 1;
    		
    	return Math.max(d1,Math.max(d2,d3));
    }
    
    static class NodeInfo{
        int h;
        int d;
        public NodeInfo(int h,int d){
            this.h = h;
            this.d = d;
        }
    }
    
    public static NodeInfo diameter2(Node root){    //O(n)
        if(root == null){
            return new NodeInfo(0,0);
        }
        NodeInfo left = diameter2(root.left);
        NodeInfo right = diameter2(root.right);
        
        int h = 1 + Math.max(left.h,right.h);
        int d1 = left.d;
        int d2 = right.d;
        int d3 = left.h + right.h + 1;
        int d = Math.max(d1,Math.max(d2,d3));
        
        return new NodeInfo(h,d);
    }
    
	public static void main(String[] args) {
		int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
	    BinaryTree bt = new BinaryTree();
	    Node root = bt.buildTree(nodes);
	    System.out.println(diameter1(root));
	    System.out.println(diameter2(root).d);
	}
}

//height of binary tree - O(n)
import java.util.*;

public class HeightOfBT
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
    	public static int height(Node root){	//O(n)
    		if(root == null){
    			return 0;
    		}
    		return 1 + Math.max(height(root.left),height(root.right));
    	}
    }
    
	public static void main(String[] args) {
		int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
	    BinaryTree bt = new BinaryTree();
	    Node root = bt.buildTree(nodes);
	    System.out.println(bt.height(root));
	}
}

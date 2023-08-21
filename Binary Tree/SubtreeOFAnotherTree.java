import java.util.*;

public class SubtreeOFAnotherTree
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
    
    public static boolean isIdentical(Node root,Node subtree){
        if(root == null && subtree == null){
            return true;
        }
        if(root == null || subtree == null){
            return false;
        }
        if(root.data == subtree.data){
            return isIdentical(root.left,subtree.left) && isIdentical(root.right,subtree.right);
        }
        return false;
    }
    
    public static boolean isSubtree(Node root,Node subtree){
        if(subtree == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(root.data == subtree.data){
            return isIdentical(root,subtree);
        }
        return isSubtree(root.left,subtree) || isSubtree(root.right,subtree);
    }
    
	public static void main(String[] args) {
		Node root = new Node(9);
		root.left = new Node(7);
		root.right = new Node(4);
		root.left.left = new Node(8);
		root.left.right = new Node(1);
		root.left.right.left = new Node(2);
		root.left.right.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		
		Node subtree = new Node(1);
		subtree.left = new Node(2);
		subtree.right = new Node(3);
		
		
		System.out.println(isSubtree(root,subtree));
	}
}

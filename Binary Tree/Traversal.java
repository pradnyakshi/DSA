import java.util.*;

public class Traversal
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
        public static void preorder(Node root){   //O(n)
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){      //O(n)
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
        public static void postorder(Node root){        //O(n)
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
        public static void levelorder(Node root){       //O(n)
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node temp = q.remove();
                if(temp == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(temp.data + " ");
                    if(temp.left != null)
                        q.add(temp.left);
                    if(temp.right != null)
                        q.add(temp.right);
                }
            }
        }
    }
    
	public static void main(String[] args) {
		int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
	    BinaryTree bt = new BinaryTree();
	    Node root = bt.buildTree(nodes);
	    System.out.println("Preorder : ");
	    bt.preorder(root);
	    System.out.println();
	    System.out.println("Inorder : ");
	    bt.inorder(root);
	    System.out.println();
	    System.out.println("Postorder : ");
	    bt.postorder(root);
	    System.out.println();
	    System.out.println("Level order : ");
	    bt.levelorder(root);
	}
}

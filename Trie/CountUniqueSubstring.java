/*
Count Unique Substring - 
Given a string of length n of lowercase alphabet characters.we need to 
count total number of distinct substrings of this string.
*/

public class CountUniqueSubstring
{
    static class Node{
        Node[] children;
        boolean eow;
        public Node(){
            children = new Node[26];
            for(int i=0;i<25;i++){
                children[i] = null;
            }
            eow = false;
        }
    }
    static Node root = new Node();
    
    public static void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            if(i == word.length()-1){
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }
    public static int count(Node curr){
        if(curr == null){
            return 0;
        }
        int c = 0;
        for(int i=0;i<26;i++){
            if(curr.children[i] != null){
                c+=count(curr.children[i]);
            }
        }
        return c+1;
    }
    
	public static void main(String[] args) {
		String input = "apple";
		for(int i=0;i<input.length();i++){
		    insert(input.substring(i));
		}
		System.out.println(count(root));
	}
}

/*
Longest word with all prefixes -
Find the longest string in words such that every prefix 
of it is also in words.
*/
import java.util.*;
public class LongestWord
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
    
    public static void insert(String word){//O(L)
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
    
    public static String ans = "";
    public static void longestWord(Node curr,StringBuilder temp){
        if(curr == null){
            return;
        }
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null && curr.children[i].eow==true){
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(curr.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    
	public static void main(String[] args) {
		String[] words = {"a","banana","app","ap","appl","apply","apple"};
		for(int i=0;i<7;i++){
		    insert(words[i]);
		}
		longestWord(root,new StringBuilder(""));
		System.out.println(ans);
	}
}

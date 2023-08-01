/*Word break problem -
Givem an input string and a dictinory of words, finds out if the input 
string can be broken into a space-separated sequence of dictinory words.
*/

public class WordBreak
{
    static class Node{
        Node[] children;
        boolean eow;
        public Node(){
            children = new Node[26];
            for(int i=0;i<26;i++){
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
    
    public static boolean search(String word){//O(L)
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null)
                return false;
            if(i==word.length()-1 && curr.children[idx].eow==false)
                return false;
            curr = curr.children[idx];
        }
        return true;
    }
    
    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            String part1 = key.substring(0,i);
            String part2 = key.substring(i);
            if(search(part1) && wordBreak(part2))
                return true;
        }
        return false;
    }
    
	public static void main(String[] args) {
		String words[] = {"i","like","sam","samsung","machine","ice"};
		for(int i=0;i<6;i++){
		    insert(words[i]);
		}
		String key = "ilikesamsung";
		System.out.println(wordBreak(key));
	}
}

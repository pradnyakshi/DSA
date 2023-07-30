//Reverse sentence using stack
import java.util.*;

public class ReverseSentence
{
    public static void reverse(String s){
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            String word = "";
            while(i<s.length() && s.charAt(i)!=' '){
                word+=s.charAt(i);
                i++;
            }
            st.push(word);
        }
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }
    
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		String s = "Hey, how are you doing?";
		reverse(s);
	}
}

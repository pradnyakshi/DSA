import java.util.*;
public class RedundantParenthesis
{
    public static boolean redundantParenthesis(String s){
        Stack<Character> st = new Stack<>();
        boolean flag = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/' || s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else if(s.charAt(i) ==')'){
                if(st.peek() == '('){
                    flag = true;
                    return flag;
                }
                while(!st.isEmpty() && (st.peek()=='+' || st.peek()=='-' || st.peek()=='*' || st.peek()=='/')){
                    st.pop();
                }
                st.pop();
            }
        }
        return flag;
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String s = sc.next();
	    System.out.println(redundantParenthesis(s));
	}
}

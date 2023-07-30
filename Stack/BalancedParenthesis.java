import java.util.*;

public class BalancedParenthesis
{
    public static boolean isBalanced(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(st.peek() != '(')
                    return false;
                else{
                    st.pop();
                }
            }else if(s.charAt(i) == ']'){
                if(st.peek() != '[')
                    return false;
                else
                    st.pop();
            }else if(s.charAt(i) == '}'){
                if(st.peek() != '{')
                    return false;
                else
                    st.pop();
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(isBalanced(s));
	}
}

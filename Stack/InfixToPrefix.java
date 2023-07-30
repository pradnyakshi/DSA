//Infix to Postfix
import java.util.*;

public class InfixToPrefix
{
    public static int prec(char x){
        if(x == '^')
            return 3;
        else if(x=='*' || x=='/')
            return 2;
        else if(x=='+' || x=='-')
            return 1;
        return -1;
    }
    
    public static String infixToPostfix(String s){
        Stack<Character> st = new Stack<>();
        String ans = "";
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z')){
                ans+=s.charAt(i);
            }
            else if(s.charAt(i) == ')'){
                st.push(')');
            }
            else if(s.charAt(i) == '('){
                while(!st.isEmpty() && st.peek() != ')'){
                    ans+=st.pop();
                }
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                while(!st.isEmpty() && prec(st.peek()) > prec(s.charAt(i))){
                    ans+=st.pop();
                }
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
    
    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    
    public static void infixToPrefix(String s){
        s = reverse(s);
        String ans = infixToPostfix(s);
        ans = reverse(ans);
        System.out.println(ans);
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		infixToPrefix(s);
	}
}

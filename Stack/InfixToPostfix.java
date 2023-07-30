//Infix to Postfix
import java.util.*;

public class InfixToPostfix
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
    public static void infixToPostfix(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z')){
                System.out.print(s.charAt(i));
            }
            else if(s.charAt(i) == '('){
                st.push('(');
            }
            else if(s.charAt(i) == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    System.out.print(st.pop());
                }
                st.pop();
            }else{
                while(!st.isEmpty() && prec(st.peek()) > prec(s.charAt(i))){
                    System.out.print(st.pop());
                }
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop());
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		infixToPostfix(s);
	}
}

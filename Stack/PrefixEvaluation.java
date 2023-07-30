//Prefix Expression evaluation
import java.util.*;

public class PrefixEvaluation
{
    public static int evaluate(String s){
        Stack<Integer> st = new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                st.push(s.charAt(i)- '0');
            }else{
                int op1 = st.pop();
                int op2 = st.pop();
                switch(s.charAt(i)){
                    case '+':
                        st.push(op1 + op2);
                        break;
                    case '-':
                        st.push(op1 - op2);
                        break;
                    case '*':
                        st.push(op1 * op2);
                        break;
                    case '/':
                        st.push(op1 / op2);
                        break;
                    case '^':
                        st.push((int)Math.pow(op1,op2));
                        break;
                }
            }
        }
        return st.pop();
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println("ans = " + evaluate(s));
	}
}

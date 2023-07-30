//Reverse stack
import java.util.*;

public class ReverseStack
{
    public static void insertAtBottom(Stack<Integer> st, int ele){
        if(st.isEmpty()){
            st.push(ele);
            return;
        }
        int top = st.pop();
        insertAtBottom(st,ele);
        st.push(top);
    }
    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int ele = st.pop();
        reverseStack(st);
        insertAtBottom(st,ele);
    }
    
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		reverseStack(st);
		while(!st.isEmpty()){
		    System.out.print(st.pop() + " ");
		}
		System.out.println();
	}
}

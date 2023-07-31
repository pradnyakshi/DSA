import java.util.*;
public class StackSpan
{
    static class Pair{
        int price;
        int days;
        Pair(int p,int d){
            this.price = p;
            this.days = d;
        }
    }
    
    public static void stockSpan(int arr[],int n){
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<n;i++){
            int d = 1;
            while(!st.isEmpty() && st.peek().price<=arr[i]){
                Pair p = st.pop();
                d+=p.days;
            }
            st.push(new Pair(arr[i], d));
            System.out.print(d + " ");
        }
    }

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int arr[] = new int[n];
	    for(int i=0;i<n;i++){
	        arr[i] = sc.nextInt();
	    }
	    System.out.println("****************");
	    stockSpan(arr,n);
	}
}

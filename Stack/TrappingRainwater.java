import java.util.*;

public class TrappingRainwater
{
    public static int rainwaterHarvesting(int arr[],int n){
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()] < arr[i]){
                int curr = s.peek();
                s.pop();
                if(s.isEmpty()){
                    break;
                }
                int diff = i - s.peek() - 1;
                ans+= (Math.min(arr[s.peek()],arr[i]) - arr[curr])*diff;
            }
            s.push(i);
        }
        return ans;
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int arr[] = new int[n];
	    for(int i=0;i<n;i++){
	        arr[i] = sc.nextInt();
	    }
	    int ans = rainwaterHarvesting(arr,n);
	    System.out.println(ans);
	}
}

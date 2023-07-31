//Largest Rechangle 

import java.util.*;
public class LargestAreaRect
{
    public static int maxArea(ArrayList<Integer> arr,int n){
        Stack<Integer> st = new Stack<>();
        arr.add(0);
        int ans =0;
        int i=0;
        while(i<=n){
            while(!st.isEmpty() && arr.get(st.peek())>arr.get(i)){
                int h = arr.get(st.pop());
                if(st.isEmpty()){
                    ans = Math.max(ans,h*i);
                }else{
                    int width = i - st.peek() - 1;
                    ans = Math.max(ans,h*width);
                }
            }
            st.push(i);
            i++;
        }
        return ans;
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    ArrayList<Integer> arr = new ArrayList<>();
	    for(int i=0;i<n;i++){
	        arr.add(sc.nextInt());
	    }
	    System.out.println(maxArea(arr,n));
	}
}

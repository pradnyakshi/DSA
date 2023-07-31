import java.util.*;
public class ThreeSum
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int k = sc.nextInt();
	    int arr[] = new int[n];
	    for(int i=0;i<n;i++){
	        arr[i] = sc.nextInt();
	    }
	    boolean found = false;
	    Arrays.sort(arr);
	    for(int i=0;i<n;i++){
	        int li = i+1;
	        int hi = n-1;
	        
	        while(li < hi){
	            int current = arr[i] + arr[li] + arr[hi];
	            if(current == k){
	                found = true;
	                break;
	            }else if(k < current){
	                hi--;
	            }else{
	                li++;
	            }
	        }
	    }
	    System.out.println(found);
	}
}

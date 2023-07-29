//Linear search - O(n)
import java.util.*;

public class Main
{
    public static int linear_search(int[] arr,int n,int key){
        for(int i=0;i<n;i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
		    arr[i] = sc.nextInt();
		}
		int key = sc.nextInt();
		int idx = linear_search(arr,n,key);
		if(idx != -1){
		    System.out.println("Key is present at index " + idx);
		}else{
		    System.out.println("Key is not present");
		}
	}
}

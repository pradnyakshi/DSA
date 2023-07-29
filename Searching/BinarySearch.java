//Binary search - O(log(n))
import java.util.*;

public class BinarySearch
{
    public static int binary_search(int arr[],int n,int key){
        int s = 0;
        int e = n-1;
        while(s <= e){
            int mid = (s+e)/2;
            if(arr[mid] == key){
                return mid;
            }else if(key < arr[mid]){
                e = mid-1;
            }else{
                s = mid+1;
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
		int idx = binary_search(arr,n,key);
		if(idx != -1){
		    System.out.println("Key is present at index " + idx);
		}else{
		    System.out.println("Key is not present");
		}
	}
}

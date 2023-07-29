//Selection Sort - O(n^2)
import java.util.*;

public class SelectionSort
{
    public static void selectionSort(int arr[],int n){
        for(int i=0;i<n-1;i++){
            int mIdx = i;
            int min = arr[i];
            for(int j=i+1;j<n;j++){
                if(arr[j] < min){
                    mIdx = j;
                    min = arr[j];
                }
            }
            int temp = arr[i];
            arr[i] = arr[mIdx];
            arr[mIdx] = temp;
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
		    arr[i] = sc.nextInt();
		}
		selectionSort(arr,n);
		for(int i=0;i<n;i++){
		    System.out.print(arr[i] + " ");
		}
	}
}

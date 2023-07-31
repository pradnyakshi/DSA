import java.util.*;

public class MaxConsecutiveOnes
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
		    arr[i] = sc.nextInt();
		}
		int zerocnt =0;
		int i=0;
		int ans = 0;
		for(int j=0;j<n;j++){
		    if(arr[j]==0){
		        zerocnt++;
		    }
		    while(zerocnt > k){
		        if(arr[i] == 0){
		            zerocnt--;
		        }
		        i++;
		    }
		    ans = Math.max(ans,j-i+1);
		}
		System.out.println(ans);
	}
}

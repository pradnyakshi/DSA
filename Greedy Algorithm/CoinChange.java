/*
Indian Coin Change Problem :
You are given an array of Denominations and a value X. You need 
to find the minimum number of coins required to make value X.
*/
import java.util.*;
public class CoinChange
{
	public static void main(String[] args) {
		int arr[] = {1,2,5,10,20,50,100,200,500,2000};
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int ans = 0;
		for(int i=arr.length-1;i>=0;i--){
		    ans+= x/arr[i];
		    x-= x/arr[i] * arr[i];
		}
		System.out.println(ans);
	}
}

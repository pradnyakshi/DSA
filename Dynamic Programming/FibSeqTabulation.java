/******************************************************************************
Dynamic Programming - Fibonacci Sequence
using Tabulation(Bottom-Up)
*******************************************************************************/
import java.util.*;
public class FibSeqTabulation
{
    public static int fib(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int res = fib(n);
		System.out.println(res);
	}
}

/******************************************************************************
Dynamic Programming - Fibonacci Sequence
using Memoization(Top-down)
*******************************************************************************/
import java.util.*;
public class FibSeqMemo
{
    public static int fib(int n,int[] dp){
        if(n==0 || n==1)
            return n;
        
        if(dp[n] != -1)
            return dp[n];
        
        int res = fib(n-1,dp) + fib(n-2,dp);
        dp[n] = res;
        return res;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		Arrays.fill(dp,-1);
		int res = fib(n,dp);
		System.out.println(res);
	}
}

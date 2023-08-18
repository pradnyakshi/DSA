/******************************************************************************
Dynamic Programming - Minimum Number of Squares(Memoization)
Minimum number of squares whose sum equals to given number 'n'.
*******************************************************************************/
import java.util.*;
public class MinSquareMemo
{
    public static int minSquare(int n,int[] dp){
        if(n==0 || n==1 || n==2 || n==3){
            return n;
        }
        if(dp[n] != Integer.MAX_VALUE){
            return dp[n];
        }
        for(int i=1;i*i<=n;i++){
            dp[n] = Math.min(dp[n], minSquare(n-i*i,dp)+1);
        }
        return dp[n];
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		System.out.println(minSquare(n,dp));
	}
}

/******************************************************************************
Dynamic Programming - Minimum Number of Squares(Tabulation)
Minimum number of squares whose sum equals to given number 'n'.
*******************************************************************************/
import java.util.*;
public class MinSquareTabulation
{
    public static int minSquare(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=1;i*i<=n;i++){
            for(int j=0;i*i+j<=n;j++){
                dp[i*i+j] = Math.min(dp[i*i+j],dp[j]+1);
            }
        }
        return dp[n];
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(minSquare(n));
	}
}

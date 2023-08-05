/******************************************************************************
Max and Min Difference:
You are given an array A of n elements. You have to remove exactly n/2 elements 
from array A and add it to another array B(initially empty).
Find maximum and minimum values of differences between these two arrays.
We define the difference between these two arrays are summation(abs(A[i]-B[i]))
*******************************************************************************/
import java.util.*;
public class MaxAndMinDifference
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
		    a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int mn =0;
		int mx =0;
		for(int i=0;i<n/2;i++){
		    mx += Math.abs(a[n-1-i]-a[i]);
		    mn += Math.abs(a[2*i+1] - a[2*i]);
		}
		System.out.println(mn + " " + mx);
	}
}

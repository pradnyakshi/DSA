/******************************************************************************
Optimal Merge Pattern:
Problem: You are given n files with their computation times in an array.
Operation: Choose/take any two files, add their computation times and append
it to the list of computation times.{cost = sum of compuattion time}
Do this util we are left with only one file in array. We have to do this operation
such that we get minimum cost finally.
*******************************************************************************/
import java.util.*;
public class OptimalMergePattern
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<n;i++){
		    int x = sc.nextInt();
		    pq.add(x);
		}
		int ans=0;
		while(pq.size() > 1){
		    int n1 = pq.remove();
		    int n2 = pq.remove();
		    ans+=(n1+n2);
		    pq.add(n1+n2);
		}
		System.out.println(ans);
	}
}

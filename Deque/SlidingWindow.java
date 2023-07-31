//Sliding Window Maximum - O(n)

import java.util.*;
public class SlidingWindow
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
		    arr[i] = sc.nextInt();
		}
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=0;i<k;i++){
		    while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
		        dq.removeLast();
		    }
		    dq.addLast(i);
		}
		System.out.println("*****************");
		System.out.print(arr[dq.peek()] + " ");
		for(int i=k;i<n;i++){
		    if(i-k == dq.peek()){
		        dq.remove();
		    }
		    while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
		        dq.removeLast();
		    }
		    dq.addLast(i);
		    System.out.print(arr[dq.peek()] + " ");
		}
	}
}

/*
Activity Selection Problem:
You are given n activities with their start and finish times. Select the
maximum number of activities that can be performed by a single person, 
assuming that a person can only work on single activity at a time.
*/
import java.util.*;
public class ActivitySelection
{
    static class Activity implements Comparable<Activity>{
        int start;
        int end;
        Activity(int s,int e){
            this.start = s;
            this.end = e;
        }
        @Override
        public int compareTo(Activity a){
            return this.end - a.end;
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Activity[] arr = new Activity[n];
		for(int i=0;i<n;i++){
		    int s,e;
		    s = sc.nextInt();
		    e = sc.nextInt();
		    arr[i] = new Activity(s,e);
		}
		Arrays.sort(arr);
		int ans = 1;
		int end = arr[0].end;
		for(int i=1;i<n;i++){
		    if(arr[i].start >= end){
		        ans++;
		        end = arr[i].end;
		    }
		}
		System.out.println(ans);
	}
}

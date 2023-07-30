//Permutation of array containing distict elements
import java.util.*;

public class Permutation1
{
    public static void swap(ArrayList<Integer> arr,int i,int idx){
        int temp = arr.get(i);
        arr.set(i,arr.get(idx));
        arr.set(idx,temp);
    }
    
    public static void solve(ArrayList<Integer> arr,int idx,int n,ArrayList<ArrayList<Integer>> ans){
        if(idx >= n){
            ans.add(new ArrayList<Integer>(arr));
            return;
        }
        for(int i=idx;i<n;i++){
            swap(arr ,i,idx);
            solve(arr,idx+1,n,ans);
            swap(arr,i,idx);
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i=0;i<n;i++){
		    arr.add(sc.nextInt());
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		solve(arr,0,n,ans);
		System.out.println("-----------------");
		for(int i=0;i<ans.size();i++){
		    ArrayList<Integer> a = ans.get(i);
		    for(int j=0;j<a.size();j++){
		        System.out.print(a.get(j) + " ");
		    }
		    System.out.println();
		}
	}
}

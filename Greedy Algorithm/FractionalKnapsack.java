/******************************************************************************
Fractional Knapsack:
We are given n items with {weigth,value} of each item and the capacity of Knapsack
(sack) 'W'. We need to put these items in Knapsack such that final value of items
in Knapsack is maximum.
*******************************************************************************/
import java.util.*;
public class FractionalKnapsack
{
    static class Item implements Comparable<Item>{
        int wt;
        int val;
        public Item(int w,int v){
            this.wt = w;
            this.val = v;
        }
        @Override
        public int compareTo(Item i){
            int w1 = this.val/this.wt;
            int w2 = i.val/i.wt;
            return w2 - w1;
        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Item[] items = new Item[n];
		for(int i=0;i<n;i++){
		    int v = sc.nextInt();
		    int w = sc.nextInt();
		    items[i] = new Item(w,v);
		}
		Arrays.sort(items);
		int ans =0;
		int w = sc.nextInt();
		for(int i=0;i<n;i++){
		    if(w>=items[i].wt){
		        w-=items[i].wt;
		        ans+=items[i].val;
		        continue;
		    }
		    ans+=(items[i].val/items[i].wt)*w;
		    w=0;
		    break;
		}
		System.out.println(ans);
	}
}

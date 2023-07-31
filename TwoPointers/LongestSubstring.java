//Longest substring without repeating character
import java.util.*;

public class LongestSubstring
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String s = sc.next();
	    HashMap<Character,Integer> hmap = new HashMap<>();
	    int ans = 0;
	    int start = -1;
	    for(int i=0;i<s.length();i++){
	        if(hmap.containsKey(s.charAt(i))){
	            start = hmap.get(s.charAt(i));
	        }
	        hmap.put(s.charAt(i),i);
	        ans = Math.max(ans,i-start);
	    }
	    System.out.println(ans);
	}
}

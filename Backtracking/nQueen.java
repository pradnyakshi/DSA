//Insertion Sort - O(n^2)
import java.util.*;

public class nQueen
{
    public static boolean isSafe(int q[][],int row,int col,int n){
        for(int i = row;i>=0;i--){
            if(q[i][col] == 1){
                return false;
            }
        }
        
        int x = row;
        int y = col;
        while(x>=0 && y>=0){
            if(q[x][y] == 1){
                return false;
            }
            x--;
            y--;
        }
        
        x = row;
        y = col;
        while(x>=0 && y<n){
            if(q[x][y] == 1){
                return false;
            }
            x--;
            y++;
        }
        return true;
    }
    
    public static boolean nQueen(int q[][],int row,int n){
        if(row >= n){
            return true;
        }
        for(int col=0;col<n;col++){
            if(isSafe(q,row,col,n)){
                q[row][col] = 1;
                if(nQueen(q,row+1,n))
                    return true;
                q[row][col] = 0;
            }
        }
        return false;
    }
    
    public static void main (String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] q = new int[n][n];
        if(nQueen(q,0,n)){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(q[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

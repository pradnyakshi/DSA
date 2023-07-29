import java.util.*;

public class RatInMaze
{
    public static boolean isSafe(int arr[][],int x,int y,int n){
        if(x<n && y<n && arr[x][y]==1){
            return true;
        }
        return false;
    }
    
    public static boolean ratInMaze(int arr[][],int x,int y,int n,int sol[][]){
        if(x==n-1 && y==n-1){
            sol[x][y] = 1;
            return true;
        }
        
        if(isSafe(arr,x,y,n)){
            sol[x][y] = 1;
            if(ratInMaze(arr,x+1,y,n,sol)){
                return true;
            }
            if(ratInMaze(arr,x,y+1,n,sol)){
                return true;
            }
            sol[x][y] = 0;
        }
        return false;
    }
    
    public static void main (String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] sol = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
                sol[i][j] = 0;
            }
        }
        System.out.println("------------------");
        if(ratInMaze(arr,0,0,n,sol)){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(sol[i][j] + " ");
                }
                System.out.println();
            }
        }else{
            System.out.println("No solution");
        }
    }
}

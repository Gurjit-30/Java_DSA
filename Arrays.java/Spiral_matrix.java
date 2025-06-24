import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner s=new Scanner(System.in);
	    int n=4;
	    int[][] arr={{4,2,0,6},{5,0,2,3},{6,1,9,8},{7,7,2,3}};
	   // for(int i=0;i<n;i++){
	   //     for(int j=0;j<n;j++){
	   //         arr[i][j]=s.nextInt();
	            
	   //     }
	   // }
	    int sr=0;
	    int sc=0;
	    int er=n-1;
	    int ec=arr[0].length-1;
	    while(sr<=er &&sc<=ec){
	        for(int i=sc;i<=ec;i++){
	            System.out.print(arr[sr][i]);
	        }
	        for(int j=sr+1;j<=er;j++){
	            System.out.print(arr[j][ec]);
	        }
	        for(int i=ec-1;i>=sc;i--){
	            if(sr==er){
	                break;
	            }
	            System.out.print(arr[er][i]);
	        }
	        for(int j=er-1;j>=sr+1;j--){
	            if(sc==ec){
	                break;
	            }
	            System.out.print(arr[j][sc]);
	        }
	        sr++;
	        sc++;
	        ec--;
	        er--;
	        
	    }
		// your code goes here

	}
}

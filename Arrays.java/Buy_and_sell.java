import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int[] arr=new int[n];
	    for(int i=0;i<n;i++){
	        arr[i]=sc.nextInt();
	        
	    }
	   
int buy=Integer.MAX_VALUE;

        int ma=0;
	    for(int i=0;i<n;i++){
	    
	        
	            if(buy<arr[i]){
	                int pro=arr[i]-buy;
	                ma=Math.max(pro,ma);
	                
	            }else{
                    buy=arr[i];
                }
	        
	    }
	    System.out.print("maximum sum:"+ma);
		// your code goes here

	}
}

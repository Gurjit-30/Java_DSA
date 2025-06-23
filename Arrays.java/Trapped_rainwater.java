import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
		    
		}
		int[] left=new int[n];
		int[] right=new int[n];
		for(int i=1;i<n;i++){
		    left[0]=arr[0];
		    left[i]=Math.max(left[i-1],arr[i]);
		}
			for(int i=n-2;i>0;i--){
			  right[n-1]=arr[n-1];
		    right[i]=Math.max(arr[i],right[i+1]);
		}
		int s=0;
		for(int i=0;i<n;i++){
		    int water=Math.min(left[i],right[i]);
		    int trap=water-arr[i];
		    if(trap<0){
		        trap=0;
		    }
		    s+=trap;
		    
		}
		System.out.println("total trapped rainwater:"+s);

	}
}

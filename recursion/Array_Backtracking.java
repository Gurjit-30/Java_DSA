import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void arrayBa(int[] arr,int i,int val){
        if(i==arr.length){
            return ;
        }
        arr[i]=val;
        arrayBa(arr,i+1,val+1);
        arr[i]=arr[i]-2;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    int[] arr=new int[5];
	    arrayBa(arr,0,1);
	    for(int f:arr){
	        System.out.println(f);
	    }
	    
		// your code goes here

	}
}

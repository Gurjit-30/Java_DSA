import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static int check(int[] arr,int key,int i){
        if(i==arr.length-1){
            return -1;
        }
        if((arr[i]==key)){
            return i;
        }else{
             return check(arr,key,i+1);
            
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    int[] arr={1,2,3,4,4,5};
	    int key=4;
	    System.out.println(check(arr,key,0));
		// your code goes here

	}
}

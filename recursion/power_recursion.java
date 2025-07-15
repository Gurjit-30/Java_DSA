import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static int check(int x,int n){
        if(n==0){
            return 1;
        }
        return x*check(x,n-1);
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    int[] arr={1,2,3,4,4,5};
	    int key=4;
	    System.out.println(check(2,10));
		// your code goes here

	}
}

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static int check(int n){
        if(n==0||n==1){
            return 1;
        }
        int vertical=check(n-1);
        int hori=check(n-2);
        return vertical+hori;
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    System.out.println(check(4));
		// your code goes here

	}
}

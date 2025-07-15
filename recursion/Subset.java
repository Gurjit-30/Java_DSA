import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void subset(String st,String ans,int i){
        if(i==st.length()){
            System.out.println(ans);
            return ;
        }
        subset(st,ans+st.charAt(i),i+1);
        subset(st,ans,i+1);
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    String arr="ibadhj";
	    String an=new String();
	    subset(arr,an,0);
		// your code goes here

	}
}

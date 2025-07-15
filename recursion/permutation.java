import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void permu(String st,String ans){
        if(st.length()==0){
            System.out.println(ans);
            return ;
        }
        for(int i=0;i<st.length();i++){
            char ch=st.charAt(i);
            String j=st.substring(0,i)+st.substring(i+1);
            permu(j,ans+ ch);
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    String arr="eat";
	    permu(arr,"");
		// your code goes here

	}
}

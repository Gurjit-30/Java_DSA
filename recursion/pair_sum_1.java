import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    ArrayList<Integer> li=new ArrayList<>();
	    for(int i=1;i<=6;i++){
	        li.add(i);
	    }
	    int tar=6;
	    int s=0,e=li.size()-1;
	    while(s<e){
	        if(li.get(s)+li.get(e)==tar){
	            System.out.println(li.get(s)+" "+li.get(e));
	            break;
	        }else if(li.get(s)+li.get(e)<tar){
	            s++;
	        }else{
	            e--;
	        }
	    }
		// your code goes here

	}
}

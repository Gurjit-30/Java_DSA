import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    ArrayList<Integer> li=new ArrayList<>();
	    li.add(11);
	    li.add(15);
	    li.add(2);
	    li.add(4);
	    li.add(6);
	    li.add(9);
	    li.add(10);
	    
	    int tar=13;
	    int pi=0;
	    for(int i=0;i<li.size()-1;i++){
	        if(li.get(i)>li.get(i+1)){
	            pi=i;
	        }
	    }
	    int s=pi+1,e=pi;
	    while(s!=e){
	        if(li.get(s)+li.get(e)==tar){
	            System.out.println(li.get(s)+" "+li.get(e));
	            break;
	        }else if(li.get(s)+li.get(e)<tar){
	            s=(s+1)%li.size();
	        }else{
	            e=(li.size()+e-1)%li.size();
	        }
	    }
		// your code goes here

	}
}

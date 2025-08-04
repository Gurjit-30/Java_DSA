import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
    
    
	
    {
    //creation of hashmap
	   HashMap<Character,Integer>map=new HashMap<>();
	   String s="race",t="acer";
	   for(int i=0;i<s.length();i++){
	       char ch=s.charAt(i);
	       map.put(ch,map.getOrDefault(ch,0)+1);
	   }
	   for(int i=0;i<t.length();i++){
	       char x=t.charAt(i);
	       if(map.get(x)!=null){
	           if(map.get(x)==1){
	               map.remove(x);
	           }else{
	               map.put(x,map.get(x)-1);
	           }
	       }else{
	           System.out.println("false ll");
	       }
	   }
	   System.out.println(map.isEmpty());
	   
	   
	       
	   }
	}


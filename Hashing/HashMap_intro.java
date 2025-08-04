import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
    
    
	
    {
    //creation of hashmap
	    HashMap<String,Integer>map=new HashMap<>();
        //put()
	    map.put("aman", 8);
	    map.put("man", 9);
        
	    System.out.println(map);
        //get()
        int bc=map.get("aman");
        System.out.println(bc);
        //containsKey
        System.out.println(map.containsKey("aman"));
        System.out.println(map.containsKey("ama"));
        //iteration
        Set<String> se=map.keySet();
        for(String x:se){
        System.out.println(map.get(x));
        }
        // your code goes here

	}
}

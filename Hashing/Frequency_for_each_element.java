import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
    
    
	
    {
    //creation of hashmap
	   HashMap<Integer,Integer>map=new HashMap<>();
	   int arr[]={1,2,4,56,6,8,6,3,2,1,1,1,12,2,6};
	   for(int i=0;i<arr.length;i++){
	       map.put(arr[i],map.getOrDefault(arr[i],0)+1);
	   }
	   Set<Integer> ks=map.keySet();
	   for(Integer x:ks){
	       System.out.println("the value for "+x+" is "+map.get(x));
	       
	   }
	}
}

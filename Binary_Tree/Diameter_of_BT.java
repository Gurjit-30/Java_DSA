import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static class info{
        int dia,ht;
        info(int dia,int ht){
            this.dia=dia;
            this.ht=ht;
            
        }
        
    }
    public static info rad(Node root){
        info li=rad(root.left);
        info ri=rad(root.right);
        int dia =Math.max(Math.max(li.dia,ri.dia),li.ht+ri.ht+1);
        int ht=Math.max(li.ht,ri.ht);
        return new info(dia,ht);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    
		// your code goes here

	}
}

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node Head;
    public static boolean isCyclic(){
        Node slow=Head;
        Node fast=Head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow ){
                return true;
            }
        } return false;
        }
	public static void main (String[] args) throws java.lang.Exception
	{
	    Head=new Node(1);
	    Head.next=new Node(3);
	    Head.next.next=new Node(8);
	    Head.next.next.next=Head;
	    System.out.println(isCyclic());
		// your code goes here

	}
}

package LinkedList;
import java.util.*;
import java.lang.*;
import java.io.*;

class LL
{
    public static  class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
            
        }
    }
    public static Node Head;
    public static Node tail;
    public void add(int data){
        Node newNode=new Node(int data);
        if(head==null){
            head=tail=null;
        }
        newNode.next=head;
        head=newNode;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    LL li=new LL();
	    li.add(2);
	    li.add(3);
	    li.add(5);
	    li.add(7);
	    
		// your code goes here

	}
}
d
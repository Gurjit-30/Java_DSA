import java.util.*;
import java.lang.*;
import java.io.*;

class LL
{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data ;
            this.next=null;
        }
    }
    public static Node Head;
     public static Node Tail;
     public void addlast(int data){
         Node newNode=new Node(data);
         if(Head==null){
             Head=Tail=newNode;
             return;
         }
         Tail.next=newNode;
         Tail=newNode;
     }
     public void print(){
         if(Head==null){
             System.out.println("LL is Empty");
         }
         Node temp=Head;
         while(temp!=null){
             System.out.println(temp.data);
             temp=temp.next;
         }
     }
	public static void main (String[] args) throws java.lang.Exception
	{
	    LL li=new LL();
	    li.addlast(3);
	     li.addlast(4);
	      li.addlast(6);
	       li.addlast(7);
	       li.print();
		// your code goes here

	}
}

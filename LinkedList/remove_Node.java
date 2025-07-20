import java.util.*;
import java.lang.*;
import java.io.*;

class LL
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
    public static Node Tail;
    public static int size=0;
    public void add(int data){
        Node newNode=new Node(data);
        if(Head==null){
            Head=Tail=newNode;
            size++;
            return;
            
        }
        newNode.next=Head;
        Head=newNode;
        size++;
    }
    public void  remove(){//from first
    if (size==0){
        System.out.println("LL is empty");
        return ;
    }else if(size==1){
        int val =Head.data;
        Head=Tail=null;
        return ;
        
    }else{
        int val=Head.data;
        Head=Head.next;
        System.out.println(val+" deleted");
        return ;
    }
        
    } 
    public void removee(){
        if(size==0){
            System.out.println("LL is empty");
        }else if(size==1){
            Head=Tail=null;
        }else{
            Node temp=Head;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            int val =Head.data;
            temp.next=null;
            System.out.println(val+ "deleted");
        }
        
    }//last 
    
    
    public void Print(){
        
        Node temp=Head;
        while(temp==null){
            System.out.println(temp.data);
            temp=temp.next;
            size++;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    LL li=new LL();
	    li.remove();
	    li.add(3);
	    	    li.add(8);
	    	    	    li.add(5);
	    	    	    	    li.add(9);
	    	    	    	    	    li.add(10);
	    	    	    	    	    li.removee();
	    	    	    	    	    
		// your code goes here

	}
}

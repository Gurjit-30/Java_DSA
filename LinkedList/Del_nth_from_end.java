import java.util.*;
import java.lang.*;
import java.io.*;

class LL
{
    public static class Node{
        int data ;
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
        Node newN=new Node(data);
        if(Head==null){
            Head=Tail=newN;
            size++;
            return ;
        }
        newN.next=Head;
        Head=newN;
        size++;
        return ;
    }
    public void nDel(int n){
        
        int sz=0;
        if(n==0){
            return;
        }
        Node temp=Head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        int i=1;
        int ind=sz-n;
        Node prev=Head;
        while(i<ind){
            prev=prev.next;
            i++;
            
        }
        prev.next=prev.next.next;
        return;
        
        
    }
    
    public void print(){
        Node temp=Head;
        while(temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }    }
  
	public static void main (String[] args) throws java.lang.Exception
	{
	    LL li=new LL();
	    li.add(6);
	    li.add(9);
	    li.add(8);
	    li.add(7);
	    li.add(4);
	    li.print();
	    li.nDel(3);
	    System.out.println();
	    li.print();
	   

	}
}

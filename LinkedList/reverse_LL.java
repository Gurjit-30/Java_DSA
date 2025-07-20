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
    public void reverse(){
       
        Node prev=null;
        Node cur=Tail=Head;
        Node next;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        Head=prev;
    }
    public void print(){
        Node temp=Head;
        while(temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }    }
    public int help(int key,Node Head){
        if(Head==null){
            return -1;
        }
        if(Head.data==key){
            return 0;
        }
        int in=help(key,Head.next);
        if(in==-1){
            return -1;
        }
        
        return in+1;
        
        }
        public int search(int key){
            return help(key,Head);
        }
	public static void main (String[] args) throws java.lang.Exception
	{
	    LL li=new LL();
	    li.add(6);
	    li.add(9);
	    li.add(8);
	    li.add(7);
	    li.add(4);
	    System.out.println(size);
	    
	    System.out.println(li.search(6));
	    li.print();
	    li.reverse();
	    System.out.println();
	    li.print();
		// your code goes here

	}
}

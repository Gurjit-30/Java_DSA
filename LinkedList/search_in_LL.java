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
    public int search(int key){
        if(size==0){
            return -1;
        }
        int i=0;
        Node temp=Head;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            i++;
            temp=temp.next;
        }
        return -1;
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
		// your code goes here

	}
}

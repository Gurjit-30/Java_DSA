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
   public Node findmid(Node Head){
       Node slow=Head;
       Node fast=Head;
       while(fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
       }
       return slow;
   }
   public boolean pali(){
       //find findmid
       Node mid=findmid(Head);
       //reverse 2 nd half
       Node prev=null;
       Node cur=mid;
       Node next;
       while(cur!=null){
           next=cur.next;
           cur.next=prev;
           prev=cur;
           cur=next;
       }
       Node right=prev;
       Node left=Head;
       //check if 1st half is equl to 2nd
       while(right!=null){
           if(right.data != left.data){
               return false;
           }
           right=right.next;
           left=left.next;
       }
       return true;
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
	    li.add(9);
	    li.add(7);
	    System.out.println(li.pali());

	}
}

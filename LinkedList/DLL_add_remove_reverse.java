import java.util.*;
import java.lang.*;
import java.io.*;

class LL {
    // FIX: Corrected class definition
    public static class Node {
        int data;
        Node next;
        Node prev; // FIX: Corrected typo 'NOde'

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;

    // This method is correct
    public void add(int data) {
        Node nw = new Node(data);
        if (head == null) {
            head = tail = nw;
            return;
        }
        nw.next = head;
        head.prev = nw;
        head = nw;
    }

    // This method is also correct
    public void remov() {
        if (head == null) {
            System.out.println("LL is empty");
        } else if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // FIX: Corrected reverse method
    public void rever() {
        if(head == null || head.next == null) {
            return; // Nothing to reverse
        }
        
        Node cur = head;
        Node prevNode = null; // Renamed to avoid confusion with Node's 'prev' field
        Node nextNode;
        
        // Update the tail to be the original head
        tail = head;

        while (cur != null) {
            nextNode = cur.next;
            cur.next = prevNode;
            cur.prev = nextNode; // This part correctly swaps the pointers
            
            prevNode = cur;
            cur = nextNode;
        }
        // FIX: The head must be updated to the new head
        head = prevNode;
    }
    
    // Helper function to see the result
    public void print() {
        Node temp = head;
        if(temp == null) {
            System.out.println("List is empty.");
            return;
        }
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) throws java.lang.Exception {
        LL li = new LL();
        li.add(4);
        li.add(3);
        li.add(2);
        li.add(1);

        System.out.println("Original List:");
        li.print();

        li.rever();

        System.out.println("Reversed List:");
        li.print();
    }
}
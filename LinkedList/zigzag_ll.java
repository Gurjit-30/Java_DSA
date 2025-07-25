import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    // A Node class is needed to define the list structure
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // The head of the list
    private Node head;

    // Corrected zig-zag method
    public void zig() {
        if (head == null || head.next == null) {
            return;
        }

        // 1. Find mid
        Node sl = head;
        Node fa = head.next;
        while (fa != null && fa.next != null) {
            sl = sl.next;
            fa = fa.next.next;
        }
        
        // 2. Reverse 2nd half
        Node secondHead = sl.next;
        sl.next = null; // Split the list
        
        Node prev = null;
        Node cur = secondHead;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        // 3. Zig-zag merge
        Node rh = prev;   // Head of reversed right half
        Node lh = head;   // Head of left half
        
        Node nextL, nextR;
        while (lh != null && rh != null) {
            nextL = lh.next; // Store next from left half
            lh.next = rh;    // Link left to right
            
            nextR = rh.next; // Store next from right half
            rh.next = nextL; // Link right to next left
            
            // Move pointers forward
            lh = nextL;
            rh = nextR;
        }
    }

    // Utility function to add nodes
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Utility function to print the list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) throws java.lang.Exception {
        Codechef ll = new Codechef();
        for(int i = 1; i <= 6; i++){
            ll.addLast(i);
        }

        System.out.println("Original List:");
        ll.print();
        
        ll.zig();
        
        System.out.println("Zig-Zag List:");
        ll.print();
    }
}
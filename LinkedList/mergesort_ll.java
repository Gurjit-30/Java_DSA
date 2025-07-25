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

    // Utility function to add nodes to the front
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
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

    // Finds the node just before the midpoint
    private Node getm(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merges two sorted lists into one
    private Node merge(Node h1, Node h2) {
        Node temp = new Node(-1); // Dummy node
        Node mh = temp;
        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }
        }
        // Append remaining nodes
        if (h1 != null) {
            temp.next = h1;
        }
        if (h2 != null) {
            temp.next = h2;
        }
        // FIX: Return the node *after* the dummy node
        return mh.next;
    }

    // The main merge sort function
    public Node ms(Node head) {
        // FIX: Base case for recursion is essential
        if (head == null || head.next == null) {
            return head;
        }

        // 1. Divide
        Node mid = getm(head);
        Node rightHead = mid.next;
        // FIX: Split the list into two halves
        mid.next = null;

        // 2. Conquer (Recursive calls)
        Node sortedLeft = ms(head);
        Node sortedRight = ms(rightHead);

        // 3. Merge
        return merge(sortedLeft, sortedRight);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Codechef ll = new Codechef();
        ll.addFirst(2);
        ll.addFirst(5);
        ll.addFirst(28);
        ll.addFirst(25);
        ll.addFirst(9);

        System.out.println("Original List:");
        ll.print();

        // Call the merge sort on the list's head
        ll.head = ll.ms(ll.head);

        System.out.println("Sorted List:");
        ll.print();
    }
}
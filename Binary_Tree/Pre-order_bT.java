import java.util.*;
import java.lang.*;
import java.io.*;

class LL {
    // 1. Corrected Node class with a constructor
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class binary {
        static int i = -1;

        public static Node build(int arr[]) {
            // 2. FIX: Increment index at the start of the call
            i++;
            if (arr[i] == -1) {
                return null;
            }

            // A Node is created with the current data
            Node ne = new Node(arr[i]);
            ne.left = build(arr);
            ne.right = build(arr);
            return ne;
        }
    }

    // Helper function to print the tree and verify the result
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) throws java.lang.Exception {
        // The array must represent the tree in pre-order
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        // Build the tree
        Node root = binary.build(nodes);

        // Print the tree's root data to confirm it was built
        System.out.println("Root of the tree is: " + root.data);

        // Print the in-order traversal to see the full structure
        System.out.print("In-order traversal: ");
        inorderTraversal(root);
    }
}
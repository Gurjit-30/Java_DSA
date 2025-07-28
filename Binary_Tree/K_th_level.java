import java.util.*;

class Main {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Your function to print nodes at level k
    public static void printKthLevel(Node root, int level, int k) {
        // Base case: if the node is null, do nothing.
        if (root == null) {
            return;
        }
        
        // If we have reached the desired level k, print the node's data.
        if (level == k) {
            System.out.print(root.data + " ");
            return; // Stop going deeper
        }
        
        // Recur for the left and right subtrees, incrementing the level.
        printKthLevel(root.left, level + 1, k);
        printKthLevel(root.right, level + 1, k);
    }

    public static void main(String[] args) {
        /*
         * 1        (level 1)
         * / \
         * 2   3      (level 2)
         * / \   \
         * 4   5   6    (level 3)
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        
        int k = 3;
        System.out.println("Nodes at level " + k + ":");
        
        // Initial call: start at the root (level 1) to find nodes at level k.
        printKthLevel(root, 1, k); // Output will be: 4 5 6
    }
}
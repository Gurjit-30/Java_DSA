import java.util.*;

class BstDelete {

    // Definition for a binary tree node.
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * Deletes a node with the given value from a Binary Search Tree.
     *
     * @param root The root of the BST.
     * @param val  The value of the node to delete.
     * @return The root of the modified BST.
     */
    public static Node deleteNode(Node root, int val) {
        // Base case: If the tree is empty, return null.
        if (root == null) {
            return null;
        }

        // Search for the node to be deleted.
        if (root.data > val) {
            // The value is in the left subtree.
            root.left = deleteNode(root.left, val);
        } else if (root.data < val) {
            // The value is in the right subtree.
            root.right = deleteNode(root.right, val);
        } else {
            // This is the node to be deleted (root.data == val).

            // Case 1: Node is a leaf (no children).
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has one child.
            if (root.left == null) {
                return root.right; // Return the right child.
            } else if (root.right == null) {
                return root.left; // Return the left child.
            }

            // Case 3: Node has two children.
            // Find the in-order successor (smallest value in the right subtree).
            Node inOrderSuccessor = findInOrderSuccessor(root.right);
            // Replace the node's data with the successor's data.
            root.data = inOrderSuccessor.data;
            // Recursively delete the in-order successor from the right subtree.
            root.right = deleteNode(root.right, inOrderSuccessor.data);
        }
        return root;
    }

    /**
     * Helper function to find the in-order successor (the smallest node)
     * in a given subtree.
     *
     * @param root The root of the subtree to search in.
     * @return The node with the minimum value.
     */
    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    // Helper to print the tree in-order
    public static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) throws java.lang.Exception {
        // Create a sample BST
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        System.out.print("Original Tree (In-order): ");
        inorderPrint(root); // 3 5 6 8 10 11 
        System.out.println();

        // Delete a node with two children (5)
        root = deleteNode(root, 5);
        
        System.out.print("Tree after deleting 5: ");
        inorderPrint(root); // 3 6 8 10 11 
        System.out.println();
    }
}

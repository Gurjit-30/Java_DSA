import java.util.*;

class ValidateBst {

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
     * Public-facing method to check if a binary tree is a valid BST.
     * It initializes the recursive check with no constraints (min and max are null).
     *
     * @param root The root of the binary tree.
     * @return true if the tree is a valid BST, false otherwise.
     */
    public static boolean isValidBST(Node root) {
        // Start the recursive check with the widest possible range.
        return isValidBSTHelper(root, null, null);
    }

    /**
     * Helper function that recursively validates the BST properties.
     * It checks if the subtree at 'root' is valid, given that all its nodes
     * must have values between the 'min' and 'max' nodes' data.
     *
     * @param root The current node being checked.
     * @param min  The node representing the minimum allowed value for the current root.
     * @param max  The node representing the maximum allowed value for the current root.
     * @return true if the subtree is a valid BST, false otherwise.
     */
    private static boolean isValidBSTHelper(Node root, Node min, Node max) {
        // Base Case: An empty tree is a valid BST.
        if (root == null) {
            return true;
        }

        // Check if the current node's value violates the minimum constraint.
        // The value must be GREATER than the minimum allowed value.
        if (min != null && root.data <= min.data) {
            return false;
        }

        // Check if the current node's value violates the maximum constraint.
        // The value must be LESS than the maximum allowed value.
        if (max != null && root.data >= max.data) {
            return false;
        }

        // Recursively check the left and right subtrees.
        // The '&&' ensures that BOTH subtrees must be valid.
        // For the left child, the current node becomes the new MAXIMUM bound.
        // For the right child, the current node becomes the new MINIMUM bound.
        return isValidBSTHelper(root.left, min, root) &&
               isValidBSTHelper(root.right, root, max);
    }

    public static void main(String[] args) {
        // Example 1: A valid BST
        Node validRoot = new Node(8);
        validRoot.left = new Node(5);
        validRoot.right = new Node(10);
        validRoot.left.left = new Node(3);
        validRoot.left.right = new Node(6);
        validRoot.right.right = new Node(11);
        
        System.out.println("Is the first tree a valid BST? " + isValidBST(validRoot)); // Expected: true

        // Example 2: An invalid BST
        Node invalidRoot = new Node(8);
        invalidRoot.left = new Node(5);
        invalidRoot.right = new Node(10);
        invalidRoot.left.left = new Node(3);
        invalidRoot.left.right = new Node(9); // Invalid: 9 is in the left subtree of 8.
        
        System.out.println("Is the second tree a valid BST? " + isValidBST(invalidRoot)); // Expected: false
    }
}

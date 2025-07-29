import java.util.*;

public class KthAncestor {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * Helper function to find and print the Kth ancestor of a given node 'n'.
     *
     * @param root The current node in the traversal.
     * @param n    The data of the target node whose ancestor we want to find.
     * @param k    The level of the ancestor (1=parent, 2=grandparent, etc.).
     * @return The distance from the current 'root' to the target 'n', or -1 if 'n' is not in this subtree.
     */
    public static int findKthAncestor(Node root, int n, int k) {
        // Base case: Reached a null node, target not found here.
        if (root == null) {
            return -1;
        }

        // Base case: Found the target node 'n'. Return 0 to start the distance count.
        if (root.data == n) {
            return 0;
        }

        // Search in the left and right subtrees (typo corrected here).
        int leftDist = findKthAncestor(root.left, n, k);
        int rightDist = findKthAncestor(root.right, n, k);

        // --- This is the key fix ---
        // If 'n' was not found in either the left or right subtree, it means 'n'
        // is not under the current root. Pass the "not found" signal (-1) up.
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        // Find the distance from the child that is an ancestor of 'n'.
        int dist = Math.max(leftDist, rightDist);

        // Check if the current node is the Kth ancestor.
        // The distance from the current node to 'n' is (dist + 1).
        if (dist + 1 == k) {
            System.out.println("The " + k + "-th ancestor of " + n + " is: " + root.data);
        }

        // Return the distance from the current node up to its parent.
        return dist + 1;
    }


    public static void main(String[] args) {
        /*
         * 1
         * /   \
         * 2     3
         * / \   / \
         * 4   5 6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Find the 2nd ancestor of node 5. Expected output: 1
        findKthAncestor(root, 5, 2);

        // Find the 1st ancestor of node 7. Expected output: 3
        findKthAncestor(root, 7, 1);
    }
}
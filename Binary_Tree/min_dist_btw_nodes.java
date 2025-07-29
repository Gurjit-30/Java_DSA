import java.util.*;

/**
 * This class provides a complete solution for finding the minimum distance 
 * between two nodes in a binary tree.
 */
public class BinaryTreeDistance {

    /**
     * Inner class to represent a node in the binary tree.
     */
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

    /**
     * Finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Tree.
     * The LCA is the deepest node that is an ancestor to both n1 and n2.
     *
     * @param root The root node of the binary tree to search in.
     * @param n1   The data of the first node.
     * @param n2   The data of the second node.
     * @return The Node that is the LCA of n1 and n2, or null if not found.
     */
    public static Node lca(Node root, int n1, int n2) {
        // Base Case: If the current node is null, or if it matches one of the
        // target nodes, return the current node. This is the stopping condition.
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        // Recursively search for the target nodes in the left and right subtrees.
        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        // If the left search returned null, it means both nodes are in the right subtree.
        // So, the result from the right search is the LCA for this level.
        if (leftLca == null) {
            return rightLca;
        }

        // If the right search returned null, it means both nodes are in the left subtree.
        if (rightLca == null) {
            return leftLca;
        }

        // If both leftLca and rightLca are NOT null, it means one target node was
        // found in the left subtree and the other in the right. This makes the
        // current 'root' the Lowest Common Ancestor.
        return root;
    }

    /**
     * Calculates the distance (number of edges) from a given starting node 
     * to a node with data 'n'.
     *
     * @param startNode The node to start the distance calculation from.
     * @param n The data of the target node to find.
     * @return The distance as an integer, or -1 if the node 'n' is not found.
     */
    public static int dist(Node startNode, int n) {
        // If the starting node is null, the target can't be found.
        if (startNode == null) {
            return -1;
        }

        // If the starting node is the target node, the distance is 0.
        if (startNode.data == n) {
            return 0;
        }

        // Recursively search for the target in the left subtree.
        int leftDist = dist(startNode.left, n);
        // Recursively search for the target in the right subtree.
        int rightDist = dist(startNode.right, n);

        // If the node was not found in either subtree, return -1.
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        // If it was found in the right subtree, add 1 for the current edge.
        else if (leftDist == -1) {
            return rightDist + 1;
        }
        // Otherwise, it was found in the left subtree.
        else {
            return leftDist + 1;
        }
    }

    /**
     * Calculates the minimum distance (number of edges) between two nodes in a tree.
     *
     * @param root The root of the entire tree.
     * @param n1   The data of the first node.
     * @param n2   The data of the second node.
     * @return The minimum distance as an integer.
     */
    public static int minDistance(Node root, int n1, int n2) {
        // Step 1: Find the Lowest Common Ancestor of n1 and n2.
        Node lcaNode = lca(root, n1, n2);

        // If LCA is null, one or both nodes are not in the tree.
        if (lcaNode == null) {
            return -1; // Or throw an exception, as distance is undefined.
        }

        // Step 2: Calculate distance from the LCA to n1.
        int dist1 = dist(lcaNode, n1);

        // Step 3: Calculate distance from the LCA to n2.
        int dist2 = dist(lcaNode, n2);

        // Step 4: The total distance is the sum of the two individual distances.
        return dist1 + dist2;
    }

    /**
     * The main method to test the functionality.
     */
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

        int node1 = 4;
        int node2 = 5;
        // Expected: LCA is 2. dist(2,4)=1, dist(2,5)=1. Total = 2.
        System.out.println("Distance between " + node1 + " and " + node2 + " is: " + minDistance(root, node1, node2));

        node1 = 4;
        node2 = 6;
        // Expected: LCA is 1. dist(1,4)=2, dist(1,6)=2. Total = 4.
        System.out.println("Distance between " + node1 + " and " + node2 + " is: " + minDistance(root, node1, node2));
        
        node1 = 2;
        node2 = 4;
        // Special case: one node is the ancestor of the other.
        // Expected: LCA is 2. dist(2,2)=0, dist(2,4)=1. Total = 1.
        System.out.println("Distance between " + node1 + " and " + node2 + " is: " + minDistance(root, node1, node2));

    }
}

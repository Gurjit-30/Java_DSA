import java.util.*;

class MirrorTree {

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
     * Creates a mirror image of a binary tree by swapping the left and
     * right children of all nodes.
     *
     * @param root The root of the binary tree to be mirrored.
     * @return The root of the newly mirrored tree.
     */
    public static Node mirror(Node root) {
        // Base case: If the node is null, there's nothing to do.
        if (root == null) {
            return null;
        }

        // Recursively mirror the left and right subtrees first (post-order traversal).
        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

        // Swap the left and right children of the current node.
        root.left = rightMirror;
        root.right = leftMirror;

        // Return the modified node.
        return root;
    }

    // Helper function to print the tree in-order to verify the result
    public static void inorderPrint(Node root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }


    public static void main(String[] args) {
        /*
         * Original Tree:
         * 8
         * / \
         * 5   10
         * / \   \
         * 3   6   11
         * In-order: 3 5 6 8 10 11
         */
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        System.out.print("Original Tree (In-order): ");
        inorderPrint(root);
        System.out.println();

        // Mirror the tree
        root = mirror(root);

        /*
         * Mirrored Tree:
         * 8
         * / \
         * 10  5
         * /   / \
         * 11  6   3
         * In-order: 11 10 8 6 5 3
         */
        System.out.print("Mirrored Tree (In-order): ");
        inorderPrint(root);
        System.out.println();
    }
}

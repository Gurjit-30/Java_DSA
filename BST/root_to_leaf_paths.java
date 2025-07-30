import java.util.ArrayList;

class RootToLeafPath {

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
     * Finds and prints all root-to-leaf paths in a binary tree.
     *
     * @param root The current node in the traversal.
     * @param path An ArrayList to store the current path from the root.
     */
    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
        // Base case: If the node is null, we've gone past a leaf, so stop.
        if (root == null) {
            return;
        }

        // --- Backtracking Step 1: Add the current node to the path ---
        path.add(root.data); // FIX 1: Add the node's data, not the node object.

        // If the current node is a leaf, print the path.
        if (root.left == null && root.right == null) {
            System.out.println(path);
            // FIX 2: Do NOT return here. We still need to backtrack below.
        } else {
            // Otherwise, continue traversing down the tree.
            printRootToLeaf(root.left, path);
            printRootToLeaf(root.right, path);
        }

        // --- Backtracking Step 2: Remove the current node from the path ---
        // This is crucial. It's done after visiting all children of the current node,
        // so that when we "return" to its parent, it's no longer in the path.
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        /*
         * 8
         * / \
         * 5   10
         * / \   \
         * 3   6   11
         */
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        System.out.println("All root-to-leaf paths:");
        // Initial call with an empty ArrayList
        printRootToLeaf(root, new ArrayList<>());
        
        // Expected Output:
        // [8, 5, 3]
        // [8, 5, 6]
        // [8, 10, 11]
    }
}

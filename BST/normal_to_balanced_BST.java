import java.util.ArrayList;

// Assuming a Node class exists
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    /**
     * 1. Performs an in-order traversal to flatten the BST into a sorted list.
     */
    public static void inorderTraversal(Node root, ArrayList<Integer> inorderList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, inorderList);
        inorderList.add(root.data);
        inorderTraversal(root.right, inorderList);
    }

    /**
     * 2. Builds a new, height-balanced BST from a sorted list of nodes.
     */
    public static Node createBalancedBST(ArrayList<Integer> inorderList, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        // CORRECTION 1: Use .get() for ArrayList
        Node node = new Node(inorderList.get(mid));

        node.left = createBalancedBST(inorderList, start, mid - 1);
        node.right = createBalancedBST(inorderList, mid + 1, end);
        return node;
    }

    /**
     * 3. Main function to balance a given BST.
     */
    public static Node balanceBST(Node root) {
        // Step 1: Get the sorted in-order traversal
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        // Step 2: Build and return the new balanced tree from the sorted list
        // CORRECTION 2: Use a different variable name for the new root
        Node newRoot = createBalancedBST(inorderList, 0, inorderList.size() - 1);

        return newRoot;
    }
}
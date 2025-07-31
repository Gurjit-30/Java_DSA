// Assume a Node class like this exists:
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
     * Recursively creates a height-balanced Binary Search Tree from a sorted array.
     *
     * @param arr The sorted input array of integers.
     * @param st  The starting index of the subarray.
     * @param ed  The ending index of the subarray.
     * @return The root node of the constructed BST.
     */
    public static Node createBST(int[] arr, int st, int ed) {
        // Correct Base Case: If the start index crosses the end index,
        // it means this subarray is empty, so we return null.
        if (st > ed) {
            return null;
        }

        // Calculate the middle index safely
        int mid = st + (ed - st) / 2;

        // The middle element becomes the root of this subtree
        Node root = new Node(arr[mid]);

        // Recursively build the left subtree from the left half of the array
        root.left = createBST(arr, st, mid - 1);

        // Recursively build the right subtree from the right half of the array
        root.right = createBST(arr, mid + 1, ed);

        // Return the newly created root node
        return root;
    }
}
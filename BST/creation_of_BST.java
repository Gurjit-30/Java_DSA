class Solution {

    // Node class that defines the structure of each node in the tree
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    // Your build method - the logic here is correct
    public static Node build(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = build(root.left, val);
        } else {
            root.right = build(root.right, val);
        }
        return root;
    }

    // Inorder traversal to print the BST in sorted order
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] values = {1, 2, 34, 5, 6};
        
        // You must initialize the root to null before starting
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = build(root, values[i]);
        }

        // Verify the result by printing the sorted tree
        System.out.println("Inorder traversal of the built BST:");
        inorder(root); // Expected output: 1 2 5 6 34 
    }
}
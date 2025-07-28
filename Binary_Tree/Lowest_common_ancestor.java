class Solution {

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
     * Finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Tree.
     * This approach assumes both n1 and n2 are present in the tree.
     *
     * @param root The root node of the binary tree to search in.
     * @param n1   The data of the first node.
     * @param n2   The data of the second node.
     * @return The Node that is the LCA of n1 and n2, or null if not found.
     */
    public static Node lca(Node root, int n1, int n2) {
        // Base Case: If the current node is null, we've reached the end of a branch.
        // Also, if the current node's data matches n1 or n2, we've found one of
        // the target nodes. In this case, this node itself could be the LCA.
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        // Recursively search for the target nodes in the left and right subtrees.
        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        // --- Analyze the results from the recursive calls ---

        // If the right subtree search returned null, it means both nodes must be
        // in the left subtree. The result from the left search (leftLca) is the answer.
        if (rightLca == null) {
            return leftLca;
        }

        // If the left subtree search returned null, it means both nodes must be
        // in the right subtree. The result from the right search (rightLca) is the answer.
        if (leftLca == null) {
            return rightLca;
        }

        // If both leftLca and rightLca are NOT null, it means we found one target
        // node in the left subtree and the other in the right subtree. This makes the
        // current 'root' the point where they diverge, i.e., the Lowest Common Ancestor.
        return root;
    }
    
    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2   3
         * / \ / \
         * 4  5 6  7
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
        Node ancestor = lca(root, node1, node2);
        if (ancestor != null) {
            // Expected Output: LCA of 4 and 5 is: 2
            System.out.println("LCA of " + node1 + " and " + node2 + " is: " + ancestor.data);
        }

        node1 = 4;
        node2 = 6;
        ancestor = lca(root, node1, node2);
        if (ancestor != null) {
            // Expected Output: LCA of 4 and 6 is: 1
            System.out.println("LCA of " + node1 + " and " + node2 + " is: " + ancestor.data);
        }
    }
}
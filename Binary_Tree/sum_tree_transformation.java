class Solution {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    /**
     * Transforms a binary tree to a "Sum Tree".
     * Each node's new value is the sum of its original left and right subtrees.
     *
     * @param root The root of the tree to transform.
     * @return The sum of all nodes in the original subtree rooted at 'root'.
     */
    public static int toSumTree(Node root) {
        // Base Case: If the node is null, the sum is 0.
        if (root == null) {
            return 0;
        }

        // Store the original value of the current node before it's changed.
        int old_data = root.data;

        // Recursively call for the left and right subtrees.
        // This will transform the children first and return the sum of their original values.
        int leftSum = toSumTree(root.left);
        int rightSum = toSumTree(root.right);

        // Update the current node's data to be the sum of its left and right subtrees.
        // This is the core transformation step.
        root.data = leftSum + rightSum;

        // Return the sum of the original subtree rooted at this node.
        // (i.e., its original value + the sum of its original children).
        return root.data + old_data;
    }

    // Helper function to print the tree levels
    public static void printTree(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        /*
              Original Tree
                    10
                   /  \
                 -2    6
                 / \  / \
                8  -4 7   5
        */
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        System.out.println("Original Tree:");
        printTree(root); // Output: 10 -2 6 8 -4 7 5

        toSumTree(root);

        /*
              Transformed (Sum) Tree
                    20
                   /  \
                  4    12
                 / \  / \
                0   0 0   0
        */
        System.out.println("\nTransformed Sum Tree:");
        printTree(root); // Output: 20 4 12 0 0 0 0
    }
}
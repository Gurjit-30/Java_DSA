// Helper class to store information about each subtree
static class Info {
    boolean isBST;
    int size;
    int min;
    int max;

    public Info(boolean isBST, int size, int min, int max) {
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}

// Global variable to track the maximum size found so far
static int maxBSTSize = 0;

public static Info findLargestBST(Node root) {
    // Base Case: An empty tree is a valid BST of size 0.
    // The min/max values are set to extremes to work correctly with parent nodes.
    if (root == null) {
        return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    // Recursively get info from left and right subtrees (Post-order traversal)
    Info leftInfo = findLargestBST(root.left);
    Info rightInfo = findLargestBST(root.right);

    // Calculate the info for the current node's subtree
    int size = leftInfo.size + rightInfo.size + 1;
    int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
    // CORRECTION 1: Corrected the typo in Math.max
    int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

    // Check the BST property for the current node
    if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
        // This node violates the BST rule, so it cannot be the root of a valid BST.
        return new Info(false, size, min, max);
    }

    // Check if both children are valid BSTs
    if (leftInfo.isBST && rightInfo.isBST) {
        // If we reach here, the current node is the root of a valid BST.
        // CORRECTION 2: Corrected the typo from 'ms' to 'max'
        maxBSTSize = Math.max(maxBSTSize, size);
        return new Info(true, size, min, max);
    }

    // CORRECTION 3: Add the final return statement.
    // This handles the case where the node's value is okay, but one of its children is not a BST.
    return new Info(false, size, min, max);
}
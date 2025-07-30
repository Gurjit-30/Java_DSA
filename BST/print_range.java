/**
 * Prints all nodes in a Binary Search Tree (BST) that fall within the range [n1, n2].
 *
 * @param root The root of the BST.
 * @param n1   The lower bound of the range (inclusive).
 * @param n2   The upper bound of the range (inclusive).
 */
public static void printInRange(Node root, int n1, int n2) {
    // Base case: If the node is null, stop.
    if (root == null) {
        return;
    }

    // Case 1: The current node is within the range.
    if (root.data >= n1 && root.data <= n2) {
        // Since it's in range, there could be valid nodes in both subtrees.
        // Explore left, print current, then explore right (in-order).
        printInRange(root.left, n1, n2);
        System.out.print(root.data + " "); // Corrected print statement
        printInRange(root.right, n1, n2);
    }
    // Case 2: The current node's value is too small.
    // Any value in the left subtree will also be too small, so only check the right.
    else if (root.data < n1) {
        printInRange(root.right, n1, n2); // Corrected recursive call
    }
    // Case 3: The current node's value is too large.
    // Any value in the right subtree will also be too large, so only check the left.
    else { // root.data > n2
        printInRange(root.left, n1, n2); // Corrected recursive call
    }
}
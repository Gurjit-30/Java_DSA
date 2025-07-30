/**
 * Searches for a key in a Binary Search Tree (BST).
 *
 * @param root The root node of the BST.
 * @param key  The value to search for.
 * @return true if the key is found, otherwise false.
 */
public static boolean search(Node root, int key) {
    // Base case: If we reach a null node, the key isn't in the tree.
    if (root == null) {
        return false;
    }

    // If the key matches the current node's data, we've found it.
    if (root.data == key) {
        return true;
    }

    // --- Corrected Logic ---
    // If the key is greater than the root's data, search in the RIGHT subtree.
    if (root.data < key) {
        return search(root.right, key); // Corrected this line
    }
    // If the key is less than the root's data, search in the LEFT subtree.
    else { // root.data > key
        return search(root.left, key); // Corrected this line
    }
}
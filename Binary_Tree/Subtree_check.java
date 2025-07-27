import java.util.*;

class Solution {

    // 1. Define the Node class for the binary tree
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Checks if two trees are structurally and numerically identical.
     * @param root1 The root of the first tree.
     * @param root2 The root of the second tree.
     * @return true if the trees are identical, false otherwise.
     */
    public static boolean isIdentical(Node root1, Node root2) {
        // If both nodes are null, they are identical
        if (root1 == null && root2 == null) {
            return true;
        }

        // If one node is null or their data doesn't match, they are not identical
        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }

        // Recursively check if both left and right subtrees are identical
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    /**
     * Checks if a tree (S) is a subtree of another tree (T).
     * @param T The root of the main tree.
     * @param S The root of the potential subtree.
     * @return true if S is a subtree of T, false otherwise.
     */
    public static boolean isSubtree(Node T, Node S) {
        // Base Case 1: A null subtree is always found in any tree.
        if (S == null) {
            return true;
        }

        // Base Case 2: A non-null subtree cannot be found in a null tree.
        if (T == null) {
            return false;
        }

        // Check if the tree starting at the current node 'T' is identical to 'S'.
        if (isIdentical(T, S)) {
            return true;
        }

        // If not, recursively check in the left OR right subtrees of T.
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }


    // 3. Main method to build trees and test the functions
    public static void main(String[] args) {
        /* Construct the main tree T:
               26
              /  \
             10   3
            / \    \
           4   6    3
            \
             30
        */
        Node T = new Node(26);
        T.right = new Node(3);
        T.right.right = new Node(3);
        T.left = new Node(10);
        T.left.left = new Node(4);
        T.left.left.right = new Node(30);
        T.left.right = new Node(6);

        /* Construct the subtree S to be found:
             10
            / \
           4   6
            \
             30
        */
        Node S = new Node(10);
        S.right = new Node(6);
        S.left = new Node(4);
        S.left.right = new Node(30);

        // --- Test Case 1: S is a subtree of T ---
        if (isSubtree(T, S)) {
            System.out.println("✅ Tree S is a subtree of Tree T.");
        } else {
            System.out.println("❌ Tree S is not a subtree of Tree T.");
        }

        /* Construct another tree S2 which is not a subtree:
             10
            / \
           4   6
            \
             99  <-- Different value
        */
        Node S2 = new Node(10);
        S2.right = new Node(6);
        S2.left = new Node(4);
        S2.left.right = new Node(99);

        // --- Test Case 2: S2 is NOT a subtree of T ---
         if (isSubtree(T, S2)) {
            System.out.println("✅ Tree S2 is a subtree of Tree T.");
        } else {
            System.out.println("❌ Tree S2 is not a subtree of Tree T.");
        }
    }
}
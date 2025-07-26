import java.util.*;
import java.lang.*;
import java.io.*;

class BinaryTreeProgram {

    // Node class for the tree structure
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

    // Class to contain the tree-building logic
    static class TreeBuilder {
        static int idx = -1;

        public static Node build(int arr[]) {
            idx++;
            if (arr[idx] == -1) {
                return null;
            }
            Node newNode = new Node(arr[idx]);
            newNode.left = build(arr);
            newNode.right = build(arr);
            return newNode;
        }
    }

   
public static int sum(Node root){
    if(root==null){
        return 0;
    }
    int ls=sum(root.left);
    int rs=sum(root.right);
    return ls+rs+root.data;
}

    public static void main(String[] args) throws java.lang.Exception {
        // Input array representing the tree in pre-order
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        // Build the tree
        Node root = TreeBuilder.build(nodes);

        System.out.println("Level Order Traversal:");
        // Call your method to print the result
        level(root);
    }
}
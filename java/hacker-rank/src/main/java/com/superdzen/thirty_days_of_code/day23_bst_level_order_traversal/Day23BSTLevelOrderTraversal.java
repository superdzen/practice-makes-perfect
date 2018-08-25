package com.superdzen.thirty_days_of_code.day23_bst_level_order_traversal;

import java.util.*;

/**
 * Created by superdzen@gmail.com on 13.07.2017.
 * https://www.hackerrank.com/challenges/30-binary-trees
 * We need to realize leverOrder function
 * A level-order traversal of tree  is a recursive algorithm that processes the root,
 * followed by the children of the root (from left to right),
 * followed by the grandchildren of the root (from left to right), etc.
 */
public class Day23BSTLevelOrderTraversal {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }

    static void levelOrder(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
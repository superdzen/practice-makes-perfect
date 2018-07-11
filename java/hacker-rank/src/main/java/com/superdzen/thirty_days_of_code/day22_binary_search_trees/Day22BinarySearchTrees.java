package com.superdzen.thirty_days_of_code.day22_binary_search_trees;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 12.07.2017.
 * https://www.hackerrank.com/challenges/30-binary-search-trees/
 * The height of a binary search tree is the number of edges between the tree's root and its furthest leaf.
 * You are given a pointer, root, pointing to the root of a binary search tree.
 * Complete the getHeight function provided in your editor so that it returns the height of the binary search tree.
 */
public class Day22BinarySearchTrees {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }

    public static int getHeight(Node root) {
        if (root == null) {
            return -1;
        }

        int getLeftHeight = getHeight(root.left);
        int getRightHeight = getHeight(root.right);
        int height = Math.max(getLeftHeight, getRightHeight) + 1;
        return height;

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
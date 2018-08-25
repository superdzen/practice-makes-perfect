package com.superdzen.thirty_days_of_code.day15_linkedlist;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 04.07.2017.
 *
 */
public class Day15LinkedList {
    public static Node insert(Node head, int data) {
        if (head == null) {                     //if it is first element
            head = new Node(data);
        } else {
            Node tempNode = head;               //if not, then search last element
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = new Node(data);     //add new Node to the tail of the list
        }
        return head;                            //return head of the list
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        sc.close();
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

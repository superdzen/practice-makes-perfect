package com.superdzen.thirty_days_of_code.day24_more_linkedlists;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 13.07.2017.
 * https://www.hackerrank.com/challenges/30-linked-list-deletion
 * Complete removeDuplicates so that it deletes any duplicate nodes from the list and returns the head of the updated list.
 * The data elements of the linked list argument will always be in non-decreasing order.
 */
public class Day24MoreLinkedLists {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static Node removeDuplicates(Node head) {
        Node headTemp = head;
        if (headTemp != null) {
            while (headTemp.next != null) {
                if (headTemp.data == headTemp.next.data) {
                    headTemp.next = headTemp.next.next;
                } else {
                    headTemp = headTemp.next;
                }
            }
        }
        return head;

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
package com.superdzen.ctci_linked_list_cycle;

/**
 * Created by superdzen@gmail.com on 04.12.2017.
 * Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
 */

public class CtciLinkedListCycle {

    boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node elem1 = head;
        Node elem2 = head;
        while (elem1 != null && elem2 != null) {
            elem1 = elem1.next;
            elem2 = elem2.next.next;
            if (elem1 == elem2) {
                return true;
            }
        }
        return false;
    }
}

class Node {
    int data;
    Node next;
}


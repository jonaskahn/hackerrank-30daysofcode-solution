package com.tuyendev;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

}

class Solution {
    public static Node removeDuplicates(Node head) {
        Node temp = head;
        while (head != null) {
            int data = head.data;
            int pos = findPositionDuplicate(temp, data);
            if (pos != 0) {
                temp = removePosition(temp, pos);
                head = temp;
            }
            head = head.next;
        }
        return temp;
    }


    public static int findPositionDuplicate(Node node, int data) {
        int position = 0;
        int check = 0;
        while (node != null) {
            position++;
            if (data == node.data) {
                check++;
            }
            if (check == 2) {
                return position;
            }
            node = node.next;
        }
        return 0;
    }

    public static Node removePosition(Node root, int position) {
        Node temp = null;
        int isPos = 0;
        while (root != null) {
            isPos++;
            if (isPos != position) {
                temp = insert(temp, root.data);
            }
            root = root.next;
        }
        return temp;
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
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);

    }
}

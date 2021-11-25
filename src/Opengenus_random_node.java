import java.util.*;
// Let's define the class for the linked list


class Opengenus_random_node {
    private static Random generator = new Random();
    static Node head;

    // Method to generate the random number
    static double randomGenerator() {
        return generator.nextInt()*0.5;
    }

    /* Node class */
    static class Node {

        int value;  // stores the integer type data of each node
        Node next;  // stores address of each node

        // Constructor for creating a new node in the linked list
        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    // function to print the random node from the linked list
    void random_node(Node node) {

        // Check if the list is empty
        if (node == null) {
            return;
        }


       randomGenerator();

        // Initialize result as first node
        int res = node.value;  // for storing our required result
        Node current_node = node;
        int n;
        for (n = 2; current_node != null; n++) {

            if (Math.random() % n == 0) {
                res = current_node.value;
            }

            // moving on to the next node
            current_node  = current_node.next;
        }

        System.out.println("Random node " + res);
    }


    public static void main(String[] abc) {

        Opengenus_random_node list = new Opengenus_random_node();
        head = new Node(15);
        head.next = new Node(0);
        head.next.next = new Node(64);
        head.next.next.next = new Node(13);
        head.next.next.next.next = new Node(99);

        list.random_node(head);

    }
}


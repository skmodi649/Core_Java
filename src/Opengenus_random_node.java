/** Author : Suraj Kumar
 * Github : https://github.com/skmodi649
 */

/** PROBLEM DESCRIPTION :
 * There is a Binary Search Tree given and we are supposed to find a random node in the given binary tree.
 */

/** ALGORITHM :
 * Step 1: START
 * Step 2: First create a binary tree using the steps mentioned in the first approach
 * Step 3: Now use a method *inOrder()* that takes a node as input parameter to traverse through the
 *         binary tree in inorder fashion as also store the values in a ArrayList simultaneously.
 * Step 4: Now define a method *getrandom()* that takes a node as input parameter, in this first call
 *         the inOrder() method to store the values in the arraylist, then find the size of the binary tree and now just generate a random number between 0 to n-1.
 * Step 5: After generating the number display the value of the ArrayList at the generated index
 * Step 6: STOP
 */



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

/** Explanation of the Approach :
 * (a) Form the required binary tree
 * (b) Now use the *inOrder()* method to get the nodes in inOrder fashion and also store them in the given arraylist 'list'
 * (c) Using the *getRandom()* method generate a random number between 0 to n-1, then get the value at the generated random number
 *     from the arraylist using get() method and finally display the result.
 */


/** OUTPUT :
 * First output :
 * Random Node : 15
 * Second output :
 * Random Node : 99
 */

/** Time Complexity : O(n)
 * Auxiliary Space Complexity : O(1)
 */

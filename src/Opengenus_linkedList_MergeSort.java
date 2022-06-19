// Java program for the implement merge sort on Linked List
import java.lang.*;

// Class for nodes of the linked list
class LinkedNode {
    int val;
    LinkedNode next;
    LinkedNode(int key)
    {
        this.val = key;
        next = null;
    }
}

public class Opengenus_linkedList_MergeSort {

    // Function to implement the merge sort algorithm
    public static LinkedNode mergeSort(LinkedNode head)
    {
        if (head.next == null)
            return head;

        LinkedNode mid = findMid(head);
        LinkedNode head2 = mid.next;
        mid.next = null;
        LinkedNode newHead1 = mergeSort(head);
        LinkedNode newHead2 = mergeSort(head2);
        LinkedNode finalHead = merge(newHead1, newHead2);

        return finalHead;
    }


    public static LinkedNode merge(LinkedNode head1, LinkedNode head2)
    {
        LinkedNode merged = new LinkedNode(-1);
        LinkedNode temp = merged;

        // While head1 is not null and head2
        // is not null
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // While head1 is not null
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        // While head2 is not null
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }

    // Finding the middle node using the slow pointer approach
    public static LinkedNode findMid(LinkedNode head)
    {
        LinkedNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to print list
    static void printList(LinkedNode head)
    {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        LinkedNode head = new LinkedNode(7);
        LinkedNode temp = head;
        temp.next = new LinkedNode(10);
        temp = temp.next;
        temp.next = new LinkedNode(20);
        temp = temp.next;
        temp.next = new LinkedNode(05);
        temp = temp.next;
        temp.next = new LinkedNode(100);
        temp = temp.next;
        temp.next = new LinkedNode(90);
        temp = temp.next;

        head = mergeSort(head);
        System.out.print("Sorted Linked List : ");
        printList(head);
    }
}

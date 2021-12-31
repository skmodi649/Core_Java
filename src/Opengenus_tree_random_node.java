import java.util.ArrayList;

// Using auxillary array to find the random node in a given binary tree
class Node {
    int item;
    Node left, right;

    public Node(int key) {
        item = key;
        left = right = null;
    }
}

class Tree {

    // Using a arraylist to store the inorder traversal of the gieven binary tree
    static ArrayList<Integer> list = new ArrayList<Integer>();
    // root of Tree
    Node root;

    Tree() {
        root = null;
    }

    // Now lets find the inorder traversal of the given binary tree
    static void inOrder(Node node) {
        if (node == null)
            return;

        // traverse the left child
        inOrder(node.left);

        list.add(node.item);
        // traverse the right child
        inOrder(node.right);
    }

    public void getrandom()
    {

    }


    public static void main(String[] args) {
        Tree tree = new Tree();


        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);

        tree.getrandom();


    }
}

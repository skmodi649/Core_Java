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

    // Using a arraylist to store the inorder traversal of the given binary tree
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

    public void getrandom(Node val)
    {
        inOrder(val);
        // getting the count of node of the binary tree
        int n = list.size();
        int min = 0;
        int max = n - 1;
        //Generate random int value from 0 to n-1
        int b = (int)(Math.random()*(max-min+1)+min);
        // displaying the value at the generated index
        int random = list.get(b);
        System.out.println("Random Node : " + random);

    }


    public static void main(String[] args) {
        Tree tree = new Tree();


        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);

        tree.getrandom(tree.root);


    }
}

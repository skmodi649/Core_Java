// Using auxillary array to find the random node in a given binary tree
public class Opengenus_tree_random_node {
    static class TreeNode
    {
        int val;
        int child;
        TreeNode left, right;
    }

    static TreeNode Node(int data)
    {
        TreeNode temp = new TreeNode();
        temp.val = data;
        temp.left = temp.right = null;   //No child initially for the Binary tree
        temp.child = 0;
        return temp;
    }

    static int getChild(TreeNode root)
    {
        if (root == null)
            return 0;
        return getChild(root.left) +
                getChild(root.right) + 1;
    }

}

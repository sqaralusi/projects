import java.util.Collection;
import javax.swing.tree.TreeNode;
import org.w3c.dom.Node;

public class BSTComplete<T extends Comparable<T>> {
    // Instance Variable
    private Node root;

    // Node Class
    private class Node {
        T value;
        Node left;
        Node right;

        public Node(T value, Node left, Node right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // Constructors
    public BSTComplete()
    {
        this.root = null;
    }

    public BSTComplete(Collection<T> values)
    {
        for (T value : values)
        {
            add(value);
        }
    }

    @SafeVarargs public BSTComplete(T... values)
    {
        for (T value : values)
        {
            add(value);
        }
    }

    // Adding
    public void add(T value)
    {
        root = add(root, value);
    }
    private Node add(Node node, T value)
    {
        if (node == null)
        {
            return new Node(value, null, null);
        }
        if (value.compareTo(node.value) < 0)
        {
            node.left = add(node.left, value);
        }
        else if (value.compareTo(node.value) > 0)
        {
            node.right = add(node.right, value);
        }
        return node;
    }

    // Searching
    public boolean contains(T item)
    {
        // TODO
        return contains(root, item);
    }
    private boolean contains(Node node, T item)
    {
        if (node == null)
        {
            return false;
        }

        if (item.compareTo(node.value) == 0)
        {
            return true;
        }
        else if (item.compareTo(node.value) < 0)
        {
            return contains(node.left, item);
        }
        else
        {
            return contains(node.right, item);
        }
    }

    // Return the root value
    public T getRoot()
    {
        if (root != null)
        {
            return root.value;
        }
        else
        {
            return null;
        }
    }

    // Traversal Methods
    public void inOrder()
    {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node current)
    {
        if (current != null)
        {
            inOrder(current.left);
            System.out.print(current.value + " ");
            inOrder(current.right);
        }
    }

    public void preOrder()
    {
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node current)
    {
        if (current != null)
        {
            System.out.print(current.value + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    public void postOrder()
    {
        postOrder(root);
        System.out.println();
    }
    private void postOrder(Node current)
    {
        if (current != null)
        {
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.value + " ");
        }
    }

    public void reverseOrder()
    {
        reverseOrder(root);
        System.out.println();
    }
    private void reverseOrder(Node current)
    {
        if (current != null)
        {
            reverseOrder(current.right);
            System.out.print(current.value + " ");
            reverseOrder(current.left);
        }
    }

    @Override public String toString()
    {
        return toString(root);
    }

    private String toString(Node tree)
    {
        if (tree == null)
        {
            return "";
        }
        return toString(tree.left) + " " + tree.value + " " + toString(tree.right);
    }
    public int getNumNodes()
    {
        return getNumNodes(root);
    }

    private int getNumNodes(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        return 1 + getNumNodes(node.left) + getNumNodes(node.right);
    }

    public int getNumLeaves()
    {
        return getNumLeaves(root);
    }

    private int getNumLeaves(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        if (node.left == null && node.right == null)
        {
            return 1;
        }
        return getNumLeaves(node.left) + getNumLeaves(node.right);
    }

    public int getNumLevels()
    {
        return getNumLevels(root);
    }

    private int getNumLevels(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        return 1 + Math.max(getNumLevels(node.left), getNumLevels(node.right));
    }

    public int getWidth()
    {
        int height = getNumLevels(root);
        int[] levelWidths = new int[height + 1];
        getWidth(root, 0, levelWidths);

        int maxWidth = 0;
        for (int width : levelWidths)
        {
            if (width > maxWidth)
            {
                maxWidth = width;
            }
        }
        return maxWidth;
    }
    private void getWidth(Node node, int level, int[] levelWidths)
    {
        if (node != null)
        {
            levelWidths[level]++;
            getWidth(node.left, level + 1, levelWidths);
            getWidth(node.right, level + 1, levelWidths);
        }
    }

    public int getHeight()
    {
        return getHeight(root);
    }

    private int getHeight(Node node)
    {
        if (node == null)
        {
            return -1;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isFull()
    {
        int height = getNumLevels(root);
        return isFull(root, height, 0);
    }

    private boolean isFull(Node node, int height, int level)
    {
        if (node == null)
        {
            return true;
        }
        if ((node.left == null & node.right != null) || (node.left != null && node.right == null))
        {
            return false;
        }
        return isFull(node.left, height, level + 1) && isFull(node.right, height, level + 1);
    }
    public void delete(T value)
    {
        root = delete(root, value);
    }

    private Node delete(Node node, T value)
    {
        if (node == null)
        {
            return null;
        }

        // search for node to delete
        if (value.compareTo(node.value) < 0)
        {
            node.left = delete(node.left, value);
        }
        else if (value.compareTo(node.value) > 0)
        {
            node.right = delete(node.right, value);
        }
        else
        {
            // node found, handle deletion cases
            if (node.left == null)
            {
                return node.right;
            }
            else if (node.right == null)
            {
                return node.left;
            }
            else
            {
                // node has two children, find in-order successor
                node.value = findMin(node.right);
                // delete in-order successor from right subtree
                node.right = delete(node.right, node.value);
            }
        }
        return node;
    }
    private T findMin(Node node)
    {
        while (node.left != null)
        {
            node = node.left;
        }
        return node.value;
    }
    /*
     * main
     */
    public static void main(String[] args)
    {
        BSTComplete<Integer> test = new BSTComplete<>(10, 6, 14, 3, 8, 12, 16);
        if (args.length == 0)
        {
            System.out.println("No command line argument given.");
        }
        else if (args[0].equals("0"))
        {
            test.delete(12);
        }
        else if (args[0].equals("1"))
        {
            test.delete(12);
            test.delete(14);
        }
        else if (args[0].equals("2"))
        {
            test.delete(10);
        }
        System.out.println(test);
    }
}
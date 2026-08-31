import java.util.Collection;
import javax.swing.tree.TreeNode;
import org.w3c.dom.Node;

public class BST<T extends Comparable<T>> {
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
    public BST()
    {
        this.root = null;
    }

    public BST(Collection<T> values)
    {
        for (T value : values)
        {
            add(value);
        }
    }

    @SafeVarargs public BST(T... values)
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

    /*
     * main
     */
    public static void main(String[] args)
    {
        BST<Integer> test = null;
        if (args.length == 0)
        {
            System.out.println("No command line arguments given");
        }
        else if (args[0].equals("0"))
        {
            test = new BST<>();
            System.out.println(test); // ""
        }
        else if (args[0].equals("1"))
        {
            Integer[] numbers = {1, 2, 3, 4};
            test = new BST<>(numbers);
            System.out.println(test); // " 1  2  3  4 "
        }
        else if (args[0].equals("2"))
        {
            test = new BST<>(1, 2, 3, 4);
            System.out.println(test); // " 1  2  3  4 "
        }
        else if (args[0].equals("3"))
        {
            test = new BST<>();
            test.add(10);
            test.add(6);
            test.add(14);
            test.add(3);
            test.add(8);
            test.add(12);
            test.add(16);
            System.out.println(test); // " 3  6  8  10  12  14  16 "
        }
        else if (args[0].equals("4"))
        {
            test = new BST<>(10, 6, 14, 3, 8, 12, 16);
            System.out.println(test.contains(3) + " " + test.contains(18)); // "true false"
        }
        else if (args[0].equals("5"))
        {
            test = new BST<>(10, 6, 14, 3, 8, 12, 16);
            System.out.print(test.getNumNodes() + " ");
            test.add(1);
            System.out.println(test.getNumNodes()); // "7 8"
        }
        else if (args[0].equals("6"))
        {
            test = new BST<>(10, 6, 14, 3, 8, 12, 16);
            System.out.print(test.getNumLeaves() + " ");
            test.add(1);
            System.out.println(test.getNumLeaves()); // "4 4"
        }
        else if (args[0].equals("7"))
        {
            test = new BST<>(10, 6, 14, 3, 8, 12, 16);
            System.out.print(test.getNumLevels() + " ");
            test.add(1);
            System.out.println(test.getNumLevels()); // "3 4"
        }
        else if (args[0].equals("8"))
        {
            test = new BST<>(10, 6, 14, 3, 8, 12, 16);
            System.out.print(test.getHeight() + " ");
            test.add(1);
            System.out.println(test.getHeight()); // "2 3"
        }
        else if (args[0].equals("9"))
        {
            test = new BST<>(10, 6, 14, 3, 8, 12, 16);
            System.out.print(test.isFull() + " ");
            test.add(1);
            System.out.println(test.isFull()); // "true false"
        }
    }
}
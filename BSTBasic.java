import java.util.Collection;
import javax.swing.tree.TreeNode;
import org.w3c.dom.Node;

public class BSTBasic<T extends Comparable<T>> {
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
    public BSTBasic()
    {
        this.root = null;
    }

    public BSTBasic(Collection<T> values)
    {
        for (T value : values)
        {
            add(value);
        }
    }

    @SafeVarargs public BSTBasic(T... values)
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

    /*
     * main
     */
    public static void main(String[] args)
    {
        BSTBasic<Integer> test = new BSTBasic<>(10, 6, 14, 3, 8, 12, 16);
        System.out.println(test.contains(3));
        System.out.println(test.contains(4));
        System.out.println("Root -> " + test.getRoot());
        System.out.print("In Order -> ");
        test.inOrder();
        System.out.print("Pre Order -> ");
        test.preOrder();
        System.out.print("Post Order -> ");
        test.postOrder();
        System.out.print("Reverse Order -> ");
        test.reverseOrder();
        System.out.println("As a string -> " + test);
    }
}
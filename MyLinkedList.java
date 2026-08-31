import java.util.Arrays;

public class MyLinkedList<T> {

    private ListNode head;
    private int size;

    private class ListNode {
        T value;
        ListNode next;

        public ListNode(T value, ListNode next)
        {
            this.value = value;
            this.next = next;
        }
    }

    public MyLinkedList()
    {
        head = null;
        size = 0;
    }

    @SafeVarargs public MyLinkedList(T... items)
    {
        for (T item : items)
        {
            add(size, item);
        }
    }

    public void add(int index, T value)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0)
        {
            head = new ListNode(value, head);
        }
        else
        {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++)
            {
                current = current.next;
            }
            current.next = new ListNode(value, current.next);
        }
        size++;
    }

    public int size()
    {
        return size;
    }

    @Override public String toString()
    {
        if (head == null)
        {
            return "[]";
        }

        String result = "[";
        ListNode current = head;
        while (current.next != null)
        {
            result += current.value + ", ";
            current = current.next;
        }
        result += current.value + "]";
        return result;
    }

    public static void main(String[] args)
    {
        MyLinkedList<String> test1 = new MyLinkedList<>();
        for (int i = 0; i < 3; i++)
        {
            test1.add(i, "hello" + (i + 1));
        }

        MyLinkedList<Double> test2 = new MyLinkedList<>(3.14, 1.41, 1.61, 0.5);

        if (args.length == 0 || args[0].equals("String"))
        {
            System.out.println(test1);
        }
        if (args.length == 0 || args[0].equals("Double"))
        {
            System.out.println(test2);
        }
        if (args.length == 0 || args[0].equals("AddToFront"))
        {
            test2.add(0, 9.12);
            System.out.println(test2);
        }
        if (args.length == 0 || args[0].equals("Size"))
        {
            System.out.println("Test1 size: " + test1.size());
            System.out.println("Test2 size: " + test2.size());
        }
    }
}
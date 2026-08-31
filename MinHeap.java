import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
    private List<T> heap;

    public MinHeap()
    {
        heap = new ArrayList<>();
    }

    @SafeVarargs public MinHeap(T... values)
    {
        heap = new ArrayList<>(Arrays.asList(values));
        for (int i = (heap.size() / 2) - 1; i >= 0; i--)
        {
            swapDown(i);
        }
    }

    public T getMin()
    {
        if (heap.isEmpty())
        {
            return null;
        }
        return heap.get(0);
    }

    public void add(T value)
    {
        heap.add(value);
        swapUp(heap.size() - 1);
    }

    private void swapDown(int index)
    {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0)
        {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0)
        {
            smallest = rightChild;
        }

        if (smallest != index)
        {
            swap(index, smallest);
            swapDown(smallest);
        }
    }

    public void remove()
    {
        if (heap.isEmpty())
        {
            return;
        }

        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        swapDown(0);
    }

    private void swapUp(int index)
    {
        while (index > 0)
        {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0)
            {
                swap(index, parent);
                index = parent;
            }
            else
            {
                break;
            }
        }
    }

    private void swap(int i, int j)
    {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override public String toString()
    {
        return heap.toString();
    }

    public void prettyPrint()
    {
        System.out.println("\n\nPRINTING THE HEAP!\n\n");
        int x = 0;
        for (int i = 1; i < heap.size(); i *= 2)
        {
            for (int s = 1; s < heap.size() - i; s++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j <= i - 1 && x < heap.size(); j++)
            {
                System.out.print(heap.get(x++) + "  ");
            }
            System.out.println();
            if (x == heap.size() - 1)
            {
                System.out.print(heap.get(x++) + "  ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        MinHeap<Integer> test = null;
        if (args.length == 0)
        {
            System.out.println("No command line arguments given.");
            test = new MinHeap<>(1, 2, 8, 9, 10, 7, 75, 17, 5);
            test.prettyPrint();
        }
        else if (args[0].equals("0"))
        {
            test = new MinHeap<>();
            System.out.println(test);
        }
        else if (args[0].equals("1"))
        {
            test = new MinHeap<>();
            test.add(5);
            System.out.println(test);
        }
        else if (args[0].equals("2"))
        {
            test = new MinHeap<>();
            test.add(3);
            test.add(5);
            System.out.println(test);
        }
        else if (args[0].equals("3"))
        {
            test = new MinHeap<>(5, 10, 1, 6);
            System.out.println(test);
        }
        else if (args[0].equals("4"))
        {
            test = new MinHeap<>(1, 2, 8, 9, 10, 7, 75, 17, 5);
            test.remove();
            test.prettyPrint();
        }
        else if (args[0].equals("5"))
        {
            test = new MinHeap<>(1, 2, 8, 9, 10, 7, 75, 17, 5);
            test.prettyPrint();
            test.remove();
            test.prettyPrint();
            test.remove();
            test.prettyPrint();
            test.remove();
            test.prettyPrint();
            test.remove();
            test.prettyPrint();
            test.remove();
            test.prettyPrint();
            test.remove();
            test.prettyPrint();
            test.remove();

            test.prettyPrint();
            test.add(25);
            test.prettyPrint();
            test.add(35);
            test.prettyPrint();
            test.remove();
            test.prettyPrint();
        }
    }
}

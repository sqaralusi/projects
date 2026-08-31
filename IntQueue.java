import java.util.EmptyStackException;

public class IntQueue {
    private int[] array;
    private int size;

    public IntQueue()
    {
        array = new int[7];
        size = 0;
    }
    public IntQueue(int initialCapacity)
    {
        array = new int[initialCapacity];
        size = 0;
    }
    public void offer(int value)
    {
        if (size == array.length)
        {
            doubleCapacity();
        }
        array[size] = value;
        size++;
    }

    public Integer poll()
    {
        if (isEmpty())
        {
            return null;
        }
        int front = array[0];
        for (int i = 0; i < size - 1; i++)
        {
            array[i] = array[i + 1];
        }
        size--;
        return front;
    }

    public Integer peek()
    {
        if (isEmpty())
        {
            return null;
        }
        return array[0];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    private void doubleCapacity()
    {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < size; i++)
        {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }
        String result = "[";
        for (int i = size - 1; i > 0; i--)
        {
            result += array[i] + ", ";
        }
        result += array[0] + "]";
        return result;
    }

    public static void main(String[] args)
    {
        IntQueue test;
        if (args.length == 0)
        {
            test = new IntQueue();
            test.offer(5);
            test.offer(7);
            test.offer(9);
            test.offer(15);
            System.out.println(test.size());
        }
        else if (args.length == 1)
        {
            test = new IntQueue();
            System.out.println(test.isEmpty());
        }
        else if (args.length == 3)
        {
            test = new IntQueue();
            test.offer(Integer.parseInt(args[0]));
            test.offer(Integer.parseInt(args[1]));
            test.offer(Integer.parseInt(args[2]));
            System.out.println(test);
        }
        else if (args.length == 4)
        {
            test = new IntQueue();
            test.offer(Integer.parseInt(args[0]));
            test.offer(Integer.parseInt(args[1]));
            test.offer(Integer.parseInt(args[2]));
            if (args[3].equals("poll"))
            {
                System.out.println(test.poll());
                System.out.println(test.poll());
            }
            else if (args[3].equals("peek"))
            {
                System.out.println(test.peek());
                System.out.println(test.poll());
            }
            else if (args[3].equals("empty"))
            {
                System.out.println(test.isEmpty());
            }
            else if (args[3].equals("badPoll"))
            {
                while (!test.isEmpty())
                {
                    test.poll();
                }
                System.out.println(test.poll());
            }
            else if (args[3].equals("badPeek"))
            {
                while (!test.isEmpty())
                {
                    test.poll();
                }
                System.out.println(test.peek());
            }
        }
        else
        {
            System.out.println("Must have 0, 1, 3, or 4 command-line arguments");
        }
    }
}
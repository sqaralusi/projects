import java.util.Arrays;
import java.util.EmptyStackException;

public class IntStack {
    private int[] array;
    private int size;

    public IntStack()
    {
        array = new int[7];
        size = 0;
    }

    public IntStack(int initialCapacity)
    {
        array = new int[initialCapacity];
        size = 0;
    }

    public void push(int value)
    {
        if (size == array.length)
        {
            doubleCapacity();
        }
        array[size] = value;
        size++;
    }

    public int pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return array[--size];
    }

    public int peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return array[size - 1];
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

    @Override 
    public String toString()
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

    // main method - Do not change!
    public static void main(String[] args)
    {
        IntStack test;
        if (args.length == 0)
        {
            test = new IntStack();
            test.push(5);
            test.push(7);
            test.push(9);
            test.push(15);
            System.out.println(test.size());
        }
        else if (args.length == 1)
        {
            test = new IntStack();
            System.out.println(test.isEmpty());
        }
        else if (args.length == 3)
        {
            test = new IntStack(2);
            test.push(Integer.parseInt(args[0]));
            test.push(Integer.parseInt(args[1]));
            test.push(Integer.parseInt(args[2]));
            System.out.println(test);
        }
        else if (args.length == 4)
        {
            test = new IntStack();
            test.push(Integer.parseInt(args[0]));
            test.push(Integer.parseInt(args[1]));
            test.push(Integer.parseInt(args[2]));
            if (args[3].equals("pop"))
            {
                System.out.println(test.pop());
                System.out.println(test.pop());
            }
            else if (args[3].equals("peek"))
            {
                System.out.println(test.peek());
                System.out.println(test.pop());
            }
            else if (args[3].equals("empty"))
            {
                System.out.println(test.isEmpty());
            }
            else if (args[3].equals("exception1"))
            {
                try
                {
                    for (int i = 0; i < 4; i++)
                    {
                        test.pop();
                    }
                } catch (EmptyStackException e)
                {
                    System.out.println("OOPS! Stack is empty: can't pop()");
                }
            }
            else if (args[3].equals("exception2"))
            {
                while (!test.isEmpty())
                {
                    test.pop();
                }
                try
                {
                    test.peek();
                } catch (EmptyStackException e)
                {
                    System.out.println("OOPS! Stack is empty: can't peek()");
                }
            }
        }
        else
        {
            System.out.println("Must have 0, 1, 3, or 4 arguments");
        }
    }
}
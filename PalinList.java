import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PalinList {
    private Queue<String> queue;
    private Stack<String> stack;

    public PalinList()
    {
        queue = new LinkedList<>();
        stack = new Stack<>();
    }

    public PalinList(String tokens)
    {
        this();
        setList(tokens);
    }

    public void setList(String tokens)
    {
        String[] tokenArray = tokens.split(" ");
        queue.clear();
        stack.clear();
        for (String token : tokenArray)
        {
            queue.add(token);
            stack.push(token);
        }
    }

    public boolean isPalin()
    {
        while (!queue.isEmpty())
        {
            if (!queue.poll().equals(stack.pop()))
            {
                return false;
            }
        }
        return true;
    }

    @Override public String toString()
    {
        String result = queue.toString();
        if (isPalin())
        {
            return result + " is a palinlist";
        }
        else
        {
            return result + " is not a palinlist";
        }
    }

    public static void main(String[] args)
    {
        PalinList test = new PalinList();

        if (args.length == 0)
        {
            System.out.println(test);
        }
        else if (args[0].equals("queue.dat"))
        {
            try
            {
                Scanner scanner = new Scanner(new File("queue.dat"));
                while (scanner.hasNextLine())
                {
                    String line = scanner.nextLine();
                    test.setList(line);
                    System.out.println(test);
                }
                scanner.close();
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            test.setList(args[0]);
            System.out.println(test);
        }
    }
}
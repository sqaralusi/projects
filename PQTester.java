import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PQTester {
    private Queue<String> stringQueue;

    public PQTester()
    {
        stringQueue = new PriorityQueue<>();
    }

    public PQTester(String tokens)
    {
        stringQueue = new PriorityQueue<>();
        setPQ(tokens);
    }

    public void setPQ(String tokens)
    {
        stringQueue = new PriorityQueue<>();
        String[] tokenArray = tokens.split(" ");
        for (String token : tokenArray)
        {
            stringQueue.add(token);
        }
    }

    public String getMin()
    {
        return stringQueue.peek();
    }

    public String getNaturalOrder()
    {
        Queue<String> copyQueue = new PriorityQueue<>(stringQueue);
        String result = "";
        while (!copyQueue.isEmpty())
        {
            result += copyQueue.poll() + " ";
        }
        return result.trim();
    }

    @Override public String toString()
    {
        return stringQueue.toString();
    }

    public static void main(String[] args)
    {
        PQTester test = new PQTester();

        if (args.length == 0)
        {
            System.out.println(test);
        }
        else if (args[0].equals("pq.dat"))
        {
            try
            {
                Scanner scanner = new Scanner(new File("pq.dat"));
                while (scanner.hasNextLine())
                {
                    String line = scanner.nextLine();
                    test.setPQ(line);
                    System.out.println(test);
                    System.out.println("getMin() - " + test.getMin());
                    System.out.println("getNaturalOrder() - " + test.getNaturalOrder());
                    System.out.println();
                }
                scanner.close();
            } catch (FileNotFoundException e)
            {
                System.err.println("Error reading pq.dat: " + e.getMessage());
            }
        }
        else
        {
            test.setPQ(args[0]);
            System.out.println(test);
            System.out.println("getMin() - " + test.getMin());
            System.out.println("getNaturalOrder() - " + test.getNaturalOrder());
        }
    }
}
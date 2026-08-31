// Import statements
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class Histogram {
    // Instance variable
    private Map<String, Integer> histogram;
    // Constructors
    public Histogram()
    {
        histogram = new TreeMap<>();
    }
    public Histogram(String sentence)
    {
        this();
        setSentence(sentence);
    }
    public int size()
    {
        return histogram.size();
    }
    public void setSentence(String sentence)
    {
        histogram.clear();
        String[] x = sentence.split(" ");
        for (String token : x)
        {
            if (histogram.containsKey(token))
            {
                histogram.put(token, histogram.get(token) + 1);
            }
            else
            {
                histogram.put(token, 1);
            }
        }
    }

    @Override public String toString()
    {
        String output = "char\t1---5----01---5\n";
        for (Map.Entry<String, Integer> entry : histogram.entrySet())
        {
            String token = entry.getKey();
            int frequency = entry.getValue();
            output += token + "\t";
            for (int i = 0; i < frequency; i++)
            {
                output += "*";
            }
            output += "\n";
        }
        return output + "\n";
    }
    public static void main(String[] args) throws IOException
    {
        Histogram histogram = new Histogram();
        Scanner kb = new Scanner(new File("histogram.dat"));
        while (kb.hasNextLine())
        {
            String sentence = kb.nextLine();
            histogram.setSentence(sentence);
            System.out.println(histogram.toString());
        }
        kb.close();
    }
}
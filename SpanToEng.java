// Import statements
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SpanToEng {
    // Instance variable
    private Map<String, String> pairs;
    // Constructor
    public SpanToEng()
    {
        pairs = new TreeMap<String, String>();
    }

    public void putEntry(String entry)
    {
        String[] x = entry.split(" ");
        pairs.put(x[0], x[1]);
    }

    public String translate(String sentence)
    {
        String[] words = sentence.split(" ");
        String output = "";

        for (String word : words)
        {
            if (pairs.containsKey(words))
            {
                output += pairs.get(words) + " ";
            }
            else
            {
                output += words + " ";
            }
        }
        return output.trim();
    }

    @Override public String toString()
    {
        return pairs.toString().replaceAll(",", "\n");
    }

    public static void main(String[] args) throws IOException
    {
        SpanToEng translator = new SpanToEng();
        Scanner data = new Scanner(new File("spantoeng.dat"));

        int num = data.nextInt();
        data.nextLine();

        for (int i = 0; i < num; i++)
        {
            String entry = data.nextLine();
            translator.putEntry(entry);
        }

        while (data.hasNextLine())
        {
            String sentence = data.nextLine();
            String translation = translator.translate(sentence);
            System.out.println(translation);
        }

        data.close();
    }
}
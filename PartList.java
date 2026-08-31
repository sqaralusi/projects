import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PartList {
    // Instance Variable TODO
    private Map<Part, Integer> partMap;

    // Constructor
    public PartList()
    {
        partMap = new TreeMap<>();
    }

  public PartList(String filename) throws IOException {
    partMap = new TreeMap<>();
    Scanner fileScanner = new Scanner(new File(filename));
    while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        Part part = new Part(line);
        putEntry(part);
    }
    fileScanner.close();
    }

    public void putEntry(Part part)
    {
        if (!partMap.containsKey(part)) {
            partMap.put(part, 0);
        }
        partMap.put(part, partMap.get(part) + 1);

    }


    @Override public String toString()
    {
        String output = "";
        for (Part part : partMap.keySet())
        {
            output += part + " - " + partMap.get(part) + "\n";
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        PartList test = new PartList("autoparts.dat");
        System.out.println(test);
    }
}
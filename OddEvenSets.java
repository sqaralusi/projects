import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class OddEvenSets {
    // Instance Variables
    private Set<Integer> odds;
    private Set<Integer> evens;

    // Constructors
    public OddEvenSets() {
        this(" ");
    }

    public OddEvenSets(String line) {
        odds = new TreeSet<>();
        evens = new TreeSet<>();
        Scanner kb = new Scanner(line);
        while (kb.hasNextInt()) {
            int num = kb.nextInt();
            if (num % 2 == 0) {
                evens.add(num);
            }
            else {
                odds.add(num);
            }
        }
    }

    @Override
    public String toString() {
        return "ODDS : " + odds + "\nEVENS : " + evens + "\n";
    }

    public static void main(String args[]) {
        try {
            Scanner fileScan = new Scanner(new File("oddevendata.dat"));
            while (fileScan.hasNext()) {
                String line = fileScan.nextLine();
                OddEvenSets oddEvenSet = new OddEvenSets(line);
                System.out.println(oddEvenSet);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
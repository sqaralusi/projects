import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class Acronyms {
    private Map<String, String> map;

    public Acronyms() {
        map = new TreeMap<>();
    }

    public void putEntry(String entry) {
        String[] parts = entry.split(" - ");
        if (parts.length == 2) {
            map.put(parts[0], parts[1]);
        }
    }

    public String convert(String line) {
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.endsWith(".")) {
                word = word.substring(0, word.length() - 1);
                if (map.containsKey(word)) {
                    words[i] = map.get(word) + ".";
                }
            } else {
                if (map.containsKey(word)) {
                    words[i] = map.get(word);
                }
            }
        }
        return String.join(" ", words);
    }

    @Override
    public String toString() {
        return map.toString().replaceAll(", ", "\n");
    }

    public static void main(String[] args) throws IOException {
        Acronyms acronyms = new Acronyms();
            Scanner fileScan = new Scanner(new File("acronyms.dat"));

            int numEntries = Integer.parseInt(fileScan.nextLine());
            for (int i = 0; i < numEntries; i++) {
                String entry = fileScan.nextLine();
                acronyms.putEntry(entry);
            }
            System.out.println(acronyms);

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                String convertedLine = acronyms.convert(line);
                System.out.println(convertedLine);
            }
            fileScan.close();
        }
 }
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Relatives {
    private Map<String, Set<String>> map;
    public Relatives() {
        map = new TreeMap<>();
    }
    public void setPersonRelative(String line) {
        String[] names = line.split(" ");
        String person1 = names[0];
        String person2 = names[1];

        if (!map.containsKey(person1)) {
            map.put(person1, new TreeSet<>());
        }
        map.get(person1).add(person2);
    }
    public String getRelatives(String person) {
        Set<String> relatives = map.get(person);
        if (relatives != null && !relatives.isEmpty()) {
            return "[" + String.join(", ", relatives) + "]";
        }
        else {
            return "[]";
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String person = entry.getKey();
            Set<String> relatives = entry.getValue();

            result.append(person).append(" is related to ");
            if (!relatives.isEmpty()) {
                result.append(String.join(" ", relatives));
            }
            result.append("\n");
        }
        return result.toString();
    }
    public static void main(String[] args) throws IOException {
        Relatives relatives = new Relatives();
        Scanner fileScan = new Scanner(new File("relatives.dat"));
        int numPairs = Integer.parseInt(fileScan.nextLine());
        for (int i = 0; i < numPairs; i++) {
            String line = fileScan.nextLine();
            relatives.setPersonRelative(line);
        }
        String lastName = fileScan.nextLine();
        System.out.println(relatives.toString());
        String relativesInfo = relatives.getRelatives(lastName);
        System.out.println(lastName + " is related to " + relativesInfo);
        fileScan.close();
    }
}
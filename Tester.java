import java.util.Scanner;
public class Tester {
    public static void main(String[]args) {
        System.out.println("Hello again, world!");
        // the above prints "Hello again, world!
        int numApples = 7;
        final int PRICE_OF_APPLES = 46;
        System.out.print("The total for " + numApples + " apples: \n" + numApples * PRICE_OF_APPLES + " cents \n");
        if (PRICE_OF_APPLES >= 2000)
            System.out.println("Thank you valued customer!");
        for(int i=1; i<=12; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= 9; i++) {
            System.out.print(i * i);
            if (i != 9) {
                System.out.print(", ");
            }
        }
        System.out.println();
        for(int i=1; i<=256; i*=4) {
            System.out.print(i+" ");
        }
        Scanner kb = new Scanner(System.in);
        System.out.print("\nEnter a name: ");
        String name = kb.nextLine();
        if (name.length() >= 3)
            System.out.println("First three characters of your name: " + name.substring(0, 3));
        else {
            System.out.println("Your name is too short");
        }
        System.out.println(name.length());
        System.out.println(name.substring(0,3));
            int sum = 0;
            int count = 0;
            System.out.println("Enter integers (enter 0 to stop):");
            int number = kb.nextInt();
            while (number != 0) {
                sum += number;
                count++;
                number = kb.nextInt();
            }
            kb.close();
            if (count > 0) {
                double average = (double) sum / count;
                System.out.println("Sum: " + sum);
                System.out.println("Average: " + average);
            }
            else {
                System.out.println("No numbers were entered.");
                }
        double[] areas = new double[20];
        areas[0] = 4.56;
        int length = areas.length;
        areas[length - 1] = 8.08;
        boolean[] booleanArray = {true, true, false, false, true};
        kb.close();
        printMessage();
        int result = sum(7, 15);
        System.out.println(result);
        String str1 = "Vo";
        String str2 = "Poston";
        String longerString = longer(str1, str2);
        System.out.println(longerString);
        String input1 = "aaaaa";
        String alt1 = altCaps(input1);
        System.out.println(alt1);
        String input2 = "Hey!! THERE!";
        String alt2 = altCaps(input2);
        System.out.println(alt2);
        Player defaultPlayer = new Player();
        Player customPlayer = new Player("Bob", 9);

        System.out.println(defaultPlayer.playerInfo());
        System.out.println(customPlayer.playerInfo());
    }
    public static void printMessage() {
        System.out.println("This is a method!");
    }
    public static int sum(int a, int b) {
        return a+b;
    }
    public static String longer(String a, String b) {
        if(a.length() >= b.length()) {
            return a;
        }
        else {
            return b;
        }
    }
    public static String altCaps(String input) {
        StringBuilder result = new StringBuilder();
        int count  = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                if (count % 2 == 0) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
                count++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
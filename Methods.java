import java.util.Scanner;
public class Methods {
    public static void inputAllBaseTypes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a byte value: ");
        byte byteValue = scanner.nextByte();
        System.out.print("Enter a short value: ");
        short shortValue = scanner.nextShort();
        System.out.print("Enter an int value: ");
        int intValue = scanner.nextInt();
        System.out.print("Enter a long value: ");
        long longValue = scanner.nextLong();
        System.out.print("Enter a float value: ");
        float floatValue = scanner.nextFloat();
        System.out.print("Enter a double value: ");
        double doubleValue = scanner.nextDouble();
        System.out.print("Enter a char value: ");
        char charValue = scanner.next().charAt(0);
        System.out.println("You entered:");
        System.out.println("Byte: " + byteValue);
        System.out.println("Short: " + shortValue);
        System.out.println("Int: " + intValue);
        System.out.println("Long: " + longValue);
        System.out.println("Float: " + floatValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Char: " + charValue);
        scanner.close();
    }
    public static boolean isMultiple(long n, long m) {
        if (n % m == 0)
            return true;
        else
            return false;
    }
    public static int sumPositiveInt(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    public static int sumOfOdd(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }
    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
        public static void main(String[] args) {
            inputAllBaseTypes();
            System.out.println(isMultiple(10, 2));
            System.out.println(sumPositiveInt(5));
            System.out.println(sumOfOdd(7));
            System.out.println(countVowels("Hello, world!"));
        }
    }
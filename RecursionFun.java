import java.util.Stack;

public class RecursionFun {
    public static double sumReciprocals(int n)
    {
        if (n == 1)
        {
            return 1.0;
        }
        else
        {
            return 1.0 / n + sumReciprocals(n - 1);
        }
    }
    public static int productOfEvens(int n)
    {
        if (n == 0)
        {
            return 1;
        }
        else
        {
            return (2 * n) * productOfEvens(n - 1);
        }
    }
    public static void doubleUp(Stack<Integer> nums)
    {
        if (!nums.isEmpty())
        {
            int num = nums.pop();
            doubleUp(nums);
            nums.push(num);
            nums.push(num);
        }
    }
    public static void countToBy(int n, int m)
    {
        if (n >= 1)
        {
            countToBy(n - m, m);
            if (n > m)
            {
                System.out.print(", ");
            }
            System.out.print(n);
        }
    }
    public static int matchingDigits(int a, int b)
    {
        if (a < 0 || b < 0)
        {
            throw new IllegalArgumentException();
        }
        else if (a == 0 && b == 0)
        {
            return 1;
        }
        else
        {
            int result = 0;
            if (a % 10 == b % 10)
            {
                result++;
            }
            if (a / 10 == 0 || b / 10 == 0)
            {
                return result;
            }
            return result + matchingDigits(a / 10, b / 10);
        }
    }
    public static void printThis(int n)
    {
        if (n == 1)
        {
            System.out.print("*");
        }
        else if (n == 2)
        {
            System.out.print("**");
        }
        else
        {
            System.out.print("<");
            printThis(n - 2);
            System.out.print(">");
        }
    }
    public static void printNums2(int n) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            System.out.print("1 ");
        } else if (n % 2 != 0) {
            System.out.print((n / 2 + 1) + " ");
            printNums2(n - 2);
            System.out.print((n / 2 + 1) + " ");
        } else {
            System.out.print((n / 2) + " ");
            printNums2(n - 2);
            System.out.print((n / 2) + " ");
        }
    }
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            // If you want to add your own tests, do so here

            // Do not change the rest of this method!
            System.out.println("Usage: java RecursionFun methodName");
            return;
        }
        if (args[0].equals("sumReciprocals"))
        {
            System.out.println(sumReciprocals(10));
        }
        if (args[0].equals("productOfEvens"))
        {
            System.out.println(productOfEvens(4));
        }
        if (args[0].equals("doubleUp"))
        {
            Stack<Integer> stack = new Stack<>();
            stack.push(3);
            stack.push(7);
            stack.push(12);
            stack.push(9);
            System.out.println(stack);
            doubleUp(stack);
            System.out.println(stack);
        }
        if (args[0].equals("countToBy"))
        {
            countToBy(34, 5);
            System.out.println();
            countToBy(25, 4);
            System.out.println();
        }
        if (args[0].equals("matchingDigits"))
        {
            System.out.println(matchingDigits(1000, 0));
            System.out.println(matchingDigits(298892, 7892));
        }
        if (args[0].equals("printThis"))
        {
            for (int i = 1; i <= 8; i++)
            {
                printThis(i);
                System.out.println();
            }
        }
        if (args[0].equals("printNums2"))
        {
            for (int i = 1; i <= 10; i++)
            {
                printNums2(i);
                System.out.println();
            }
        }
    }
}
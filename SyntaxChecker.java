import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class SyntaxChecker {
    // Instance variables TODO
    private String expression;
    private Stack<String> stack;
    // Constructors TODO
    public SyntaxChecker()
    {
        this("");
    }
    public SyntaxChecker(String expression)
    {
        this.expression = expression;
        this.stack = new Stack<>();
    }
    // setExpression TODO
    public void setExpression(String expression)
    {
        this.expression = expression;
        this.stack.clear();
    }
    // checkExpression TODO
    public boolean checkExpression()
    {
        Stack<String> stack = new Stack<>();
        int i = 0;

        while (i < expression.length())
        {
            char ch = expression.charAt(i);
            String symbol = Character.toString(ch);

            if ("{[(".contains(symbol))
            {
                stack.push(symbol);
            }
            else if ("]})".contains(symbol))
            {
                if (!stack.isEmpty())
                {
                    String x = stack.pop();
                    if (!((x.equals("{") && symbol.equals("}")) || (x.equals("[") && symbol.equals("]")) ||
                          (x.equals("(") && symbol.equals(")"))))
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
    // toString TODO
    @Override public String toString()
    {
        if (expression.isEmpty())
        {
            return "No expression given\n";
        }
        else if (checkExpression())
        {
            return expression + " is correct\n";
        }
        else
        {
            return expression + " is incorrect\n";
        }
    }
    // main TODO
    public static void main(String[] args) throws IOException
    {
        SyntaxChecker test = new SyntaxChecker();
        if (args.length == 0)
        {
            System.out.println(test);
        }
        else if (args[0].equals("syntax.dat"))
        {
            File file = new File("syntax.dat");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                test.setExpression(line);
                System.out.println(test);
            }
            scanner.close();
        }
        else
        {
            test.setExpression(args[0]);
            System.out.println(test);
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    private String expression;
    private Stack<Double> stack = new Stack<>();
    public Postfix() {
        this("");
    }
    public Postfix(String expression) {
        this.expression = expression;
    }
    public void setExpression(String expression) {
        this.expression = expression;
        stack = new Stack<>();
    }
    public double solve() {
        if (expression == null) {
            return 0.0;
        }
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.matches("[0-9]+(\\.[0-9]+)?")) {
                stack.push(Double.parseDouble(token));
            }
            else if (token.length() == 1 && "+-*/".contains(token)) {
                if (stack.size() < 2) {
                    return 0.0;
                }
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result;

                if (token.equals("+")) {
                    result = operand1 + operand2;
                }
                else if (token.equals("-")) {
                    result = operand1 - operand2;
                }
                else if (token.equals("*")) {
                    result = operand1 * operand2;
                }
                else if (token.equals("/")) {
                    if (operand2 == 0) {
                        return 0.0;
                    }
                    result = operand1 / operand2;
                }
                else {
                    return 0.0;
                }
                stack.push(result);
            }
            else {
                return 0.0;
            }
        }

        return stack.pop();
    }
    public String toString() {
        if (expression == null || expression.isEmpty()) {
            return "Error: Empty Expression";
        }
        try {
            double result = solve();
            return expression + " = " + result;
        }
        catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
    public static void main(String[] args) {
        Postfix test = new Postfix();
        if (args.length == 0) {
            System.out.println(test);
        }
        else if (args[0].equals("postfix.dat")) {
            try {
                Scanner scanner = new Scanner(new File("postfix.dat"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    test.setExpression(line);
                    System.out.println(test);
                }
                scanner.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }
        else {
            test.setExpression(args[0]);
            System.out.println(test);
        }
    }
}
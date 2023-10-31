import java.util.Scanner;
import java.util.Stack;

/**
 * This is the Main class program that is used to run the program
 */
public class Main {


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in); // Command used to create a Scanner object

        String parentheses;
        // Asks the user to enter the parentheses expression and stores it in the string variable
        System.out.println("Enter the parentheses expression: ");
        parentheses = keyboard.nextLine();

        // If the method returns true then the program prints that the expression is balanced
        if (isBalanced(parentheses)) {
            System.out.println("Balanced");
        }
        // Else if the method returns false then the program prints that the expression is not balanced
        else {
            System.out.println("Not Balanced");
        }

    }

    /**
     * This is the isBalanced method that is used to check the expression by receiving it as a parameter and returns a boolean value
     * which is true if its balanced and false if it's not balanced
     * @param parentheses String
     * @return boolean
     */
    public static boolean isBalanced(String parentheses) {
        char n; // Creates a char variable
        Stack<Character> stack = new Stack<>(); // Command used to create a stack

        // For loop that runs through the string entered and checks for each character entered
        for (int i = 0; i < parentheses.length(); i++) {
            n = parentheses.charAt(i);

            // If and else statements that compares each the start and the end of each pair of parentheses and based on the condition returns if its balanced or not
            if (n == '(' || n == '{' || n == '[') {
                stack.push(n);
            }
            else if (n == ')' || n == '}' || n == ']') {
                if (stack.empty()) {
                    return false;
                } else {
                    char m = stack.pop();
                    if ((n == ')' && m != '(') || (n == '}' && m != '{') || (n == ']' && m != '[')) {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
}

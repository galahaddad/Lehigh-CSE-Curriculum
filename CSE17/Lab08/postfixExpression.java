/**
 * postfixExpression
 */
import java.util.Scanner;
import java.util.Stack;
public class postfixExpression {
    public static void main(String[] args) {
        Stack<Integer> postfixStack = new Stack<>();
        System.out.println("Enter an an expression: ");
        Scanner in = new Scanner(System.in);
        String input = in.next(); in.nextLine();    //takes in the next input
        for (int i = 0; i<input.length();i++) { // repeats for every value or expression input
            char c = input.charAt(i);
            if(Character.isDigit(c)) {
                postfixStack.push(c - '0');
            } else {
                int val1=postfixStack.pop();
                int val2=postfixStack.pop();
                switch(c) { //every potential case for expressions in the stack
                    case '+':
                    postfixStack.push(val2+val1);
                    break;

                    case '-':
                    postfixStack.push(val2-val1);
                    break;

                    case '/':
                    postfixStack.push(val2/val1);
                    break;

                    case '*':
                    postfixStack.push(val2*val1);
                    break;
                }

            }
        }
        if(postfixStack.isEmpty()) {    //when nothing is in the stack
            System.out.println("postfix expression malformed.");
        }
        System.out.println(postfixStack.pop()); //sends out the result
    }
}
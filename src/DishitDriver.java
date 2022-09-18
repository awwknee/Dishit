import java.util.Scanner;

/**
 * This program takes user input of one or multiple evaluations and applies to it data that is also
 * inputed. It can do basic operations such as reverse the data or duplicate it. This program can
 * also run simple math operations like addition, subtraction, multiplication and division on
 * inputed data.
 * 
 * @author Ani Lamichhane
 *
 */
class Main {
    public static void main(String[] args) {

        /**
         * Scanner.next() reads until next whitespace token which causes leading or trailing spaces
         * to mess up user input not sure how to deal with this without changing scanners'
         * delimiter.
         */

        Scanner keyboard = new Scanner(System.in).useDelimiter("\n");
        Interpreter interpreter;

        System.out.print("Would you like DishIt or DishIt-math: ");
        String interpreterString = keyboard.next();

        if (interpreterString.equals("DishIt")) {
            interpreter = new Interpreter();
        } else if (interpreterString.equals("DishIt-math")) {
            interpreter = new InterpreterMath();
        } else {
            return;
        }

        while (true) {
            System.out.print(">> ");

            String item = keyboard.next();
            String[] itemSplit = item.split("\\;");

            boolean successful;

            if (itemSplit.length == 1) {
                if (item.equals(":exit")) {
                    System.out.println("Goodbye!");
                    return;
                } else {
                    successful = interpreter.eval(item);

                    if (!successful) {
                        System.out.println("Error");
                        System.out.println("Goodbye!");
                        return;
                    }
                }
            } else {
                successful = interpreter.evalMultiple(itemSplit);

                if (!successful) {
                    System.out.println("Error");
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }
}

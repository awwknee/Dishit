
/**
 * Creates a InterpreterMath class that extends the Interpreter class with new math evaluations.
 * 
 * @author Ani Lamichhane
 *
 */
public class InterpreterMath extends Interpreter {
    /**
     * Takes user input of evaluation and applies it to the FancyStack.
     * 
     * @param item, String of user input.
     * @return boolean for error testing. True if no error, false if there is an error.
     */
    @Override
    public boolean eval(String item) {
        if (item.equals("OP_ADD")) {
            System.out.println("Doing addition...");
            return add();
        } else if (item.equals("OP_MULT")) {
            System.out.println("Doing multiplication...");
            return multiply();
        } else if (item.equals("OP_SUB")) {
            System.out.println("Doing subtraction...");
            return subtract();
        } else if (item.equals("OP_DIV")) {
            System.out.println("Doing division...");
            return divide();
        } else {
            return super.eval(item);
        }

    }

    /**
     * pops two values off of the stack, converts them to integers, adds them, and them pushes the
     * resulting value as a string back onto the stack.
     * 
     * @return boolean, true if is no error, false if there are not at least 2 items on the stack.
     */
    private boolean add() {
        String firstItem;
        String secondItem;
        int sum;

        firstItem = theStack.pop();
        secondItem = theStack.pop();

        if (firstItem == null || secondItem == null) {
            return false;
        }

        sum = (Integer.parseInt(firstItem)) + (Integer.parseInt(secondItem));

        theStack.push("" + sum);
        return true;
    }

    /**
     * pops two values off of the stack, converts them to integers, multiplies them, and them pushes
     * the resulting value as a string back onto the stack..
     * 
     * @return boolean, true if is no error, false if there are not at least 2 items on the stack.
     */
    private boolean multiply() {
        String firstItem;
        String secondItem;
        int product;

        firstItem = theStack.pop();
        secondItem = theStack.pop();

        if (firstItem == null || secondItem == null) {
            return false;
        }

        product = (Integer.parseInt(firstItem)) * (Integer.parseInt(secondItem));

        theStack.push("" + product);
        return true;
    }

    /**
     * pops two values off the stack, converts them to integers, and subtracts the first value
     * popped off the stack from the second value popped, pushing the result back on the stack as a
     * string.
     * 
     * @return boolean, true if is no error, false if there are not at least 2 items on the stack.
     */
    private boolean subtract() {
        String firstItem;
        String secondItem;
        int difference;

        firstItem = theStack.pop();
        secondItem = theStack.pop();

        if (firstItem == null || secondItem == null) {
            return false;
        }

        difference = (Integer.parseInt(secondItem)) - (Integer.parseInt(firstItem));

        theStack.push("" + difference);
        return true;
    }

    /**
     * pops two values off the stack, converts them to integers, does integer division the second
     * value and first value popped, pushing the result back on the stack as a string.
     * 
     * @return boolean, true if is no error, false if there are not at least 2 items on the stack.
     */
    private boolean divide() {
        String firstItem;
        String secondItem;
        int quotient;

        firstItem = theStack.pop();
        secondItem = theStack.pop();

        if (firstItem == null || secondItem == null) {
            return false;
        }

        quotient = (Integer.parseInt(secondItem)) / (Integer.parseInt(firstItem));

        theStack.push("" + quotient);
        return true;
    }

}

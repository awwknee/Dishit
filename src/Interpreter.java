/**
 * Creates an Interpreter class that creates a fancyStack and evaluates dishIt functions.
 * 
 * @author Ani Lamichhane
 *
 */
public class Interpreter {

    /**
     * protected FancyStack object.
     */
    protected FancyStack theStack;

    /**
     * Constructor for new Interpreter that creates a FancyStack object.
     */
    public Interpreter() {
        theStack = new FancyStack();

    }

    /**
     * Takes user input of multiple evaluations and applies them to the FancyStack. Also checks for
     * errors in the evaluations.
     * 
     * @param item, a string array of the separated user input of multiple evaluations.
     * @return boolean for error testing. True if no errors, false if at least one error.
     */
    public boolean evalMultiple(String[] item) {
        int size = item.length;
        int count = 0;

        while (count < size) {
            boolean successful = eval(item[count].trim());

            if (!successful) {
                return false;
            }

            count = count + 1;
        }

        return true;
    }

    /**
     * Takes user input of evaluation and applies it to the FancyStack.
     * 
     * @param item, String of user input.
     * @return boolean for error testing. True if no error, false if there is an error.
     */
    public boolean eval(String item) {

        if (item.equals("OP_DUP")) {
            System.out.println("Duplicating...");
            duplicate();
            return true;
        } else if (item.equals("OP_REVERSE")) {
            System.out.println("Reversing...");
            reverse();
            return true;
        } else if (item.equals("OP_CONCAT")) {
            System.out.println("Concatenating...");
            return concatenate();
        } else if (item.equals("OP_EQUAL")) {
            System.out.println("Testing equality...");
            return equal();
        } else if (item.equals("OP_LOWER")) {
            System.out.println("Lowering...");
            lower();
            return true;
        } else if (item.equals("OP_UPPER")) {
            System.out.println("Uppering...");
            upper();
            return true;
        } else if (item.equals("OP_DROP")) {
            System.out.println("Dropping...");
            drop();
            return true;
        } else if (item.equals("OP_NIP")) {
            System.out.println("Nipping...");
            return nip();
        } else if (item.equals("OP_DEPTH")) {
            System.out.println("Checking depth...");
            depth();
            return true;
        } else if (item.equals("OP_FINISH")) {
            System.out.println("Final answer: " + finish());
            return true;
        } else {
            System.out.println("Adding data to stack...");
            theStack.push(item);
            return true;
        }
    }

    /**
     * pops the top value off of the stack and duplicates it, pushing two copies back onto the
     * stack.
     */
    private void duplicate() {
        String currentItem;
        String duplicateCurrentItem;

        currentItem = theStack.pop();
        duplicateCurrentItem = currentItem;

        theStack.push(currentItem);
        theStack.push(duplicateCurrentItem);
    }

    /**
     * pops the top value off of the stack, reverses the string, then pushes the result back onto
     * the stack.
     */
    private void reverse() {
        String currentItem;
        String reversedCurrentItem = "";
        char letter;

        currentItem = theStack.pop();

        for (int i = 0; i < currentItem.length(); i++) {
            letter = currentItem.charAt(i);
            reversedCurrentItem = letter + reversedCurrentItem;
        }

        theStack.push(reversedCurrentItem);
    }

    /**
     * pops two values off of the stack, pastes the first value popped onto the end of the second
     * value
     * 
     * @return boolean, true if is no error, false if there are not at least 2 items on the stack.
     */
    private boolean concatenate() {
        String firstItem;
        String secondItem;
        String concatenatedItem;

        firstItem = theStack.pop();
        secondItem = theStack.pop();

        if (firstItem == null || secondItem == null) {
            return false;
        }

        concatenatedItem = secondItem + firstItem;

        theStack.push(concatenatedItem);
        return true;
    }

    /**
     * pops two values off of the stack and performs a string comparison. If they are equal, True is
     * pushed onto the stack, and False is pushed otherwise.
     * 
     * @return boolean, true if is no error, false if there are not at least 2 items on the stack.
     */
    private boolean equal() {
        String firstItem;
        String secondItem;

        firstItem = theStack.pop();
        secondItem = theStack.pop();

        if (firstItem == null || secondItem == null) {
            return false;
        }

        if (firstItem.equals(secondItem)) {
            theStack.push("True");
        } else {
            theStack.push("False");
        }
        return true;
    }

    /**
     * pops one value off of the stack, converts all letters to lowercase, and pushes the resulting
     * string back on the stack.
     */
    private void lower() {
        String currentItem;

        currentItem = theStack.pop();

        currentItem = currentItem.toLowerCase();

        theStack.push(currentItem);
    }

    /**
     * pops one value off of the stack, converts all letters to uppercase, and pushes the resulting
     * string back on the stack.
     */
    private void upper() {
        String currentItem;

        currentItem = theStack.pop();

        currentItem = currentItem.toUpperCase();

        theStack.push(currentItem);
    }

    /**
     * pops off the top stack item and pushes nothing back on.
     */
    private void drop() {
        theStack.pop();
    }

    /**
     * removes the second item from the stack.
     * 
     * @return boolean, true if is no error, false if there are not at least 2 items on the stack.
     */
    private boolean nip() {
        String firstItem;

        firstItem = theStack.pop();
        if (theStack.pop() == null) {
            return false;
        }

        theStack.push(firstItem);
        return true;
    }

    /**
     * pushes the number of stack elements onto the stack.
     */
    private void depth() {
        int size = theStack.size();

        theStack.push("" + size);
    }

    /**
     * pops one value off of the stack and displays it as a final answer. Any additional values on
     * the stack are popped off and thrown away.
     * 
     * @return string, the item on top of the stack.
     */
    private String finish() {
        String currentItem;

        currentItem = theStack.pop();

        theStack.clear();

        return currentItem;
    }
}

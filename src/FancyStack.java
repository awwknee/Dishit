import java.util.ArrayList;

/**
 * Creates a FancyStack class that allow user to check if the stack is empty, clear it, and find the
 * stacks size.
 * 
 * @author Ani Lamichhane
 *
 */
public class FancyStack extends StringStack {

    /**
     * Pops the first item from the stack and checks if it is empty or not. If it is not empty
     * returns the popped item back onto the stack.
     * 
     * @return boolean, true if empty and false if it is not empty.
     */
    public boolean isEmpty() {

        String currentitem = super.pop();

        if (currentitem == null) {
            return true;
        }
        super.push(currentitem);
        return false;

    }

    /**
     * Clears the stack.
     */
    public void clear() {
        while (super.pop() != null) {
        }
    }

    /**
     * Pops everything out of the stack, then counts it and pushes it back onto the stack in order.
     * 
     * @return int, the size of the stack.
     */
    public int size() {
        int count = 0;
        ArrayList<String> copy = new ArrayList<>();

        while (true) {
            String currentitem = super.pop();
            if (currentitem == null) {
                break;
            }
            copy.add(currentitem);
        }

        while (count < copy.size()) {
            super.push(copy.get(count));
            count = count + 1;
        }
        return copy.size();

    }
}

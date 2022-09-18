import java.util.ArrayList;

/**
 * Class to implement a Stack data structure that can store Strings.
 * 
 * @author Prof. Yilek
 *
 */
public class StringStack {

    /** ArrayList to hold the items in the stack. */
    private ArrayList<String> items;


    /**
     * No argument constructor that initializes an empty stack.
     */
    public StringStack() {
        items = new ArrayList<String>();
    }


    /**
     * Method to add an item to the top of the stack.
     * 
     * @param item The String to be added to the top of the stack.
     */
    public void push(String item) {
        items.add(item);
    }

    /**
     * Method to remove and return the top item from the stack.
     * 
     * @return Returns the top item from the stack, or null if the stack is empty.
     */
    public String pop() {
        if (items.size() == 0) {
            return null;
        }

        return items.remove(items.size() - 1);
    }



}

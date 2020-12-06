import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapIntPriorityQueue {
    /**
     * The elements of the hash table (top is at element 1)
     */
    private ArrayList<Integer> elements;

    /**
     * Creates a new empty HeapIntPriorityQueue
     */
    public HeapIntPriorityQueue() {
        elements = new ArrayList<Integer>();
        elements.add(-1); // dummy 0th element
    }

    /**
     * Adds the given value to this priority queue in order.
     * 
     * @param value the value to add to the priority queue.
     */
    public void add(int value) {
        elements.add(value); // add as rightmost leaf

        // "swim up" as necessary to fix ordering
        int i = elements.size() - 1;
        while (hasParent(i)
                && elements.get(i) < elements.get(parent(i))) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * Removes the element from the front of the priority queue
     * (top of the heap) and rearranges the elements.
     * 
     * @return the value of the element at the front of the
     *         priority queue (top of the heap).
     */
    public int remove() {
        // TODO: not yet implemented
        return 0;
    }

    /**
     * Helper method that returns the index of the parent of the
     * element at index i.
     * 
     * @param i the element to get the parent of
     * @return the index of the parent of element i.
     */
    private int parent(int i) {
        return i / 2;
    }

    /**
     * Helper method that returns the index of the left child of
     * the element at index i.
     * 
     * @param i the element to get the left child of
     * @return the index of the left child of element i.
     */
    private int leftChild(int i) {
        return i * 2;
    }

    /**
     * Helper method that returns the index of the right child
     * of the element at index i.
     * 
     * @param i the element to get the right child of
     * @return the index of the right child of element i.
     */
    private int rightChild(int i) {
        return i * 2 + 1;
    }

    /**
     * Helper method that returns true if the element at index i
     * has a parent element, false otherwise.
     * 
     * @param i the element to check
     * @return true if the element at index i has a parent,
     *         false otherwise.
     */
    private boolean hasParent(int i) {
        return i > 1;
    }

    /**
     * Helper method that returns true if the element at index i
     * has a left child, false otherwise.
     * 
     * @param i the element to check
     * @return true if the element at index i has a left child,
     *         false otherwise.
     */
    private boolean hasLeftChild(int i) {
        return leftChild(i) < elements.size();
    }

    /**
     * Helper method that returns true if the element at index i
     * has a right child, false otherwise.
     * 
     * @param i the element to check
     * @return true if the element at index i has a right child,
     *         false otherwise.
     */
    private boolean hasRightChild(int i) {
        return rightChild(i) < elements.size();
    }

    /**
     * A helper method to swap two elements. This method is
     * useful for swimming up or sinking down.
     * 
     * @param index1 the index of the first element to swap.
     * @param index2 the index of the second element to swap.
     */
    private void swap(int index1, int index2) {
        int temp = elements.get(index1);
        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }
}

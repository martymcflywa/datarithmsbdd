/**
 * Implementation of stack.
 *
 * @param <T> The type to store in the stack
 */
public class Stack<T> {

    private Node head;
    private int count;

    public Stack() {
        head = null;
    }

    /**
     * Add stuff to the stack. Pushes current element down and places new element at top of stack.
     *
     * @param data
     */
    public void push(T data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        count++;
    }

    /**
     * Delete stuff from the stack and return the thing being deleted. Raises second element to top of stack,
     * deleting the top element, then return the data about to be deleted.
     *
     * @return the top element.
     */
    public T pop() {

        if (isEmpty())
            return null;

        T toDelete = peek();
        head = head.next;
        count--;
        return toDelete;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private T peek() {
        if (isEmpty())
            return null;

        return head.data;
    }

    public int count() {
        return count;
    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
}

public class Queue<T> {

    private Node head;
    private Node tail;
    private int count;

    public Queue() {
        head = null;
        tail = null;
    }

    /**
     * Add stuff to end of queue.
     * If empty, add as first element.
     * If no tail, add as tail.
     * If is tail, add after tail.
     *
     * @param data
     */
    public void add(T data) {

        Node node = new Node(data);

        if (isEmpty())
            head = node;

        if (tail != null)
            tail.next = node;

        tail = node;
        count++;
    }

    /**
     * Remove stuff from start of queue.
     * If empty, there's nothing to remove.
     * Otherwise, save the data being removed so we can return it at the end.
     * Remove/dereference the first element by pushing forward the second element.
     * If first element is now empty, clear out the last element too, we've deleted everything.
     * Return the thing being removed.
     *
     * @return
     */
    public T remove() {

        if (isEmpty())
            return null;

        T toRemove = peek();
        head = head.next;

        if (head == null)
            tail = null;

        count--;
        return toRemove;
    }

    public int count() {
        return count;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private T peek() {

        if (isEmpty())
            return null;

        return head.data;
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

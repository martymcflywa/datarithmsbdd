import java.util.ArrayList;
import java.util.List;

public class BsTree<T extends Comparable<T>> {

    private Node root;

    public BsTree() {
        root = null;
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    private Node insert(T data, Node node) {
        if (node == null)
            node = new Node(data);

        // if data to insert is less than or equal to current node, go left
        if (data.compareTo(node.data) < 0) {
            node.left = insert(data, node.left);
            // otherwise go right, no duplicates allowed in this bst
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(data, node.right);
        }
        return node;
    }

    public T find(T data) {
        return dataAt(find(data, root));
    }

    private Node find(T data, Node node) {
        if (node == null)
            return null;

        if (data.compareTo(node.data) < 0) {
            return find(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            return find(data, node.right);
        } else {
            // we found it
            return node;
        }
    }

    public T remove(T data) {
        root = remove(data, root);
        return root.data;
    }

    private Node remove(T data, Node node) {
        if (node == null)
            return null;

        if (data.compareTo(node.data) < 0) {
            node.left = remove(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            node.right = remove(data, node.right);
        } else if (node.left != null && node.right != null) {
            // there are left and right children
            // move the minimum from right to left child
            node.data = dataAt(findMin(node.right));
            // then remove nodes starting from right
            node.right = remove(node.data, node.right);
        } else {
            node = node.left;
            if (node != null)
                node = node.right;
        }
        return node;
    }

    public T findMin() {
        return dataAt(findMin(root));
    }

    private Node findMin(Node node) {
        if (node == null)
            return null;

        if (node.left == null)
            return node;

        // always traverse left to find min
        return findMin(node.left);
    }

    public T findMax() {
        return dataAt(findMax(root));
    }

    private Node findMax(Node node) {
        if (node == null)
            return null;

        if (node.right == null)
            return node;

        // always traverse right to find max
        return findMax(node.right);
    }

    private T dataAt(Node node) {
        throw new UnsupportedOperationException();
    }

    private boolean isEmpty() {
        return root == null;
    }

    public List<T> preOrder() {
        List out = new ArrayList<T>();
        return preOrder(root, out);
    }

    private List<T> preOrder(Node node, List out) {
        if (node == null)
            return null;

        out.add(node.data);
        preOrder(node.left, out);
        preOrder(node.right, out);
        return out;
    }

    public List<T> inOrder() {
        List out = new ArrayList<T>();
        return inOrder(root, out);
    }

    private List<T> inOrder(Node node, List out) {
        if (node == null)
            return null;

        inOrder(node.left, out);
        out.add(node.data);
        inOrder(node.right, out);
        return out;
    }

    public List<T> postOrder() {
        List out = new ArrayList<T>();
        return postOrder(root, out);
    }

    private List<T> postOrder(Node node, List out) {
        if (node == null)
            return null;

        postOrder(node.left, out);
        postOrder(node.right, out);
        out.add(node.data);
        return out;
    }

    private class Node {

        private T data;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}

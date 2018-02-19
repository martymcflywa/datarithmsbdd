public class BinarySearch {

    public boolean searchIterative(String[] data, String target) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target.equals(data[middle]))
                return true;

            if (target.compareTo(data[middle]) < 0)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return false;
    }

    public boolean searchRecursive(String[] data, String target) {
        return searchRecursive(data, target, 0, data.length - 1);
    }

    private boolean searchRecursive(String[] data, String target, int left, int right) {
        if (left > right)
            return false;

        int middle = (left + right) / 2;

        if (target.equals(data[middle]))
            return true;

        if (target.compareTo(data[middle]) < 0)
            return searchRecursive(data, target, left, middle - 1);
        else
            return searchRecursive(data, target, middle + 1, right);
    }
}

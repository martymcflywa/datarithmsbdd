public class QuickSort {

    public void sort(String[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(String[] data, int left, int right) {
        if (left >= right)
            return;

        String pivot = data[(left + right) / 2];
        int index = partition(data, left, right, pivot);
        sort(data, left, index - 1);
        sort(data, index, right);
    }

    private int partition(String[] data, int left, int right, String pivot) {

        while (left <= right) {
            while (data[left].compareTo(pivot) < 0)
                left++;
            while (data[right].compareTo(pivot) > 0)
                right--;

            if (left <= right) {
                swap(data, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(String[] data, int left, int right) {
        String temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }
}

import java.lang.reflect.Array;

public class MergeSort {

    public void sort(String[] data) {
        String[] temp = (String[]) Array.newInstance(data[0].getClass(), data.length);
        sort(data, temp, 0, data.length - 1);
    }

    private void sort(String[] data, String[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd)
            return;

        int middle = (leftStart + rightEnd) / 2;
        sort(data, temp, leftStart, middle);
        sort(data, temp, middle + 1, rightEnd);
        merge(data, temp, leftStart, rightEnd);
    }

    private void merge(String[] data, String[] temp, int leftStart, int rightEnd) {

        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (data[left].compareTo(data[right]) <= 0) {
                temp[index] = data[left];
                left++;
            } else {
                temp[index] = data[right];
                right++;
            }
            index++;
        }

        System.arraycopy(data, left, temp, index, leftEnd - left + 1);
        System.arraycopy(data, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, data, leftStart, size);
    }
}

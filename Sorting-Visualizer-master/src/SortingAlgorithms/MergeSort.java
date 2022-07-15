package SortingAlgorithms;


import GUI.SortVisualizer;

/**
 * Project : Sorting Visualizer
 * <p>
 * This project's aim is to visualize different sorting algorithms
 * to provide an intuitive feel for them.
 *
 * @author Aniket Kumar Gupta
 * @version June 11, 2020
 */

public class MergeSort extends Sorter {
    @Override
    public void sort(SortVisualizer array) {
        mergeSort(array, 0, array.getArraySize() - 1);
    }

    private void mergeSort(SortVisualizer array, int left, int right) {
        if (left < right) {
            int middleIndex = (left + right) / 2;
            mergeSort(array, left, middleIndex);
            mergeSort(array, middleIndex + 1, right);
            merge(array, left, middleIndex, right);
        }
    }

    private int[] getSubArray(SortVisualizer array, int begin, int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = array.getArrayValue(begin + i);
        }
        return arr;
    }

    private void merge(SortVisualizer array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = getSubArray(array, left, leftSize);
        int[] rightArray = getSubArray(array, middle + 1, rightSize);

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array.updateSingle(k++, leftArray[i++], getDelay());
            } else {
                array.updateSingle(k++, rightArray[j++], getDelay());
            }
        }

        while (i < leftSize) {
            array.updateSingle(k++, leftArray[i++], getDelay());
        }

        while (j < rightSize) {
            array.updateSingle(k++, rightArray[j++], getDelay());
        }
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }

    @Override
    public long getDelay() {
        return 2;
    }
}

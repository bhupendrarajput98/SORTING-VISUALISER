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

public class HeapSort extends Sorter {
    @Override
    public void sort(SortVisualizer array) {
        int n = array.getArraySize();
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            array.swap(0, i, getDelay());
            maxHeapify(array, i, 0);
        }
    }

    private void maxHeapify(SortVisualizer array,  int size, int idx) {
        int largest = idx;
        int left = getLeft(idx);
        int right = getRight(idx);

        if (left < size && array.getArrayValue(left) > array.getArrayValue(largest)) {
            largest = left;
        }
        if (right < size && array.getArrayValue(right) > array.getArrayValue(largest)) {
            largest = right;
        }
        if (largest != idx) {
            array.swap(idx, largest, getDelay());
            maxHeapify(array, size, largest);
        }
    }

    public int getLeft(int idx) {
        return (idx * 2) + 1;
    }

    public int getRight(int idx) {
        return (idx * 2) + 2;
    }

    @Override
    public String toString() {
        return "Heap Sort";
    }

    @Override
    public long getDelay() {
        return 2;
    }
}

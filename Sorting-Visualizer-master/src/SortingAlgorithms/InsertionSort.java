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

public class InsertionSort extends Sorter {
        @Override
    public void sort(SortVisualizer array) {
        for (int i = 0; i < array.getArraySize(); i++) {
            int j = i - 1;
            int key = array.getArrayValue(i);
            while (j >= 0 && array.getArrayValue(j) > key) {
                array.swap(j, j+1, 5);
                System.out.println("called ");
                --j;
            }
        }
    }



    @Override
    public String toString() {
        return "Insertion Sort";
    }

    @Override
    public long getDelay() {
        return 2;
    }
}
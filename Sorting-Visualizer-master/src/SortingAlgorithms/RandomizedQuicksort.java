package SortingAlgorithms;

import GUI.SortVisualizer;

import java.util.Random;

/**
 * Project : Sorting Visualizer
 * <p>
 * This project's aim is to visualize different sorting algorithms
 * to provide an intuitive feel for them.
 *
 * @author Aniket Kumar Gupta
 * @version June 11, 2020
 */

public class RandomizedQuicksort extends Sorter {
    @Override
    public void sort(SortVisualizer array) {
        quickSort(array, 0, array.getArraySize() - 1);
    }

    public int randomPartition(SortVisualizer array, int start, int end) {
        Random random = new Random();
        int split = random.nextInt(end - start) + start;
        array.swap(split, end, 5);
        int median = array.getArrayValue(split);

        while (true) {
            while (end >= 0 && array.getArrayValue(end) >= median) {
                --end;
            }
            while (start < array.getArraySize() && array.getArrayValue(start) < median) {
                ++start;
            }
            if (start < end) {
                array.swap(start, end, 2);
            } else {
                return end;
            }
        }
    }


    public void quickSort(SortVisualizer array, int start, int end) {
        if (start < end) {
            int split = randomPartition(array, start, end);
            quickSort(array, start, split);
            quickSort(array, split+1, end);
        }
    }

    @Override
    public String toString() {
        return "Randomized Quicksort";
    }

    @Override
    public long getDelay() {
        return 2;
    }
}

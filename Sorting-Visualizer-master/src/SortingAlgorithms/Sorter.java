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


public abstract class Sorter
{
    public abstract void sort(SortVisualizer array);
    public abstract String toString();
    public abstract long getDelay();
}
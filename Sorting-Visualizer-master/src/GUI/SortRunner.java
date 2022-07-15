package GUI;

import SortingAlgorithms.Sorter;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Project : Sorting Visualizer
 * <p>
 * This project's aim is to visualize different sorting algorithms
 * to provide an intuitive feel for them.
 *
 * This class creates independent threads to sort
 * the array and is responsible for running the
 * visualization processes from the backdrop as needed.
 *
 * @author Aniket Kumar Gupta
 * @version June 11, 2020
 */

public final class SortRunner extends BaseScreen {
    private final SortVisualizer visualize;
    private final ArrayList<Sorter> sortQueue;

    /**
     * This constructor sets the screen and creates the appropriate
     * instances and assignments
     *
     * @param algorithms used to contain all the sorting algorithms needed
     * @param app used to reset and change the screen
     */

    public SortRunner(ArrayList<Sorter> algorithms, FrameHandler app) {
        super(app);
        visualize = new SortVisualizer();
        add(visualize);

        sortQueue = algorithms;
    }

    /**
     * This method shuffles all the array values and colors accordingly. It is a helper
     * method for onOpen()
     */

    private void shuffleAndWait() {
        visualize.shuffle();
        visualize.resetColours();
        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method creates independent threads for each
     * sorting algorithm added to the queue from the menu and
     * applies the required operations of adding name, coloring
     * bars, sorting, highlighting at the end, and then resetting
     * colors. This blocks the EDT for the aforementioned processes
     */

    public void onOpen() {
        SwingWorker swingWorker = new SwingWorker() {
            @Override
            protected Object doInBackground() {
                for (Sorter algorithm : sortQueue) {
                    shuffleAndWait();

                    visualize.setName(algorithm.toString());
                    algorithm.sort(visualize);

                    visualize.resetColours();
                    visualize.highlightArray();
                    visualize.resetColours();
                }
                return null;
            }

            @Override
            public void done() {
                app.popScreen();
            }
        };

        swingWorker.execute();
    }
}
package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Project : Sorting Visualizer
 * <p>
 * This project's aim is to visualize different sorting algorithms
 * to provide an intuitive feel for them.
 *
 * This class is where the GUI section of the visualizer itself
 * is provided. It draws a canvas and makes appropriate changes on it
 * depending on the operation needed.
 *
 * @author Aniket Kumar Gupta
 * @version June 11, 2020
 */

public class SortVisualizer extends JPanel {
    public static final int WIN_WIDTH = 1280;
    public static final int WIN_HEIGHT = 720;
    private static final int BAR_WIDTH = 5;
    private static final int NUM_BARS = WIN_WIDTH / BAR_WIDTH;

    private final int[] array;
    private final int[] barColours;
    private String algorithmName = "";

    /**
     * Constructor to set values and the background
     */

    public SortVisualizer() {
        setBackground(Color.BLACK);
        array = new int[NUM_BARS];
        barColours = new int[NUM_BARS];
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i;
            barColours[i] = 0;
        }
    }

    /**
     * This method is a getter for the size of the array
     *
     * @return the size of the array
     */

    public int getArraySize() {
        return array.length;
    }

    /**
     * This method is a getter for the specified array value
     *
     * @param index the index of which the value is needed
     * @return the value at the index in the array
     */

    public int getArrayValue(int index) {
        return array[index];
    }

    /**
     * This method swaps the array values at the 2 indices
     * and delays this by sleeping the thread by the specified ms delay.
     *
     * @param firstIndex this is the first index in the array to be used for swapping
     * @param secondIndex this is the second index in the array to be used for swapping
     * @param millisecondDelay the time delay to be used while sleeping the thread
     */

    public void swap(int firstIndex, int secondIndex, long millisecondDelay) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;

        barColours[firstIndex] = 100;
        barColours[secondIndex] = 100;

        repaint();
        try {
            Thread.sleep(millisecondDelay);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    /**
     * This method colors a single array bar given the index and reassigns its
     * value with a delay of the number of ms specified.
     *
     * @param index this is the index in the array to be used
     * @param value the value to be assigned at the index
     * @param millisecondDelay the time delay to be used while sleeping the thread
     */

    public void updateSingle(int index, int value, long millisecondDelay) {
        array[index] = value;
        barColours[index] = 100;
        repaint();
        try {
            Thread.sleep(millisecondDelay);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * This method shuffles the array values by using a
     * random number generator to swap indices with.
     */

    public void shuffle() {
        Random rng = new Random();
        for (int i = 0; i < getArraySize(); i++) {
            int swapWithIndex = rng.nextInt(getArraySize() - 1);
            swap(i, swapWithIndex, 5);
        }
    }

    /**
     * This method highlights the entire array by calling updateSingle
     * on each array value with a delay. This induces the final effect
     * post-sorting where the red color goes from left to right.
     */

    public void highlightArray() {
        for (int i = 0; i < getArraySize(); i++) {
            updateSingle(i, getArrayValue(i), 5);
        }
    }



    /**
     * Getter for the dimensions of the JFrame
     */

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }

    /**
     * Rests the colors of the bars and then calls the paintComponent() method
     * using repaint()
     */

    public void resetColours() {
        for (int i = 0; i < NUM_BARS; i++) {
            barColours[i] = 120;
        }
        repaint();
    }

    /**
     * Creates the canvas literally with the array values
     * and sets their color with other helper methods.
     *
     * @param graphic It allows us to modify the canvas
     */

    @Override
    public void paintComponent(Graphics graphic) {
        Graphics2D graphics = (Graphics2D) graphic;
        super.paintComponent(graphics);

        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font("Verdana", Font.BOLD, 30));
        graphics.drawString(algorithmName, 100, 100);

        for (int x = 0; x < NUM_BARS; x++) {
            int height = getArrayValue(x) * 2;
            int xBegin = x + (BAR_WIDTH - 1) * x;
            int yBegin = WIN_HEIGHT - height;

            int val = barColours[x] * 2;
            graphics.setColor(new Color(255, 255 - val, 255 - val));
            graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
            if (barColours[x] > 0) {
                barColours[x] -= 10;
            }
        }
    }

    /**
     * Sets the algorithm's name
     *
     * @param algorithmName Name of the algorithm
     */

    public void setName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
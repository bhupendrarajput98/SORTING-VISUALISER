package GUI;


import javax.swing.*;
import java.awt.*;

/**
 * Project : Sorting Visualizer
 * <p>
 * This project's aim is to visualize different sorting algorithms
 * to provide an intuitive feel for them.
 *
 * This class's aim is to provide an abstraction for
 * the different screens that the GUI section will have
 * for the different processes: menu, sorting, and the visualizer
 * itself.
 *
 * @author Aniket Kumar Gupta
 * @version June 11, 2020
 */



public abstract class BaseScreen extends JPanel {
    protected FrameHandler app;


    /**
     * This constructor sets the correct frame
     * as the base screen
     * @param app is the frame to be used as base screen
     */

    public BaseScreen(FrameHandler app) {
        this.app = app;
    }


    /**
     * This method returns t
     */

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(SortVisualizer.WIN_WIDTH, SortVisualizer.WIN_HEIGHT);
    }

    /**
     * abstract method for subclasses to override
     */

    public abstract void onOpen();
}
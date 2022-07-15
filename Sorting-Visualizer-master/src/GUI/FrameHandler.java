package GUI;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Project : Sorting Visualizer
 * <p>
 * This project's aim is to visualize different sorting algorithms
 * to provide an intuitive feel for them.
 *
 * This class handles the different screens and their order
 * as and when they are needed. It acts sort of like a
 * stage on which multiple acts occur.
 *
 * @author Aniket Kumar Gupta
 * @version June 11, 2020
 */

public class FrameHandler {
    private final JFrame window;
    private final ArrayList<BaseScreen> screens;

    /**
     * This method sets and assigns the appropriate values
     * and lays out the beginning details such as title etc.
     */

    public FrameHandler() {
        screens = new ArrayList<>();
        window = new JFrame ("Sort Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
    }

    /**
     * This method adds the screen to the list and makes it visible
     *
     * @param screen is the screen to be added to the list
     */

    public void pushScreen(BaseScreen screen) {
        if (!screens.isEmpty()) {
            screens.get(screens.size() - 1).setVisible(false);
        }
        screens.add(screen);
        window.add(screen);
        window.pack();
        screen.onOpen();
    }

    /**
     * This method removes the screen from the list and gets the next
     * one in the list
     */

    public void popScreen() {
        if (!screens.isEmpty()) {
            BaseScreen prev = screens.get(screens.size() - 1);
            prev.setVisible(false);
            screens.remove(prev);
            window.remove(prev);
            if (!screens.isEmpty()) {
                screens.get(screens.size() - 1).onOpen();
                screens.get(screens.size() - 1).setVisible(true);
            }
            else
                window.dispose();
        }
    }

    /**
     * This sets the first screen by adding it to the list
     */

    public void start() {
        pushScreen(new Menu(this));
    }

    /**
     * main() to start the event dispatch thread
     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrameHandler().start());
    }
}
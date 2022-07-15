package GUI;

import SortingAlgorithms.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Project : Sorting Visualizer
 * <p>
 * This project's aim is to visualize different sorting algorithms
 * to provide an intuitive feel for them.
 *
 * This class delineates the code for Menu section of the program
 *
 * @author Aniket Kumar Gupta
 * @version June 11, 2020
 */

public final class Menu extends BaseScreen {
    private final ArrayList<AlgorithmCheckBox> checkBoxes;

    /**
     * This method sets layout for the screen of menu by calling superclass and initializes
     * the appropriate values.
     * @param app is the frame to be used by superclass to be set as base screen
     */

    public Menu(FrameHandler app) {
        super(app);
        checkBoxes = new ArrayList<>();
        setUpGUI();
    }

    /**
     * This method adds checkboxes to the list and finally to the panel
     * @param algorithm is the algorithm selected by user which is to be visualised
     * @param panel is the panel to which the checkboxes are to be added.
     */

    private void addCheckBox(Sorter algorithm, JPanel panel) {
        JCheckBox box = new JCheckBox("", true);
        box.setAlignmentX(Component.LEFT_ALIGNMENT);
        checkBoxes.add(new AlgorithmCheckBox(algorithm, box));
        panel.add(box);
    }

    /**
     * This method has the entire code to generate the menu section
     */

    public void setUpGUI() {

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        JLabel mainTitle = new JLabel("<html><div style='text-align: center;'><b> Welcome to the Sorting " +
                "Algorithm Visualizer </div></b></html>");
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setFont(new Font("Courier", Font.BOLD, 30));
        mainPanel.add(mainTitle);


        JPanel checkboxPanel = new JPanel(new GridLayout(0,2, 5 , 5));
        checkboxPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        addCheckBox(new BubbleSort(), checkboxPanel);
        addCheckBox(new HeapSort(), checkboxPanel);
        addCheckBox(new InsertionSort(), checkboxPanel);
        addCheckBox(new MergeSort(), checkboxPanel);
        addCheckBox(new RandomizedQuicksort(), checkboxPanel);

        mainPanel.add(checkboxPanel);

        JButton startButton = new JButton("Sort!");
        startButton.addActionListener((ActionEvent e) -> {
            ArrayList<Sorter> algorithms = new ArrayList<>();
            for (AlgorithmCheckBox checkBoxes : checkBoxes) {
                if (checkBoxes.isSelected()) {
                    algorithms.add(checkBoxes.getAlgorithm());
                }
            }
            app.pushScreen(new SortRunner(algorithms, app));
        });

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(startButton);
        add(mainPanel);
    }

    /**
     * This method overrides the superclass's onOpen and resets its checkboxes
     * to be unselected
     */

    @Override
    public void onOpen() {
        for (AlgorithmCheckBox checkBox : checkBoxes) {
            checkBox.box.setSelected(false);
        }
    }

    /**
     * This class essentially is used to maintain list of checkboxes with the corresponding algorithm.
     */

    private static class AlgorithmCheckBox {
        private final Sorter algorithm;
        private final JCheckBox box;

        public AlgorithmCheckBox(Sorter algorithm, JCheckBox box) {
            this.algorithm = algorithm;
            this.box = box;
            this.box.setText(algorithm.toString());
        }


        public boolean isSelected() {
            return box.isSelected();
        }

        public Sorter getAlgorithm() {
            return algorithm;
        }
    }

}
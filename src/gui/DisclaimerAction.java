package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisclaimerAction implements ActionListener {
    /**
     * @wbp.parser.entryPoint
     */
    public void actionPerformed(ActionEvent e) {
        JFrame helpScreen = new JFrame();
        JPanel panel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("unicampLogo.png");
        JLabel imageLabel = new JLabel(imageIcon);
        JTextArea helpTextArea = new JTextArea(10, 25);
        JScrollPane scrollPane = new JScrollPane(helpTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Help JFrame configurations
        helpScreen.setTitle("Disclaimer for Traffic Lights - Ver. 1.0 - December, 2020");
        helpScreen.setVisible(true);
        helpScreen.setSize(600, 200);

        // Inserting help JTextArea
        String helpText = "This program was written as a part of a college project, it's intention is to demonstrate resources of Graphical User Interface (Swing) through a distribued program create in order to demonstrate the control of a semaphore simulated network";
        helpTextArea.setLineWrap(true);
        helpTextArea.setWrapStyleWord(true);
        helpTextArea.append(helpText);
        helpTextArea.setEditable(false);

        // Inserting components into JFrame
        panel.add(imageLabel);
        panel.add(scrollPane, BorderLayout.PAGE_START);
        helpScreen.getContentPane().add(panel);
    }
}

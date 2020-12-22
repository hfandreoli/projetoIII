package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelpAction implements ActionListener{
    public void actionPerformed(ActionEvent e){
        JFrame howToScreen = new JFrame();
        JPanel panel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("/Users/victorspolaor/Downloads/unicampLogo.png");
        JLabel imageLabel = new JLabel(imageIcon);
        JTextArea howToTextArea = new JTextArea(10, 25);
        JScrollPane scrollPane = new JScrollPane(howToTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Help JFrame configurations
        howToScreen.setTitle("How to use it - Ver. 1.0 - November, 2020");
        howToScreen.setVisible(true);
        howToScreen.setSize(600, 200);

        // Inserting how to JTextArea
        String helpText = "In terms of using the software, it's very easy and intuitive:\n * In the combox right below the menu, choose the type of conversion you want to make\n * Insert the numeric value you want to convert in front of the 'Convert from' label\n * Choose the units you want to convert from and convert to\n * Click on the 'convert' button to make the conversion";
        howToTextArea.setLineWrap(true);
        howToTextArea.setWrapStyleWord(true);
        howToTextArea.append(helpText);
        howToTextArea.setEditable(false);

        // Inserting components into JFrame
        panel.add(imageLabel);
        panel.add(scrollPane, BorderLayout.PAGE_START);
        howToScreen.add(panel);
    }
}

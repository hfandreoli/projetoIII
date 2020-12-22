package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelpAction implements ActionListener{
    /**
     * @wbp.parser.entryPoint
     */
    public void actionPerformed(ActionEvent e){
        JFrame howToScreen = new JFrame();
        JPanel panel = new JPanel();
        JTextArea howToTextArea = new JTextArea(10, 25);
        JScrollPane scrollPane = new JScrollPane(howToTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Help JFrame configurations
        howToScreen.setTitle("How to use it - Ver. 1.0 - December, 2020");
        howToScreen.setVisible(true);
        howToScreen.setSize(600, 200);

        // Inserting how to JTextArea
        String helpText = "In terms of using the software, it's very easy and intuitive:\n * In order to use it you just need to execute the TrafficLightServer class, this class represents the application server-side, which is responsible for monitoring the semaphores\n * Then you execute the TrafficLight class, this class represents the application client-side, which is responsible for executing the semaphores, each time this class is executed, a new semaphore is created and the server register it while the transactions continue\n ** To end a semaphore execution you can just close the client window where it's inserted\n ** To end the the program execution, you can just close the server window";
        howToTextArea.setLineWrap(true);
        howToTextArea.setWrapStyleWord(true);
        howToTextArea.append(helpText);
        howToTextArea.setEditable(false);

        // Inserting components into JFrame
        panel.add(scrollPane, BorderLayout.PAGE_START);
        howToScreen.getContentPane().add(panel);
    }
}
package server;

import gui.*;
import javax.swing.*;

public class TrafficLightServerWindow extends JFrame {
    JTextArea textArea;

    public TrafficLightServerWindow(){
        setTitle("Traffic Light - Ver. 1.0");

        // Menu buttons
        JMenuBar menuBar = new JMenuBar();
        // Menu buttons
        JMenu menuButton = new JMenu("File");
        JMenu helpButton = new JMenu("Help");
        helpButton.addActionListener(new HelpAction());
        menuBar.add(menuButton);
        menuBar.add(helpButton);
        setJMenuBar(menuBar);

        // Help menu
        JMenuItem helpScreenMenuItem = new JMenuItem("How to use it");
        JMenuItem fileMenuItem = new JMenuItem("Disclaimer");
        helpButton.add(helpScreenMenuItem);
        menuButton.add(fileMenuItem);
        helpScreenMenuItem.addActionListener(new HelpAction());
        fileMenuItem.addActionListener(new DisclaimerAction());


        JPanel panel = new JPanel();

        textArea = new JTextArea(30,40);
        textArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(scroll);

        add(panel);

        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void appendText(String text){
        textArea.append(text);
    }
}

package client;

import gui.DisclaimerAction;
import gui.HelpAction;

import javax.swing.*;

public class TrafficLightWindow extends JFrame{

    public TrafficLightPanel panel;

    public TrafficLightWindow(){
        setTitle("Traffic Light - Ver. 1.0 (Server");

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

        panel = new TrafficLightPanel();
        add(panel);
        setSize(250,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

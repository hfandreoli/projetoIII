package client;

import javax.swing.*;
import java.awt.*;

public class TrafficLightDrawing extends JComponent {
    Color stop = Color.black;
    Color slow = Color.black;
    Color go = Color.black;

    public void paintComponent(Graphics graphics){
        graphics.setColor(Color.darkGray);
        graphics.fillRect(0,0,150,250);
        graphics.setColor(Color.black);
        graphics.drawRect(0,0,150,250);

        graphics.setColor(stop);
        graphics.fillOval(50,30,50,50);
        graphics.setColor(slow);
        graphics.fillOval(50,100,50,50);
        graphics.setColor(go);
        graphics.fillOval(50,170,50,50);
    }

    public void setGreen(){
        stop = Color.black;
        slow = Color.black;
        go = Color.green;

        repaint();
    }

    public void setYellow(){
        stop = Color.black;
        slow = Color.yellow;
        go = Color.black;

        repaint();
    }

    public void setRed(){
        stop = Color.red;
        slow = Color.black;
        go = Color.black;

        repaint();
    }
}

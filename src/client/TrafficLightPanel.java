package client;

import javax.swing.*;
import java.awt.*;

public class TrafficLightPanel extends JPanel{

    public TrafficLightDrawing light = new TrafficLightDrawing();

    public TrafficLightPanel(){
        light.setPreferredSize(new Dimension(160, 260));
        add(light);
    }
}

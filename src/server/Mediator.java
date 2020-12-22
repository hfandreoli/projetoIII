package server;

import common.SysParameters;

import java.util.*;

public class Mediator {
    TrafficLightServerWindow window;

    public Mediator(){
        window = new TrafficLightServerWindow();
        window.appendText("Server log:\n\n");
    }

    public void updateLog(ArrayList<ClientIdentification> clients){
        window.appendText(buildText(clients));
    }

    private String buildText(ArrayList<ClientIdentification> clients){
        String text = "\tActive clients: (" + clients.size() + ")\n";

        for (ClientIdentification client : clients) {
            text += "\t *** /" + SysParameters.hostName + ":" + client.getPort() + " >> " + client.getState().getDescription() +"\n";
        }

        text += "\n";

        return text;
    }
}

package server;

import client.TrafficLight;
import common.Command;
import common.NetWrapper;

import java.io.IOException;

public class TimerTask extends java.util.TimerTask {
    ClientIdentification clientIdentification;
    TrafficLightServer server;

    public TimerTask(ClientIdentification clientIdentification, TrafficLightServer server){
        this.clientIdentification = clientIdentification;
        this.server = server;
    }

    @Override
    public void run() {
        clientIdentification.nextState();
        try {
            server.getNetwork().send(new NetWrapper(Command.NEXT_STATE), clientIdentification.getPort());
            server.updateLog();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

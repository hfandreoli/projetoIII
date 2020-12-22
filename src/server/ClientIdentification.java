package server;

import common.TrafficLightState;

import java.util.*;

public class ClientIdentification {
    private int port;
    private TrafficLightState currentState;
    private Timer timer;

    public ClientIdentification(int port, TrafficLightServer server) {
        this.port = port;
        currentState = TrafficLightState.GREEN;
        timer = new Timer();
        timer.schedule(new TimerTask(this, server), 4000, 4000);
    }

    public int getPort() {
        return port;
    }

    public void nextState() {
        currentState = currentState.getNextState();
    }

    public TrafficLightState getState() {
        return currentState;
    }

    public void stopTimer(){
        timer.cancel();
    }
}

package server;

import common.TrafficLightState;

import java.util.*;

public class ClientIdentification {
    private int port;
    private TrafficLightState currentState;
    private Timer timer;

    public ClientIdentification(int port) {
        this.port = port;
        currentState = TrafficLightState.GREEN;
        timer = new Timer();
        timer.schedule(new TimerTask(this), new Date(), 4000);
    }

    public int getPort() {
        return port;
    }

    public void nextState() {
        currentState = currentState.getNextState();
    }

    public void setState(TrafficLightState newState) {
        currentState = newState;
    }

    public TrafficLightState getState() {
        return currentState;
    }
}

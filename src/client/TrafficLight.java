package client;

import common.*;

import java.io.*;
import java.net.*;

public class TrafficLight {

    private static ClientNetworkManager networkManager;

    public static void main(String[] args) throws IOException {
        ShutDownTask shutDownTask = new ShutDownTask();
        Runtime.getRuntime().addShutdownHook(shutDownTask);

        new TrafficLight();
    }

    public TrafficLight() throws IOException {
        TrafficLightWindow window = new TrafficLightWindow();

        networkManager = new ClientNetworkManager();
        networkManager.send(new NetWrapper(Command.REGISTER), SysParameters.serverPort);
        TrafficLightState currentState = TrafficLightState.REGISTERED;

        while (true) {
            try {
                NetWrapper message = networkManager.receive();
                if (message.getCommand() == Command.NEXT_STATE) {
                    currentState = currentState.getNextState();
                    switch (currentState) {
                        case GREEN -> window.panel.light.setGreen();
                        case YELLOW -> window.panel.light.setYellow();
                        case RED -> window.panel.light.setRed();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private static class ShutDownTask extends Thread {
        @Override
        public void run() {
            try {
                networkManager.send(new NetWrapper(Command.FINALIZE), SysParameters.serverPort);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

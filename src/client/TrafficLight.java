package client;

import common.*;
import java.io.*;
import java.net.*;

public class TrafficLight {
    private TrafficLightState currentState;
    private DatagramSocket socket = null;

    public static void main(String[] args) throws IOException {
        TrafficLight trafficLight = new TrafficLight();
    }

    public TrafficLight() throws IOException {
        ClientNetworkManager networkManager = new ClientNetworkManager();
        networkManager.send(new NetWrapper(Command.REGISTER), SysParameters.serverPort);
        currentState = TrafficLightState.REGISTERED;
        System.out.println("novo estado: " + currentState.getDescription());

        socket = new DatagramSocket();
        System.out.println("enviado");

        while (true) {
            try {
                NetWrapper message = networkManager.receive();
                if (message.getCommand() == Command.NEXT_STATE) {
                    currentState = currentState.getNextState();
                    System.out.println("novo estado: " + currentState.getDescription());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

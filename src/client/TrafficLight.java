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

        socket = new DatagramSocket();
        System.out.println("enviado");

        try {
            NetWrapper message = networkManager.receive();
            if (message.getCommand() == Command.NEXT_STATE){
                System.out.println("mudar para o verde");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

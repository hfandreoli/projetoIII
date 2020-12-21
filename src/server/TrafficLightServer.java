package server;

import common.*;
import java.io.*;
import java.net.*;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;

public class TrafficLightServer extends Thread {
    private ArrayList<ClientIdentification> activeClients;
    ServerNetworkManager networkManager;
    Scheduler scheduler;

    public static void main(String[] args) throws IOException {
        new TrafficLightServer().start();
    }

    public TrafficLightServer() throws IOException {
        this("QuoteServerThread");
    }

    public TrafficLightServer(String name) throws IOException {
        super(name);
        activeClients = new ArrayList<>();
//        scheduler = new Scheduler(activeClients);
//        scheduler.start();
    }

    public void run() {

        try {
            networkManager = new ServerNetworkManager();
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                NetWrapper message = networkManager.receive();

                if (message.getCommand() == Command.REGISTER){
                    startClient(networkManager.getSenderPort());
                    output();
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }

        networkManager.close();
    }

    private void startClient(int port) throws IOException {
        networkManager.send(new NetWrapper(Command.NEXT_STATE), port);
        activeClients.add(new ClientIdentification(port, networkManager));
    }

    private void output(){
        System.out.flush();
        for (ClientIdentification client : activeClients) {
            System.out.println(client.getPort());
            System.out.println(client.getState().getDescription());
        }
        }
}

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
    Mediator mediator;

    public static void main(String[] args) throws IOException {
        new TrafficLightServer().start();
    }

    public TrafficLightServer() throws IOException {
        this("QuoteServerThread");
    }

    public TrafficLightServer(String name) throws IOException {
        super(name);
        mediator = new Mediator();
        activeClients = new ArrayList<>();
    }

    public ServerNetworkManager getNetwork(){
        return networkManager;
    }

    public void run() {
        mediator.updateLog(activeClients);

        try {
            networkManager = new ServerNetworkManager();
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                NetWrapper message = networkManager.receive();

                if (message.getCommand() == Command.REGISTER) {
                    startClient(networkManager.getSenderPort());
                } else if (message.getCommand() == Command.FINALIZE) {
                    removeClient(networkManager.getSenderPort());
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
        activeClients.add(new ClientIdentification(port, this));
        updateLog();
    }

    private void removeClient(int port){
        for (ClientIdentification client : activeClients) {
            if (client.getPort() == port){
                client.stopTimer();
                activeClients.remove(client);
                updateLog();
                break;
            }
        }
    }

    public void updateLog() {
        mediator.updateLog(activeClients);
    }
}

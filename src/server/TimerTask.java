package server;

import common.Command;
import common.NetWrapper;

import java.io.IOException;

public class TimerTask extends java.util.TimerTask {
    ClientIdentification clientIdentification;
    ServerNetworkManager network;

    public TimerTask(ClientIdentification clientIdentification, ServerNetworkManager network){
        this.clientIdentification = clientIdentification;
        this.network = network;
    }

    @Override
    public void run() {
        clientIdentification.nextState();
        try {
            network.send(new NetWrapper(Command.NEXT_STATE), clientIdentification.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

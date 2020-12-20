package server;

import common.*;
import java.net.*;


public class ServerNetworkManager extends NetworkManager {
    public ServerNetworkManager() throws SocketException {
        socket = new DatagramSocket(SysParameters.serverPort);
    }
}

package client;

import common.*;
import java.net.*;

public class ClientNetworkManager extends NetworkManager {
    public ClientNetworkManager() throws SocketException {
        socket = new DatagramSocket();
    }
}

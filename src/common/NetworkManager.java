package common;

import java.io.*;
import java.net.*;

public class NetworkManager {
    protected DatagramSocket socket = null;
    protected int port;

    public void send(NetWrapper object, int receiverPort) throws IOException {
        byte[] buf = serialize(object);
        InetAddress address = InetAddress.getByName(SysParameters.hostName);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, receiverPort);
        socket.send(packet);
    }

    public NetWrapper receive() throws IOException, ClassNotFoundException {
        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        port = packet.getPort();
        return (NetWrapper) deserialize(packet);
    }

    public void close() {
        socket.close();
    }

    public int getSenderPort(){
        return port;
    }

    protected Object deserialize(DatagramPacket incomingPacket) throws IOException, ClassNotFoundException {
        return (new ObjectInputStream(new ByteArrayInputStream(incomingPacket.getData()))).readObject();
    }

    protected byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        (new ObjectOutputStream(byteArrayOutputStream)).writeObject(obj);
        return (byteArrayOutputStream.toByteArray());
    }
}

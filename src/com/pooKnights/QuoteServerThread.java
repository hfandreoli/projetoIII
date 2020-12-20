package com.pooKnights;

import java.io.*;
import java.net.*;
import java.util.*;

public class QuoteServerThread extends Thread {

//    protected DatagramSocket socket = null;
//    protected BufferedReader in = null;
//    protected boolean moreQuotes = true;
//
//    // construtor básico para exceção
//    public QuoteServerThread() throws IOException {
//        this("QuoteServerThread");
//    }
//
//    // construtor normal: argumento nome da thread
//    public QuoteServerThread(String name) throws
//            IOException {
//        super(name);
//        socket = new DatagramSocket(4445);
////        try {
////            in = new BufferedReader(new FileReader("oneliners.txt"));
////        } catch (FileNotFoundException e) {
////            System.err.println("Could not open quote file. Serving time instead.");
////        }
//    }
//
//    // método principal da thread (servidor)
//    public void run() {
//        // loop enquanto houver sentenças
//        while (moreQuotes) {
//            try {
//                byte[] buf = new byte[256];
//                // recebe pedido do cliente
//                DatagramPacket packet = new DatagramPacket(buf, buf.length);
//                socket.receive(packet);
//                String received = new String(packet.getData());
//                System.out.println(received);
//
//
//                buf = new byte[256];
//                // cria resposta
//                String dString = "good good";
//                buf = dString.getBytes();
//
//                // envia resposta ao client em "address" e "port”
//                // “address” e “port” obtidos na mensagem recebida
//                InetAddress address = packet.getAddress();
//                int port = packet.getPort();
//                packet = new DatagramPacket(buf, buf.length,
//                        address, port);
//                socket.send(packet);
//            } catch (IOException e) {
//                e.printStackTrace();
//                moreQuotes = false;
//            }
//        }
//        socket.close();
//    }
//
//    protected String getNextQuote() {
//        String returnValue = null;
//        try {
//            if ((returnValue = in.readLine()) == null) {
//                in.close();
//                moreQuotes = false;
//                returnValue = "No more quotes. Goodbye.";
//            }
//        } catch (IOException e) {
//            returnValue = "IOException occurred in server.";
//        }
//        return returnValue;
//    }
}

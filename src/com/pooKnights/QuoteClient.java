package com.pooKnights;

import java.io.*;
import java.net.*;
import java.util.*;

public class QuoteClient {
//    public static void main(String[] args) throws IOException {
//        // verifica 1o argumento: nome do servidor
//        String hostname = "localhost";
//
////        if (args.length != 1) {
////            System.out.println("Usage: java QuoteClient<hostname>");
////            return;
////        }
//
//
//        // cria um datagram socket
//        DatagramSocket socket = new DatagramSocket();
//        // envia pedido;
//        // nome do server é 1o argumento do programa
//        // porta é constante: 4445
//        byte[] buf = new byte[256];
//        String message = "ola";
//        buf = message.getBytes();
////        InetAddress address = InetAddress.getByName(args[0]);
//        InetAddress address = InetAddress.getByName(hostname);
//        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
//        socket.send(packet);
//
//        System.out.println("enviado");
//
//        // recebe resposta
//        // porta do cliente é passada implicitamente ao servidor
//        buf = new byte[256];
//        packet = new DatagramPacket(buf, buf.length);
//        socket.receive(packet);
//        // mostra resposta
//        String received = new String(packet.getData());
//        System.out.println("Quote of the Moment: " + received);
//        socket.close();
//    }
}


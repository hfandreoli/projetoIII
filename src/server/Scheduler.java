package server;

import java.io.IOException;
import java.util.ArrayList;

public class Scheduler extends Thread {
    private ArrayList<ClientIdentification> activeClients;

    public Scheduler() throws IOException {
        this("Scheduler");
    }

    public Scheduler(String name) throws IOException {
        super(name);
    }

    public Scheduler(ArrayList<ClientIdentification> activeClients) throws IOException {
        this("Scheduler");
        this.activeClients = activeClients;
    }

    public void update(ArrayList<ClientIdentification> activeClients) {
        this.activeClients = activeClients;
    }

    public void run() {
        output();
    }

    private void output() {
        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.flush();
            System.out.println(activeClients.size());
//            for (ClientIdentification client : activeClients) {
//                System.out.println(client.getPort());
//                System.out.println(client.getState().getDescription());
//            }
        }
    }
}

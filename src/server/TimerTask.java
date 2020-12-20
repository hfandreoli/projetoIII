package server;

public class TimerTask extends java.util.TimerTask {
    ClientIdentification clientIdentification;

    public TimerTask(ClientIdentification clientIdentification){
        this.clientIdentification = clientIdentification;
    }

    @Override
    public void run() {
        clientIdentification.nextState();
    }
}

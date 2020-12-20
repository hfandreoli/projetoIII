package common;

import java.io.Serializable;

public class NetWrapper implements Serializable {
    private Command command;

    public NetWrapper(Command command){
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}

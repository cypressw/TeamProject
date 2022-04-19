package server.exception;

public class ServerFullException extends Exception{

    public ServerFullException() {
        super("Server is full!");
    }
}

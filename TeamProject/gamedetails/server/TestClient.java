package server;

import gamedetails.Board;
import server.packet.Packet;
import server.packet.receive.ServerUpdate;
import server.packet.send.PlayerJoin;
import server.packet.send.PlayerSendBoard;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class TestClient {

    private ObjectOutputStream toServer;

    public Socket getSocket() {
        return socket;
    }

    private Socket socket;

    public boolean send(Packet p) {
        try {
            toServer.writeObject(p);
            toServer.reset();
            return true;
        }
        catch (SocketException e) {
            System.out.println("(Warning) Could not send packet because client disconnected!");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    private void connectionToServer(String adress, int port) throws IOException, InterruptedException
    {
        this.socket = new Socket(adress, port);
        toServer = new ObjectOutputStream(socket.getOutputStream());
    }

    private static class TestClientConnection {

        public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

            TestClient t = new TestClient();
            t.connectionToServer("127.0.0.1",8000);

            t.send(new PlayerJoin(new TempPlayer("s")));

            Thread.sleep(3000);

            t.send(new PlayerSendBoard(new Board()));



            ObjectInputStream inputFromClientObject = new ObjectInputStream(t.getSocket().getInputStream());


            while (true) {

                try {
                    Packet p = ((Packet)inputFromClientObject.readObject());
                    System.out.println(((ServerUpdate)p).test);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}


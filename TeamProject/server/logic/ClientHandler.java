package server.logic;


import server.TempPlayer;
import server.exception.ServerFullException;
import server.packet.Packet;
import server.packet.send.PlayerJoin;
import server.packet.send.PlayerSendBoard;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;



public class ClientHandler implements Runnable
{
    private Socket socket;
    private int clientNumber;
    private TempPlayer player;
    private JTextArea textArea;
    private Server server;

    public ObjectOutputStream getOutputToClientObject() {
        return outputToClientObject;
    }

    public void setOutputToClientObject(ObjectOutputStream outputToClientObject) {
        this.outputToClientObject = outputToClientObject;
    }

    private ObjectOutputStream outputToClientObject;



    public ClientHandler(Socket socket, int clientNumber, JTextArea textArea, Server server) {
        this.socket = socket;
        this.clientNumber = clientNumber;
        this.textArea = textArea;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream inputFromClientObject = new ObjectInputStream(socket.getInputStream());

            Packet p = ((Packet)inputFromClientObject.readObject());

            if (p instanceof PlayerJoin) {
                PlayerJoin playerJoin = ((PlayerJoin)p);
                if (server.addPlayer(playerJoin.getPlayer())) {
                    server.getClients().put(playerJoin.getPlayer(), this);
                    this.player = playerJoin.getPlayer();
                    outputToClientObject = new ObjectOutputStream(socket.getOutputStream());
                } else {
                    throw new ServerFullException();
                }
            }

            if (p instanceof PlayerSendBoard) {
                PlayerSendBoard playerSendBoard = ((PlayerSendBoard)p);

            }


            while (true) {
                this.server.update(player);
                Thread.sleep(10);
                continue;
            }


        } catch (SocketException | ServerFullException e) {
            this.player.setConnected(false);
            server.disconnect(this);

        }
        catch (EOFException e) {
            System.out.println("User disconnected");

        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public TempPlayer getPlayer() {
        return player;
    }


    public boolean disconnect(){
        try {
            this.socket.close();
        } catch (Exception e) {
            return false;
        }
        server.disconnect(this);
        textArea.append("" +this.player.getName() + " was kicked from the server");
        return true;
    }

}

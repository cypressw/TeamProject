package server.logic;


import database.Game;
import server.TempPlayer;
import server.packet.receive.ServerUpdate;
import server.presentation.ServerFrame;
import java.io.IOException;
import java.io.Serializable;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

public class Server implements Runnable, Serializable
{
    private HashMap<TempPlayer, ClientHandler> clients = new HashMap();
    private Game battleShipGame = new Game();
    private ServerFrame frame = new ServerFrame("TreacherousMUD - BootServer");
    private ArrayList<Thread> clientTheads = new ArrayList();
    private ServerSocket serverSocket;

    @Override
    public void run()
    {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy kk:mm");
        try
        {
            frame.getTextArea().append("BootServer started on " + formatter.format(new Date()));
            serverSocket = new ServerSocket(8000);
            frame.getTextArea().append("\nThe current server IP: " + Inet4Address.getLocalHost().getHostAddress()+ " with port " + serverSocket.getLocalPort());
            int clientNR = 1;
            while (true)
            {

                Socket socket = serverSocket.accept();
                frame.getTextArea().append(frame.standardClientText(socket.getInetAddress()));
                ClientHandler clientHandler = new ClientHandler(socket, clientNR, frame.getTextArea(), this);

               Thread thread = new Thread(clientHandler);
                clientTheads.add(thread);
               thread.start();
                clientNR++;



            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void disconnect(ClientHandler client) {
        client.disconnect();
        clients.remove(client.getPlayer());
    }

    public boolean addPlayer(TempPlayer p) {
        if (!battleShipGame.addPlayer(p)) {
            return false;
        }
        frame.getTextArea().append("Amount of players online: " + (clients.size() + 1));
        return true;
    }

    public void update(TempPlayer player) throws IOException {
        clients.get(player).getOutputToClientObject().writeObject(new ServerUpdate());
        clients.get(player).disconnect();
    }


    public Game getGame() {
        return battleShipGame;
    }

    public HashMap<TempPlayer, ClientHandler> getClients()
    {
        return clients;
    }

}

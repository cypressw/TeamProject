package server;

import gamedetails.Board;

import java.io.Serializable;

public class TempPlayer implements Serializable {

    public TempPlayer(String name) {
        this.name = name;
    }


    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    private boolean connected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    private Board gameBoard;






}

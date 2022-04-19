package server.packet.send;

import gamedetails.Board;
import server.packet.Packet;

public class PlayerSendBoard extends Packet {

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    private Board board;


    public PlayerSendBoard(Board board) {
        this.board = board;
    }
}

package server.packet.send;

import server.TempPlayer;
import server.packet.Packet;

public class PlayerJoin extends Packet {

    public TempPlayer getPlayer() {
        return player;
    }


    private TempPlayer player;

    public PlayerJoin(TempPlayer player) {
        this.player = player;
    }

}


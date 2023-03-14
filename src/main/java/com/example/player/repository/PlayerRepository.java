package com.example.player.repository;

import com.example.player.model.Player;
import java.util.*;

public interface PlayerRepository{

    ArrayList<Player> getPlayers();

    Player getPlayerById(int playerId);

    Player addPlayer(Player player);
    
    String addMultiplePlayers(ArrayList<Player> multiplePlayers);

    Player updatePlayer(int playerId, Player player);

    void deletePlayer(int playerId);
}
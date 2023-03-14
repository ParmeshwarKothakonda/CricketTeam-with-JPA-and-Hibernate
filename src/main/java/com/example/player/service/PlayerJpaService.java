package com.example.player.service;

import org.springframework.stereotype.Service;

import com.example.player.repository.PlayerJpaRepository;
import com.example.player.repository.PlayerRepository;
import com.example.player.model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


import java.util.*;

@Service
public class PlayerJpaService implements PlayerRepository{

    @Autowired
    private PlayerJpaRepository playerJpaRepository;


    @Override
    public ArrayList<Player> getPlayers(){
        List<Player> playerList = playerJpaRepository.findAll();
        ArrayList<Player> players = new ArrayList<>(playerList);

        return players;
    }

    @Override 
    public Player addPlayer(Player player){
        playerJpaRepository.save(player);
        return player;
    }
    
    @Override
    
    public String addMultiplePlayers(ArrayList<Player> multiplePlayers){
    	int count = multiplePlayers.size();
    	for(Player eachPlayer : multiplePlayers) {
    		playerJpaRepository.save(eachPlayer);
    	}
    	
    	String returnMessage = String.format("Successfully added %d players", count);
    	return returnMessage;
    }

    @Override 
    public Player getPlayerById(int playerId){
        try{
            Player player = playerJpaRepository.findById(playerId).get();
            return player;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public Player updatePlayer(int playerId, Player player){
        try{
            Player existingPlayer = playerJpaRepository.findById(playerId).get();

            if(player.getPlayerName() != null){
                existingPlayer.setPlayerName(player.getPlayerName());
            }
            if((Integer) player.getJerseyNumber() != null){
                existingPlayer.setJerseyNumber(player.getJerseyNumber());
            }

            if(player.getRole() != null){
                existingPlayer.setRole(player.getRole());
            }

            playerJpaRepository.save(existingPlayer);
            return existingPlayer;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public void deletePlayer(int playerId){
        try{
            playerJpaRepository.deleteById(playerId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
}
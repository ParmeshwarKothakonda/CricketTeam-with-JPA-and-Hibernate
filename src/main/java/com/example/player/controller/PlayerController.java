package com.example.player.controller;

import java.util.*;
import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class PlayerController{
    @Autowired
    private PlayerJpaService playerJpaService;


    @GetMapping("/players")
    public ArrayList<Player> getPlayers(){
        return playerJpaService.getPlayers();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerJpaService.addPlayer(player);
    }
    
    @PostMapping("/players/bulk")
    public String addMultiplePlayers(@RequestBody ArrayList<Player> multiplePlayers){
    	return playerJpaService.addMultiplePlayers(multiplePlayers);
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId){
        return playerJpaService.getPlayerById(playerId);
    }
    
    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player){
        return playerJpaService.updatePlayer(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        playerJpaService.deletePlayer(playerId);
    }
}
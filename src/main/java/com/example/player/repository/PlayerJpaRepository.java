package com.example.player.repository;

import org.springframework.stereotype.Repository;
import com.example.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository; //Importing JPA Repository

@Repository
public interface PlayerJpaRepository extends JpaRepository<Player,Integer> {

}
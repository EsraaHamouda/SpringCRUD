package com.tags.task.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PlayerService {


    private List<Player> playersList = new ArrayList<>();

    @Autowired(required = true)
    private PlayerRepository playerRepository;


    public String savePlayerToDB(Player player) {
        playerRepository.save(player);
        return player.getName() + " is created Successfully";
    }

    public String updatePlayerToDB(Player player) {
        playerRepository.save(player);
        return player.getName() + " is updated Successfully";

    }

    public String deletePlayerToDB(int id) {
        Player playerTodelete = getPlayerByRepo(id);
        playerRepository.deleteById(id);
        return playerTodelete .getName() + " is deleted Successfully";

    }

    public Player getPlayerByRepo(int id) {
        Optional<Player> instace = playerRepository.findById(id);
        return instace.orElse(null);
    }

    public List<Player> getAllPlayersByRepo() {
        Iterable<Player> x = playerRepository.findAll();
        x.forEach(playersList::add);
        return playersList;
    }















  /*  @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }*/

    public PlayerService() {
        playersList.add(new Player(1, "Ahmed"));
        playersList.add(new Player(2, "Ali"));
        playersList.add(new Player(3, "Karim"));

        System.out.println("Service layer is created");
    }
/*
    public List<Player> getAllPlayers() {
        return playersList;
    }

    public Player getPlayer(int id) {
        return playersList.stream()
                .filter(p -> id == p.getID())
                .findAny()
                .orElse(null);
    }

    public String savePlayer(Player player) {
        if (player != null) {
            playersList.add(player);
        }
        return "Player is saved successfully";
    }

    public String updatePlayer(Player player) {
        if (player != null) {
            playersList.removeIf(p -> p.getID() == player.getID());
            playersList.add(player);
        }
        return "Player is updated successfully";
    }

    public String deletePlayer(int player) {

        playersList.removeIf(p -> p.getID() == player);

        return "Player is deleted successfully";
    }*/
}

package com.tags.task.player;


import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
public class PlayerController {


    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/playere/{}") //http://localhost:8080/player?playerID=1234
    public Player getPlayerM1(@PathVariable int ID) {
        return playerService.getPlayerByRepo(ID);
    }





    //http://localhost:8080/player/M3/3
    @GetMapping(value = "/player/M3")
    public Player getPlayer(@RequestParam("playerID") String id) {
        System.out.println("IDDDDDDDDDDDDD =" + id);
        return playerService.getPlayerByRepo(Integer.parseInt(id));
    }
///////////////////////////////////////DEV////////////////////////////////////////////////




    //////////////////////////////////////////////Working well ///////////////////////////////////
    @GetMapping(path="/player/{id}")
    public Player getPlayerTest1(@PathVariable("id") String id) {
        return playerService.getPlayerByRepo(Integer.parseInt(id));

    }


    @GetMapping(path="/player/{name}/{age}")
    public String getMessage(@PathVariable("name") String name,
                             @PathVariable("age") String age) {

        String msg = String.format("%s is %s years old", name, age);

        return msg;
    }

    @RequestMapping(value = "/")
    @ResponseBody
    public String defaultUrl() {
        return "Please specify a url";
    }

    @RequestMapping(value = "/message")
    @ResponseBody
    public String getMessage() {
        return "Hi there :) ";
    }

    @GetMapping(value = "/players")
    public List<Player> getPlayers() {
        return playerService.getAllPlayersByRepo();
    }

    @PostMapping(value = "/player")
    public String createNewPlayer(@RequestBody Player player) {

        return playerService.savePlayerToDB(player);
    }

    @PutMapping(value = "/player")
    public String updatePlayer(@RequestBody Player player) {

        return playerService.updatePlayerToDB(player);
    }

    @DeleteMapping(value = "/player") //http://localhost:8080/player?playerID=1234
    public String deletePlayer(@RequestParam("playerID") int playerID) {
        return playerService.deletePlayerToDB(playerID);

    }
    @GetMapping(value = "/player") //http://localhost:8080/player?playerID=1234
    public Player deletePlayer(@RequestParam("playerID") String playerID) {
        return playerService.getPlayerByRepo(Integer.parseInt(playerID));

    }
}

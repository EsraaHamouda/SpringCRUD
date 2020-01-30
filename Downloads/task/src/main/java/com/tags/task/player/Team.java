package com.tags.task.player;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @Column(name = "team_ID")
    private int ID;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "myTeam")
    private List<Player> teamPlayers = new ArrayList<>();
    public Team() {
    }

    public Team(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

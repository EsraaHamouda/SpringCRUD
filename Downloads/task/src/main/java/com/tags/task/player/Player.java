package com.tags.task.player;


import javax.persistence.*;

@Entity
public class Player {

    @Id
    @Column(name = "id")
    private int ID;
    @Column(name = "name")
    private String name;

    @ManyToOne
     @JoinColumn(name="team_ID")
    private Team myTeam;


    public Player() {
    }

    public Player(int ID, String name) {
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

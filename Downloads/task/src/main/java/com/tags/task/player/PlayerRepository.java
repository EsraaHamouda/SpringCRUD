package com.tags.task.player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {



}
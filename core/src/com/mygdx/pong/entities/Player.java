package com.mygdx.pong.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Player {
    private int score = 0;
    private String name;

    public Player(String name) {
        this.name = name;
    }
}

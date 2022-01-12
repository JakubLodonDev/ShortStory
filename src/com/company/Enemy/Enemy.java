package com.company.Enemy;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Enemy {
    String Name;
    int Level;
    int Health;
    int Damage;
    int ChanceToDodge;

    private final int MaxPercentToDodge = 100;

    public Enemy(String name, int level, int health, int damage, int chanceToDodge) {
        Name = name;
        Level = level;
        Health = health;
        Damage = damage;
        ChanceToDodge = chanceToDodge;
    }

    public boolean TryDodge() {
        Random dodgeRand = new Random();
        int canDodge = dodgeRand.nextInt(MaxPercentToDodge);
        if(ChanceToDodge<canDodge){
            return false;
        }
        return true;
    }
}

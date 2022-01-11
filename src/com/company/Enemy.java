package com.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Enemy {
    String Name;
    int Level;
    int Health;
    int Damage;
    int Dodge;

    public Enemy(String name, int level, int health, int damage, int dodge) {
        Name = name;
        Level = level;
        Health = health;
        Damage = damage;
        Dodge = dodge;
    }
}

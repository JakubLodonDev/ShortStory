package com.company;

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

    public String getName() {
        return Name;
    }

    public int getLevel() {
        return Level;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getDamage() {
        return Damage;
    }

    public int getDodge() {
        return Dodge;
    }

}

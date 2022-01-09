package com.company;

public class Hero {
    String Name;
    int Level;
    int Health;
    int Damage;
    int Dodge;

    public Hero(String name,int level, int health, int damage, int dodge) {
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

    public void setLevel(int level) {
        Level = level;
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

    public void setDamage(int damage) {
        Damage = damage;
    }

    public int getDodge() {
        return Dodge;
    }

    public void setDodge(int dodge) {
        Dodge = dodge;
    }
}

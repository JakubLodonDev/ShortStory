package com.company;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public abstract class Hero {
    private int InitialHealth;

    @Getter @Setter String Name;
    @Getter @Setter int Level;
    @Getter @Setter int Health;
    @Getter @Setter int Damage;
    @Getter @Setter int Dodge;

    /*public Hero(String name,int level, int health, int damage, int dodge) {
        Name = name;
        Level = level;
        Health = health;
        Damage = damage;
        Dodge = dodge;

        InitialHealth = health;
    }*/
    void SaveStats(int gameLevel){
        setLevel(gameLevel);
        InitialHealth = getHealth();
        setDamage(getDamage());
        setDodge(getDodge());
    }

    public void HealToMaxHealth(){
        Health = InitialHealth;
    }
}

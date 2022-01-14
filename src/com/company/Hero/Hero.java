package com.company.Hero;

import com.company.Enemy.Enemy;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;


public abstract class Hero {
    int InitialHealth;

    @Getter @Setter String Name;
    @Getter int Level;
    @Getter @Setter int Health;
    @Getter @Setter int Damage;
    @Getter int ChanceToDodge;
    @Getter @Setter int Experience;

    private int LevelMultiplier = 1;
    private int BaseNumberOfLevelUp = 100;

    private final int MaxPercentToDodge = 100;

    public Hero(String name,int level, int health, int damage, int chanceToDodge, int experience) {
        Name = name;
        Level = level;
        Health = health;
        Damage = damage;
        ChanceToDodge = chanceToDodge;
        Experience = experience;

        InitialHealth = health;
    }

    public void HealToMaxHealth(){
        Health = InitialHealth;
    }

    public void IncreaseMaxHealth(int value) {
        InitialHealth = InitialHealth + value;
    }

    public void IncreaseDamage(int value) {
        Damage = Damage + value;
    }

    public void IncreaseDodge(int value) {
        ChanceToDodge = ChanceToDodge + value;
    }

    public boolean TryDodge() {
        Random dodgeRand = new Random();
        int canDodge = dodgeRand.nextInt(MaxPercentToDodge);
        if(ChanceToDodge<canDodge){
            return false;
        }
        return true;
    }

    public void AddExperience(int experience) {
        Experience = Experience + experience;
        if(EnoughToLevelUp()){
            Experience = Experience-BaseNumberOfLevelUp*LevelMultiplier;
            LevelMultiplier++;
            Level++;
            HealToMaxHealth();
        }
    }

    private boolean EnoughToLevelUp() {
        if(Experience>=BaseNumberOfLevelUp*LevelMultiplier){
            return true;
        }
        return false;
    }

    public String toString() {
        return "Hero(InitialHealth=" + this.InitialHealth + ", Name=" + this.Name
                + ", Level=" + this.Level + ", Health=" + this.Health + ", Damage="
                + this.Damage + ", ChanceToDodge=" + this.ChanceToDodge + ", Experience=" + this.Experience + ")";
    }
}

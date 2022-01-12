package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Gameplay {
    private final int baseNumberOfEnemies = 2;
    RandomEnemyGetter randomEnemyGetter;

    public Gameplay() {
        randomEnemyGetter= new RandomEnemyGetter();
    }

    boolean StartGame(Hero hero, int gameLevel) {
        boolean levelResult = true;
        hero.setLevel(gameLevel);
        hero.SaveStats(gameLevel);
        //Hero hero = new Hero("Archer",0,150,30,15);

        int numberOfEnemys = GetNumberOfEnemies(hero);

        ArrayList<Enemy>currentEnemiesOnTheLevel = randomEnemyGetter.Get(hero.getLevel(), numberOfEnemys);

        FightsOnLevel fightsOnLevel = new FightsOnLevel();

        boolean fightsresult = fightsOnLevel.Fights(currentEnemiesOnTheLevel,hero);

        if(fightsresult) {
            System.out.println("Win");
            hero.HealToMaxHealth();
        }
        else {
            System.out.println("Loss");
            System.out.println(hero.toString());
        }

        return levelResult;

    }

    private int GetNumberOfEnemies(Hero hero) {
        Random rand = new Random();
        int numberOfEnemys = rand.nextInt(3+ hero.getLevel())+baseNumberOfEnemies;
        return numberOfEnemys;
    }
}

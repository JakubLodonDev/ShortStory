package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Gameplay {
    private final int baseNumberOfEnemies = 2;
    RandomEnemyGetter randomEnemyGetter;

    public Gameplay() {
        randomEnemyGetter= new RandomEnemyGetter();
    }

    boolean Game(Hero hero) {
        boolean levelResult = true;
        //Hero hero = new Hero("Archer",0,150,30,15);

        int numberOfEnemys = GetNumberOfEnemies(hero);

        ArrayList<Enemy>currentEnemiesOnTheLevel = randomEnemyGetter.Get(hero.getLevel(), numberOfEnemys);

        FightsOnLevel fightsOnLevel = new FightsOnLevel();

        boolean fightsresult = fightsOnLevel.Fights(currentEnemiesOnTheLevel,hero);

        if(fightsresult) {
            System.out.printf("Win");
            hero.HealToMaxHealth();
        }

        return levelResult;

    }

    private int GetNumberOfEnemies(Hero hero) {
        Random rand = new Random();
        int numberOfEnemys = rand.nextInt(4+ hero.getLevel())+baseNumberOfEnemies;
        return numberOfEnemys;
    }
}

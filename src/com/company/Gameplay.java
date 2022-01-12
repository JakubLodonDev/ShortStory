package com.company;

import com.company.Enemy.Enemy;
import com.company.Hero.Hero;

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

        int numberOfEnemies = GetNumberOfEnemies(hero);

        ArrayList<Enemy>currentEnemiesOnTheLevel = randomEnemyGetter.Get(hero.getLevel(), numberOfEnemies);

        FightsOnLevel fightsOnLevel = new FightsOnLevel();
        levelResult = fightsOnLevel.Fights(currentEnemiesOnTheLevel,hero);


        return levelResult;
    }

    private int GetNumberOfEnemies(Hero hero) {
        Random rand = new Random();
        int numberOfEnemys = rand.nextInt(3+ hero.getLevel())+baseNumberOfEnemies;
        return numberOfEnemys;
    }
}

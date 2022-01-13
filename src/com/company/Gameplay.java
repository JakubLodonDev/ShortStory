package com.company;

import com.company.Enemy.Enemy;
import com.company.Enemy.RandomEnemyGetter;
import com.company.Hero.Hero;

import java.util.ArrayList;
import java.util.Random;

public class Gameplay {
    private final int baseNumberOfEnemies = 2;
    RandomEnemyGetter randomEnemyGetter;

    public Gameplay() {
        randomEnemyGetter= new RandomEnemyGetter();
    }

    FightResult StartGame(Hero hero, int gameLevel) {
        boolean levelResult = true;

        int numberOfEnemies = GetNumberOfEnemies(hero);

        ArrayList<Enemy>currentEnemiesOnTheLevel = randomEnemyGetter.Get(hero.getLevel(), numberOfEnemies);

        FightsOnLevel fightsOnLevel = new FightsOnLevel();
        FightResult fightResult = fightsOnLevel.Fight(currentEnemiesOnTheLevel,hero);
        if(fightResult.LevelCompleted) {
            fightResult.CourseOfTheBattles.add(new BattleHistory("Win"));
        } else {
            fightResult.CourseOfTheBattles.add(new BattleHistory("Loss"));
        }


        return fightResult;
    }

    private int GetNumberOfEnemies(Hero hero) {
        Random rand = new Random();
        int numberOfEnemys = rand.nextInt(3+ hero.getLevel())+baseNumberOfEnemies;
        return numberOfEnemys;
    }
}

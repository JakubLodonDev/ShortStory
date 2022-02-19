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
        randomEnemyGetter = new RandomEnemyGetter();
    }


    FightResult StartGame(Hero hero, int gameLevel) {
        if(hero == null){
            throw new NullPointerException("Parameter 'hero' cannot be null");
        }

        if(gameLevel < 0){
            throw new IllegalArgumentException("Parameter 'gameLevel' cannot be < 0");
        }

        int numberOfEnemies = GetNumberOfEnemies(hero);

        ArrayList<Enemy>currentEnemiesOnTheLevel = randomEnemyGetter.Get(hero.getLevel(), numberOfEnemies);

        FightsOnLevel fightsOnLevel = new FightsOnLevel();
        FightResult fightResult = fightsOnLevel.Fight(currentEnemiesOnTheLevel,hero);

        if(fightResult.LevelCompleted) {
            fightResult.AddHistory(new BattleHistory("Congratulations, you climbed the floor " + gameLevel));
        } else {
            fightResult.AddHistory(new BattleHistory("You have been defeated, start over and maybe you will succeed"));
        }

        return fightResult;
    }

    private int GetNumberOfEnemies(Hero hero) {
        Random rand = new Random();
        return rand.nextInt(3+ hero.getLevel())+baseNumberOfEnemies;
    }
}

package com.company;

import com.company.Enemy.Enemy;
import com.company.Enemy.EnemyInfo;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomEnemyGetter{
    ArrayList<EnemyInfo> enemyInfoList;

    public RandomEnemyGetter() {
        this.enemyInfoList = new ArrayList<EnemyInfo>();
        enemyInfoList.add( new EnemyInfo("Goblin", 0));
        enemyInfoList.add( new EnemyInfo("Skeleton", 0));
        enemyInfoList.add( new EnemyInfo("Bird", 1));
    }

    public ArrayList<Enemy> Get(int level, int numberOfEnemies){
        ArrayList<Enemy> enemies = new ArrayList<>();
        var listOfEnemiesOnTheLevel = enemyInfoList.stream()
                .filter(enemyInfo -> enemyInfo.Level <= level).collect(Collectors.toList());

        Random rand = new Random();
        for(int i = 0; i<numberOfEnemies; i++) {
            int randEnemy = rand.nextInt(listOfEnemiesOnTheLevel.size());
            var selectedEnemy = Create(listOfEnemiesOnTheLevel.get(randEnemy).Name);
            enemies.add(selectedEnemy);
        }
        return enemies;
    }

    private Enemy Create(String type){
        switch (type){
            case "Goblin":
                return new Enemy("Goblin",0,50,10,2);
            case "Skeleton":
                return new Enemy("Wolf",0,45,15,2);
            case "Bird":
                return new Enemy("Assasyn",1,40,25,4);
            default:
                throw new UnsupportedOperationException();
        }
    }
}

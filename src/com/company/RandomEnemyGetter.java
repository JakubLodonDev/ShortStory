package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomEnemyGetter{
    ArrayList<EnemyInfo> enemyInfo;

    public RandomEnemyGetter() {
        this.enemyInfo = new ArrayList<EnemyInfo>();
        enemyInfo.add( new EnemyInfo("Goblin", 0));
        enemyInfo.add( new EnemyInfo("Skeleton", 0));
        enemyInfo.add( new EnemyInfo("Bird", 1));
    }

    public ArrayList<Enemy> Get(int level, int numberOfEnemies){
        ArrayList<Enemy> enemies = new ArrayList<>();
        ArrayList<EnemyInfo> listOfEnemiesOnTheLevel = new ArrayList<>(); //Where (x=> x.Level <= level)
        int j = 0;
        //listOfEnemiesOnTheLevel.stream().filter(e-> level >= e.level).forEach(listOfEnemiesOnTheLevel.add());
        for (EnemyInfo e : enemyInfo) {
            if (level >= enemyInfo.get(j).level) {
                listOfEnemiesOnTheLevel.add(enemyInfo.get(j));
            }
            j++;
        }

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
                return new Enemy("Skeleton",0,45,15,2);
            case "Bird":
                return new Enemy("Bird",1,150,30,15);
            default:
                throw new UnsupportedOperationException();
        }
    }
}

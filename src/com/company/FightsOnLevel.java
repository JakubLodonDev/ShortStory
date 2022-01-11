package com.company;

import java.util.ArrayList;

public class FightsOnLevel {

    public FightsOnLevel() {
    }

    public boolean Fights(ArrayList<Enemy> currentEnemiesOnTheLevel, Hero hero) {
        boolean fightsresult = true;

        for (Enemy enemy: currentEnemiesOnTheLevel) {

            StartBattle(enemy ,hero);

            if(hero.getHealth()<0){
                fightsresult = false;
                break;
            }
        }
        return fightsresult;
    }

    public void StartBattle(Enemy enemy, Hero hero) {

        var battleNotFinished = true;

        while (battleNotFinished) {
            hero.setHealth(hero.getHealth()-enemy.getDamage());
            //System.out.println("Hero have "+hero.getHealth()+" HP");

            if(hero.getHealth()<0) {
                battleNotFinished = false;
            }
            else{
                enemy.setHealth(enemy.getHealth()-hero.getDamage());
                //System.out.println(currentEnemy.getName()+" have "+currentEnemy.getHealth()+" HP");

                if(enemy.getHealth()<0) {
                    battleNotFinished = false;
                }
            }
        }
    }


    /*
       while (hero.getHealth()>0 || currentEnemy.getHealth()>0) {
                hero.setHealth(hero.getHealth()-currentEnemy.getDamage());
                //System.out.println("Hero have "+hero.getHealth()+" HP");

                if(hero.getHealth()<0) {
                    return fightsresult=false;
                }

                currentEnemy.setHealth(currentEnemy.getHealth()-hero.getDamage());
                //System.out.println(currentEnemy.getName()+" have "+currentEnemy.getHealth()+" HP");
                if(currentEnemy.getHealth()<0) {
                    break;
                }
            }
     */
}

package com.company;

import java.util.ArrayList;

public class FightsOnLevel {
    public FightsOnLevel() {
    }

    public boolean Fights(ArrayList<Enemy> currentEnemiesOnTheLevel, Hero hero) {
        boolean fightsresult = true;

        //do foreach
        for (int i = 0; i<currentEnemiesOnTheLevel.size();i++) {
            var currentEnemy = currentEnemiesOnTheLevel.get(i);

            StartBattle(currentEnemiesOnTheLevel ,hero, i);

            if(hero.getHealth()<0){
                fightsresult = false;
                break;
            }
        }

        return fightsresult;
    }
    public void StartBattle(ArrayList<Enemy> currentEnemiesOnTheLevel,Hero hero, int i) {

        var battleNotFinished = true;

        var currentEnemy = currentEnemiesOnTheLevel.get(i);
        while (battleNotFinished) {
            hero.setHealth(hero.getHealth()-currentEnemy.getDamage());
            //System.out.println("Hero have "+hero.getHealth()+" HP");

            if(hero.getHealth()<0) {
                battleNotFinished = false;
            }
            else{
                currentEnemy.setHealth(currentEnemy.getHealth()-hero.getDamage());
                //System.out.println(currentEnemy.getName()+" have "+currentEnemy.getHealth()+" HP");

                if(currentEnemy.getHealth()<0) {
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

package com.company;

import com.company.Enemy.Enemy;
import com.company.Hero.Hero;

import java.util.ArrayList;

public class FightsOnLevel {
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

    private void StartBattle(Enemy enemy, Hero hero) {
        var battleNotFinished = true;

        while (battleNotFinished) {
            if(!hero.TryDodge()) {
                hero.setHealth(hero.getHealth()-enemy.getDamage());
                System.out.println("Enemy dealt "+enemy.getDamage()+" damage | " +hero.getName()+" have "+ hero.getHealth()+" HP");
            } else {
                System.out.println(hero.getName()+" DODGE!!!!!");
            }


            if(hero.getHealth()<0) {
                battleNotFinished = false;
            }
            else{
                if(!enemy.TryDodge()) {
                    enemy.setHealth(enemy.getHealth()-hero.getDamage());
                    System.out.println("Hero dealt "+hero.getDamage()+" damage | " +enemy.getName()+" have "+ enemy.getHealth()+" HP");
                } else {
                    System.out.println(enemy.getName()+" DODGE!!!!!");
                }

                if(enemy.getHealth()<0) {
                    battleNotFinished = false;
                }
            }
        }
        System.out.println("--------------------------------");
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

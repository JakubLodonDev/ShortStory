package com.company;

import com.company.Enemy.Enemy;
import com.company.Hero.Hero;

import java.util.ArrayList;

public class FightsOnLevel {


    public FightResult Fight(ArrayList<Enemy> currentEnemiesOnTheLevel, Hero hero) {
        boolean fightCompleted = true;

        ArrayList<BattleHistory> courseOfTheBattles = new ArrayList<>();

        for (Enemy enemy: currentEnemiesOnTheLevel) {
            StartBattle(enemy ,hero, courseOfTheBattles);

            if(hero.getHealth()<0){
                fightCompleted = false;
                break;
            }
        }
        FightResult fightResult = new FightResult(fightCompleted, courseOfTheBattles);


        return fightResult;
    }


    public ArrayList<BattleHistory> StartBattle(Enemy enemy, Hero hero, ArrayList<BattleHistory> courseOfTheBattles) {
        var battleNotFinished = true;

        while (battleNotFinished) {
            if(!hero.TryDodge()) {
                hero.setHealth(hero.getHealth()-enemy.getDamage());
                courseOfTheBattles.add(new BattleHistory("Enemy dealt "+enemy.getDamage()+" damage | " +hero.getName()+" have "+ hero.getHealth()+" HP"));
            } else {
                courseOfTheBattles.add(new BattleHistory(hero.getName()+" DODGE!!!!!"));
            }


            if(hero.getHealth()<0) {
                battleNotFinished = false;
            }
            else{
                if(!enemy.TryDodge()) {
                    enemy.setHealth(enemy.getHealth()-hero.getDamage());
                    courseOfTheBattles.add(new BattleHistory("Hero dealt "+hero.getDamage()+" damage | " +enemy.getName()+" have "+ enemy.getHealth()+" HP"));
                } else {
                    courseOfTheBattles.add(new BattleHistory(enemy.getName()+" DODGE!!!!!"));
                }

                if(enemy.getHealth()<0) {
                    battleNotFinished = false;
                }
            }
        }
        courseOfTheBattles.add(new BattleHistory("--------------------------------"));
        return courseOfTheBattles;
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

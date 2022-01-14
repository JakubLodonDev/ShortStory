package com.company;

import com.company.Enemy.Enemy;
import com.company.Hero.Hero;

import java.util.ArrayList;

public class FightsOnLevel {
    public FightResult Fight(ArrayList<Enemy> currentEnemiesOnTheLevel, Hero hero) {
        boolean fightCompleted = true;

        var battleHistory = new ArrayList<BattleHistory>();
        for (Enemy enemy: currentEnemiesOnTheLevel) {
            var singleBattleHistory = StartBattle(enemy ,hero);
            battleHistory.addAll(singleBattleHistory);

            if(hero.getHealth()<0){
                fightCompleted = false;
                break;
            }
        }

        return new FightResult(fightCompleted, battleHistory);
    }

    private ArrayList<BattleHistory> StartBattle(Enemy enemy, Hero hero) {
        var battleHistory = new ArrayList<BattleHistory>();

        var battleNotFinished = true;

        while (battleNotFinished) {
            if(!hero.TryDodge()) {
                hero.setHealth(hero.getHealth()-enemy.getDamage());
                battleHistory.add(new BattleHistory("Enemy dealt "+enemy.getDamage()+" damage | " +hero.getName()+" have "+ hero.getHealth()+" HP"));
            } else {
                battleHistory.add(new BattleHistory(hero.getName()+" DODGE!!!!!"));
            }

            if(hero.getHealth()<0) {
                battleNotFinished = false;
            }
            else{
                if(!enemy.TryDodge()) {
                    enemy.setHealth(enemy.getHealth()-hero.getDamage());

                    battleHistory.add(new BattleHistory("Hero dealt "+hero.getDamage()+" damage | " +enemy.getName()+" have "+ enemy.getHealth()+" HP"));
                } else {
                    battleHistory.add(new BattleHistory(enemy.getName()+" DODGE!!!!!"));
                }

                if(enemy.getHealth()<0) {
                    battleNotFinished = false;
                    hero.AddExperience(enemy.getExperienceForKill());
                }
            }
        }

        battleHistory.add(new BattleHistory("---------------BATTLE WITH ENEMY ENDS-----------------"));
        return battleHistory;
    }
}

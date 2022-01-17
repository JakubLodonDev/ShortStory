package com.company;

import com.company.Hero.Hero;
import com.company.Hero.HeroFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner typeSomething = new Scanner(System.in);

        Hero hero;

        HeroFactory heroFactory = new HeroFactory();
        System.out.println("Chosse your hero:\nWarrior: 200 HP, 20 DMG, 0 DODGE\n" +
                "Archer: 150 HP, 30 DMG, 15 DODGE\nNinja: 100 HP, 40 DMG, 30 DODGE");
        do {
            String chooseHero = typeSomething.next();
            hero = heroFactory.createHero(chooseHero.toLowerCase());
        }while (hero==null);


        Gameplay gameplay = new Gameplay();
        StatsIncreaser statsIncreaser = new StatsIncreaser();
        int gameLevel = 0;

        FightResult fightResult = new FightResult(true);

        while(fightResult.LevelCompleted) {
            var levelBeforeFight = hero.getLevel();
            fightResult = gameplay.StartGame(hero, gameLevel);

            if(fightResult.LevelCompleted){
                boolean levelUpStats = false;

                for (BattleHistory battleHistory : fightResult.GetReadOnlyHistory()) {
                    System.out.println(battleHistory.Action);
                }

                var numberOfStatsUp = hero.getLevel() - levelBeforeFight;

                while (!levelUpStats || numberOfStatsUp != 0){
                    String increaseOneStat = typeSomething.next();
                    levelUpStats = statsIncreaser.StatsUp(hero, increaseOneStat);
                    if(levelUpStats) {
                        numberOfStatsUp--;
                        gameLevel++;
                    }
                }
                hero.HealToMaxHealth();
            }

            System.out.println(hero.toString());
        }
    }
}

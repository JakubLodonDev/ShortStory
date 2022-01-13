package com.company;

import com.company.Hero.Hero;
import com.company.Hero.HeroFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HeroFactory heroFactory = new HeroFactory();
        String chooseHero = scanner.next();
        Hero hero = heroFactory.createHero(chooseHero.toLowerCase());

        Gameplay gameplay = new Gameplay();
        StatsIncreaser statsIncreaser = new StatsIncreaser();
        int gameLevel = 0;

        FightResult fightResult = new FightResult(true);


        while(fightResult.LevelCompleted) {
            fightResult = gameplay.StartGame(hero, gameLevel);

            if(fightResult.LevelCompleted){
                boolean levelUpStats = false;

                for (BattleHistory battleHistory : fightResult.CourseOfTheBattles) {
                    System.out.println(battleHistory.Action);
                }

                hero.UpLevel();

                while (!levelUpStats){
                    String increaseOneStat = scanner.next();
                    levelUpStats = statsIncreaser.StatsUp(hero, increaseOneStat);
                    gameLevel++;
                }

                hero.HealToMaxHealth();
            }

            System.out.println(hero.toString());
        }
    }
}

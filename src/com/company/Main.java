package com.company;

import com.company.Hero.Hero;
import com.company.Hero.HeroFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HeroFactory heroFactory = new HeroFactory();
        String chosseHero = scanner.next();
        Hero hero = heroFactory.createHero(chosseHero.toLowerCase());

        Gameplay gameplay = new Gameplay();
        StatsIncrease statsIncrease = new StatsIncrease();
        int gameLevel = 0;

        var levelCompleted = true;

        while(levelCompleted) {
            levelCompleted = gameplay.StartGame(hero, gameLevel);

            if(levelCompleted){
                System.out.println("Win");
                boolean levelUpStats = false;
                hero.UpLevel();

                while (!levelUpStats){
                    String increaseOneStat = scanner.next();
                    levelUpStats = statsIncrease.StatsUp(hero, increaseOneStat);
                    gameLevel++;
                }

                hero.HealToMaxHealth();
            } else {
                System.out.println("Loss");
            }

            System.out.println(hero.toString());
        }
    }
}

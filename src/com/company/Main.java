package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Hero hero = new Hero("Archer",0,150,30,15);
        Scanner scanner = new Scanner(System.in);

        HeroFactory heroFactory = new HeroFactory();
        String chosseHero = scanner.next();
        Hero hero = heroFactory.createHero(chosseHero);

        Gameplay gameplay = new Gameplay();
        StatsIncrease statsIncrease = new StatsIncrease();
        int gameLevel = 0;
        var levelCompleted = true;

        while(levelCompleted) {
            levelCompleted = gameplay.StartGame(hero, gameLevel);

            boolean levelUpStsts = false;

            while (!levelUpStsts){
                String increaseOneStat = scanner.next();
                levelUpStsts = statsIncrease.StatsUp(hero, increaseOneStat);
                gameLevel++;
            }
            hero.SaveStats(gameLevel);

            System.out.println(hero.toString());
        }
    }
}

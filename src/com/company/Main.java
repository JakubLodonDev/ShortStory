package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hero hero = new Hero("Archer",0,150,30,15);

        Gameplay gameplay = new Gameplay();
        StatsIncrease statsIncrease = new StatsIncrease();
        int level = 0;

        var levelCompleted = gameplay.Game(hero); //gameplay.Game(level);

        Scanner scanner = new Scanner(System.in);
        boolean levelUpStsts = false;

        while (!levelUpStsts){
            String increaseOneStat = scanner.next();
            levelUpStsts = statsIncrease.StatsUp(hero, increaseOneStat);
        }
        System.out.println(hero.toString());
    }
}

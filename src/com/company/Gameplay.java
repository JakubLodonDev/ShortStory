package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Gameplay {
    private final int baseNumberOfEnemies = 2;

    ArrayList<Enemy> Enemies;

    public Gameplay() {

        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Goblin",0,50,10,2));
        enemies.add(new Enemy("Skeleton",0,45,15,2));
        enemies.add(new Enemy("Bird",1,150,30,15));

        Enemies = enemies;
    }

    private ArrayList<Enemy> GetRandomEnemies(int numberOfEnemies){
        //
    }

    boolean Game() {
        Hero hero = new Hero("Archer",0,150,30,15);

        Random rand = new Random();
        int numberOfEnemys = rand.nextInt(4+hero.getLevel())+baseNumberOfEnemies; //GetNumberOfEnemies()
        ArrayList<Enemy> currentEnemysOnTheLevel = new ArrayList<>();

        while(hero.getHealth()>0) {
            int j = 0;
            // Zrób wszystkich wrogów
            for (Enemy e : Enemies) {
                if (hero.getLevel() >= Enemies.get(j).getLevel()) {
                    currentEnemysOnTheLevel.add(Enemies.get(j));
                }
                j++;
            }
            //Tu juz mam gotowych wrogów



            //Tutaj z nimi walcze
            for (int i = 0; i < numberOfEnemys; i++) {

                int randYourEnemy = rand.nextInt(currentEnemysOnTheLevel.size());
                var currentEnemy = currentEnemysOnTheLevel.get(randYourEnemy);

                int maxHealthCurrentEnemy = currentEnemy.getHealth();
                int maxHealthHero = hero.getHealth();

                System.out.println("Yours " + (i + 1) + " enemy is " +
                        currentEnemy.getName());
                while (hero.getHealth()>0 || currentEnemy.getHealth()>0) {
                    hero.setHealth(hero.getHealth()-currentEnemy.getDamage());
                    System.out.println("Your health is "+hero.getHealth());

                    if(hero.getHealth()<0) {
                        System.out.println("U loss");
                        break;
                    }

                    currentEnemy.setHealth(currentEnemy.getHealth()- hero.getDamage());
                    System.out.println(currentEnemy.getName()+" health is "+currentEnemy.getHealth());

                    if(currentEnemy.getHealth()<0) {
                        currentEnemy.setHealth(0);
                        currentEnemy.setHealth(maxHealthCurrentEnemy);
                        System.out.println("U win");
                        break;
                    }
                }
                if(hero.getHealth()<0) {
                    break;
                }
            }
        }
    }
}

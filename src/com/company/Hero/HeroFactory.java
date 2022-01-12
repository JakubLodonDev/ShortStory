package com.company.Hero;

public class HeroFactory{

    public Hero createHero(String type) {
        Hero hero = null;

        if (type.equals("archer")) {
            hero = new Archer();
        } else if (type.equals("warrior")) {
            hero = new Warrior();
        }

        return hero;
    }

}

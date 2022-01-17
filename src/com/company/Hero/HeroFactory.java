package com.company.Hero;

public class HeroFactory{

    public Hero createHero(String type) {
        Hero hero = null;

        if (type.equals("archer")) {
            hero = new Archer();
        } else if (type.equals("warrior")) {
            hero = new Warrior();
        }else if (type.equals("ninja")) {
            hero = new Warrior();
        } else {
            return null;
        }

        return hero;
    }

}

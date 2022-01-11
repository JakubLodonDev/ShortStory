package com.company;

import java.util.Scanner;

public class StatsIncrease {
    private final int baseIncreaseHp = 15;
    private final int baseIncreaseDmg = 5;
    private final int baseIncreaseDodge = 2;

    public StatsIncrease() {
    }

    public boolean StatsUp(Hero hero, String increaseOneStat){
                switch (increaseOneStat.toLowerCase()) {
            case "hp":
                ImprovementMaxHp(hero);
                return true;
            case "dmg":
                ImprovementMaxDmg(hero);
                return true;
            case "dodge":
                ImprovementMaxDodge(hero);
                return true;
        }
        return false;
    }

    void ImprovementMaxHp(Hero hero) {
        hero.setHealth(hero.getHealth()+baseIncreaseHp);
    }
    void ImprovementMaxDmg(Hero hero) {
        hero.setDamage(hero.getDamage()+baseIncreaseDmg);
    }
    void ImprovementMaxDodge(Hero hero) {
        hero.setDodge(hero.getDodge()+baseIncreaseDodge);
    }
}

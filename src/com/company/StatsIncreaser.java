package com.company;

import com.company.Hero.Hero;

public class StatsIncreaser {
    private final int baseIncreaseHp = 15;
    private final int baseIncreaseDmg = 5;
    private final int baseIncreaseDodge = 2;

    public StatsIncreaser() {
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
        hero.IncreaseMaxHealth(baseIncreaseHp);
    }
    void ImprovementMaxDmg(Hero hero) {
        hero.IncreaseDamage(baseIncreaseDmg);
    }
    void ImprovementMaxDodge(Hero hero) { hero.IncreaseDodge(baseIncreaseDodge);    }
}

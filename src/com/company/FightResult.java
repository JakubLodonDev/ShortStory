package com.company;

import java.util.ArrayList;

public class FightResult {
    boolean LevelCompleted;
    ArrayList<BattleHistory> CourseOfTheBattles;

    public FightResult(boolean levelCompleted) {
        LevelCompleted = levelCompleted;
    }

    public FightResult(boolean levelResoult, ArrayList<BattleHistory> courseOfTheBattles) {
        LevelCompleted = levelResoult;
        CourseOfTheBattles = courseOfTheBattles;
    }
}

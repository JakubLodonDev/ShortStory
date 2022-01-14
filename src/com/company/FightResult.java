package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FightResult {
    boolean LevelCompleted;
    private ArrayList<BattleHistory> BattleHistory;

    public FightResult(boolean levelCompleted) {
        LevelCompleted = levelCompleted;
    }

    public FightResult(boolean levelCompleted, ArrayList<BattleHistory> battleHistory) {
        LevelCompleted = levelCompleted;
        BattleHistory = battleHistory;
    }

    public void AddHistory(BattleHistory history){
        BattleHistory.add(history);
    }

    public List<BattleHistory> GetReadOnlyHistory(){
        return Collections.unmodifiableList(BattleHistory);
    }
}

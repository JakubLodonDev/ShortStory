package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Gameplay gameplay = new Gameplay();
        int level = 0;
        var levelCompleted = gameplay.Game(); //gameplay.Game(level);

        while (levelCompleted){
            level++;
            //zapytac o kotynuacje
            // czy pokazac informacje
           // levelCompleted = gameplay.Game(level);
        }
    }
}
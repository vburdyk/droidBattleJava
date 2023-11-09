package battle.and.save;

import main.droid.Droid;
import main.droid.HealDroid;
import main.droid.BattleDroid;

import java.io.*;
import java.util.ArrayList;

public class RecordBattle {

    public static void setZeroHP(Droid droid1, Droid droid2) {
        if (!droid1.isAlive()) {
            droid1.setHealth(0);
        }
        if (!droid2.isAlive()) {
            droid2.setHealth(0);
        } else if (!droid1.isAlive() && !droid2.isAlive()) {
            droid1.setHealth(0);
            droid2.setHealth(0);
        }
    }

    public static void whoWin(Droid droid1, Droid droid2) {
        if (droid1.isAlive()) {
            System.out.println(droid1.getName() + " wins!");
        } else if (droid2.isAlive()) {
            System.out.println(droid2.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void whoWinTeam(Droid team1Droid1, Droid team1Droid2, Droid team2Droid1, Droid team2Droid2){
        if(team1Droid1.isAlive() || team1Droid2.isAlive()){
            System.out.println("Team 1 won!");
        } else if (team2Droid1.isAlive() || team2Droid2.isAlive()){
            System.out.println("Team 2 won!");
        } else {
            System.out.println("Draw");
        }
    }

    public static void giveDamage(Droid droid1, Droid droid2) {

        droid2.takeDamage(droid1.getDamage());
        droid1.takeDamage(droid2.getDamage());
    }

    public static void battleDroids(Droid droid1, Droid droid2, ArrayList<String> battleRecord) {
        System.out.println("Battling " + droid1.getName() + " vs " + droid2.getName());

        while (droid1.isAlive() && droid2.isAlive()) {
            giveDamage(droid1, droid2);

            setZeroHP(droid1, droid2);
            battleRecord.add(droid1.getName() + " (" + droid1.getHealth() + " HP) vs " + droid2.getName() + " (" + droid2.getHealth() + " HP)");
            System.out.println();
            System.out.println(droid1.getName() + " (" + droid1.getHealth() + " HP) vs " + droid2.getName() + " (" + droid2.getHealth() + " HP)");
            System.out.println("----------------------------------------------");
        }

        battleRecord.add("------------------------------------------------------------------------------------------------------------------------");
        whoWin(droid1, droid2);
    }

    public static void battle2v2(Droid team1Droid1, Droid team1Droid2, Droid team2Droid1, Droid team2Droid2, ArrayList<String> battleRecord) {
        System.out.println("Battling " + team1Droid1.getName() + " & " + team1Droid2.getName() + " vs " + team2Droid1.getName() + " & " + team2Droid2.getName());

        while ((team1Droid1.isAlive() || team1Droid2.isAlive()) && (team2Droid1.isAlive() || team2Droid2.isAlive())) {
            giveDamage(team1Droid1, team2Droid1);
            giveDamage(team1Droid2, team2Droid2);
            setZeroHP(team1Droid1, team2Droid1);
            setZeroHP(team1Droid2, team2Droid2);
            System.out.println("----------------------------------------------");
            battleRecord.add(team1Droid1.getName() + " (" + team1Droid1.getHealth() + " HP) & " + team1Droid2.getName() + " (" + team1Droid2.getHealth() + " HP) vs " + team2Droid1.getName() + " (" + team2Droid1.getHealth() + " HP) & " + team2Droid2.getName() + " (" + team2Droid2.getHealth() + " HP)");
            System.out.println(team1Droid1.getName() + " & " + team1Droid2.getName() + " vs " + team2Droid1.getName() + " & " + team2Droid2.getName());

        }

        battleRecord.add("------------------------------------------------------------------------------------------------------------------------");
        whoWinTeam(team1Droid1, team2Droid1, team2Droid2, team2Droid2);
    }

    public static void saveBattleRecord(ArrayList<String> battleRecord) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("battle_record.txt"));
            for (String record : battleRecord) {
                writer.write(record);
                writer.newLine();
            }
            writer.close();
            System.out.println("Battle record saved to 'battle_record.txt'.");
        } catch (IOException e) {
            System.out.println("Error while saving battle record: " + e.getMessage());
        }
    }

    public static void loadAndPlayBattleRecord(ArrayList<String> battleRecord) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("battle_record.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                battleRecord.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error while loading battle record: " + e.getMessage());
        }
    }
}

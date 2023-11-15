package battle.and.save;

import main.droid.Droid;
import main.droid.HealDroid;
import main.droid.BattleDroid;

import java.io.*;
import java.util.ArrayList;

/**
 * The RecordBattle class contains methods for managing and recording battles between droids.
 * It includes functionality for setting droid health to zero, determining the winner, giving damage, and recording battles.
 * The class also provides methods for saving and loading battle records to and from a file.
 */
public class RecordBattle {

    /**
     * Sets the health of the provided droids to zero if they are not alive.
     *
     * @param droid1 The first droid.
     * @param droid2 The second droid.
     */
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

    /**
     * Determines and prints the winner of a battle between two droids.
     *
     * @param droid1 The first droid.
     * @param droid2 The second droid.
     */
    public static void whoWin(Droid droid1, Droid droid2) {
        if (droid1.isAlive()) {
            System.out.println(droid1.getName() + " wins!");
        } else if (droid2.isAlive()) {
            System.out.println(droid2.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    /**
     * Determines and prints the winner of a 2v2 battle between two teams of droids.
     *
     * @param team1Droid1 The first droid of Team 1.
     * @param team1Droid2 The second droid of Team 1.
     * @param team2Droid1 The first droid of Team 2.
     * @param team2Droid2 The second droid of Team 2.
     */
    public static void whoWinTeam(Droid team1Droid1, Droid team1Droid2, Droid team2Droid1, Droid team2Droid2){
        if(team1Droid1.isAlive() || team1Droid2.isAlive()){
            System.out.println("Team 1 won!");
        } else if (team2Droid1.isAlive() || team2Droid2.isAlive()){
            System.out.println("Team 2 won!");
        } else {
            System.out.println("Draw");
        }
    }

    /**
     * Inflicts damage between two droids in a battle.
     *
     * @param droid1 The first droid.
     * @param droid2 The second droid.
     */
    public static void giveDamage(Droid droid1, Droid droid2) {

        droid2.takeDamage(droid1.getDamage());
        droid1.takeDamage(droid2.getDamage());
    }

    /**
     * Simulates a 1 vs 1 battle between two droids and records the battle details.
     *
     * @param droid1       The first droid.
     * @param droid2       The second droid.
     * @param battleRecord The list to store battle records.
     */
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

    /**
     * Simulates a 2 vs 2 battle between two teams of droids and records the battle details.
     *
     * @param team1Droid1  The first droid of Team 1.
     * @param team1Droid2  The second droid of Team 1.
     * @param team2Droid1  The first droid of Team 2.
     * @param team2Droid2  The second droid of Team 2.
     * @param battleRecord The list to store battle records.
     */
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

    /**
     * Saves the battle records to a text file.
     *
     * @param battleRecord The list of battle records.
     */
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

    /**
     * Loads and prints the battle records from a text file.
     *
     * @param battleRecord The list to store battle records.
     */
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

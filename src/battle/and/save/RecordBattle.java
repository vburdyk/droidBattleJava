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

    public static void giveDamage(Droid droid1, Droid droid2) {
        int damage1 = droid1.getDamage();
        int damage2 = droid2.getDamage();
        droid2.takeDamage(damage1);
        droid1.takeDamage(damage2);
    }

    public static void giveHeal(Droid droid1, Droid droid2) {
        if (droid1 instanceof HealDroid && droid2 instanceof HealDroid) {
            ((HealDroid) droid1).takeHeal(((HealDroid) droid1).getHeal());
            ((HealDroid) droid2).takeHeal(((HealDroid) droid2).getHeal());
        }
    }


    public static void battleDroids(Droid droid1, Droid droid2, ArrayList<String> battleRecord) {

        if (droid1 instanceof HealDroid && droid2 instanceof HealDroid) {
            System.out.println("Battling " + droid1.getName() + "(health: " + droid1.getHealth() + " damage: " + droid1.getDamage() + " heal: " + ((HealDroid) droid1).getHeal() + ")" + " vs " + droid2.getName() + "(health: " + droid2.getHealth() + " damage: " + droid2.getDamage() + " heal: " + ((HealDroid) droid2).getHeal() + ")");

            while (droid1.isAlive() && droid2.isAlive()) {
                giveDamage(droid1, droid2);
                giveHeal(droid1, droid2);
                setZeroHP(droid1, droid2);

                battleRecord.add(droid1.getName() + " (" + droid1.getHealth() + " HP, healed on: " + ((HealDroid) droid1).getHeal() + " HP) vs " + droid2.getName() + " (" + droid2.getHealth() + " HP, healed on: " + ((HealDroid) droid2).getHeal() + " HP)");
                System.out.println(droid1.getName() + " (" + droid1.getHealth() + " HP, healed on: " + ((HealDroid) droid1).getHeal() + " HP) vs " + droid2.getName() + " (" + droid2.getHealth() + " HP, healed on: " + ((HealDroid) droid2).getHeal() + " HP)");

            }

            whoWin(droid1, droid2);
        }

        if (droid1 instanceof BattleDroid && droid2 instanceof BattleDroid) {
            System.out.println("Battling " + droid1.getName() + "(health: " + droid1.getHealth() + " damage: " + droid1.getDamage() + ")" + " vs " + droid2.getName() + "(health: " + droid2.getHealth() + " damage: " + droid2.getDamage() + ")");
            while (droid1.isAlive() && droid2.isAlive()) {

                giveDamage(droid1, droid2);
                setZeroHP(droid1, droid2);

                battleRecord.add(droid1.getName() + " (" + droid1.getHealth() + "HP) vs " + droid2.getName() + " (" + droid2.getHealth() + "HP)");
                System.out.println(droid1.getName() + " (" + droid1.getHealth() + "HP) vs " + droid2.getName() + " (" + droid2.getHealth() + "HP)");
            }
            whoWin(droid1, droid2);
        }

        if (droid1 instanceof BattleDroid && droid2 instanceof HealDroid) {

            System.out.println("Battling " + droid1.getName() + "(health: " + droid1.getHealth() + " damage: " + droid1.getDamage() + ")" + " vs " + droid2.getName() + "(health: " + droid2.getHealth() + " damage: " + droid2.getDamage() + " heal: " + ((HealDroid) droid2).getHeal() + ")");

            while (droid1.isAlive() && droid2.isAlive()) {

                giveDamage(droid1, droid2);
                setZeroHP(droid1, droid2);
                giveHeal(null, droid2);

                battleRecord.add(droid1.getName() + " (" + droid1.getHealth() + "HP) vs " + droid2.getName() + "(health: " + droid2.getHealth() + " damage: " + droid2.getDamage() + " heal: " + ((HealDroid) droid2).getHeal() + ")");
                System.out.println(droid1.getName() + " (" + droid1.getHealth() + "HP) vs " + droid2.getName() + "(health: " + droid2.getHealth() + " damage: " + droid2.getDamage() + " heal: " + ((HealDroid) droid2).getHeal() + ")");
            }
            whoWin(droid1, droid2);
        }

        if (droid1 instanceof HealDroid && droid2 instanceof BattleDroid) {

            System.out.println("Battling " + droid1.getName() + "(health: " + droid1.getHealth() + " damage: " + droid1.getDamage() + " heal: " + ((HealDroid) droid1).getHeal() + ")" + " vs " + droid2.getName() + "(health: " + droid2.getHealth() + " damage: " + droid2.getDamage() + ")");

            while (droid1.isAlive() && droid2.isAlive()) {

                giveDamage(droid1, droid2);
                setZeroHP(droid1, droid2);
                giveHeal(droid1, null);

                battleRecord.add("Battling " + droid1.getName() + "(health: " + droid1.getHealth() + " damage: " + droid1.getDamage() + " heal: " + ((HealDroid) droid1).getHeal() + ")" + " vs " + droid2.getName() + "(health: " + droid2.getHealth() + " damage: " + droid2.getDamage() + ")");
                System.out.println(droid1.getName() + " (" + droid1.getHealth() + "HP) vs " + droid2.getName() + " (" + droid2.getHealth() + "HP)");
            }
            whoWin(droid1, droid2);
        }
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

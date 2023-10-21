package battle.and.save;


import main.droid.Droid;

import java.util.ArrayList;

public class RecordBattle {
    public static void battleDroids(Droid droid1, Droid droid2) {
        System.out.println("Battling " + "(health: " +droid1.getHealth() + " damage: " + droid1.getDamage() + " vs. " + droid1.getName() + "(health: " +droid2.getHealth() + " damage: " + droid2.getDamage() + ")");
        while (droid1.isAlive() && droid2.isAlive()) {
            int damage1 = droid1.getDamage();
            int damage2 = droid2.getDamage();

            droid2.takeDamage(damage1);
            droid1.takeDamage(damage2);

            System.out.println(droid1.getName() + " (" + droid1.getHealth() + "HP) vs. " + droid2.getName() + " (" + droid2.getHealth() + "HP)");
//            battleRecord.add(droid1.getName() + " (" + droid1.getHealth() + "HP) vs. " + droid2.getName() + " (" + droid2.getHealth() + "HP)");
        }

        if (droid1.isAlive()) {
            System.out.println(droid1.getName() + " wins!");
        } else if (droid2.isAlive()) {
            System.out.println(droid2.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

//        if (droid1.isAlive()) {
//            System.out.println(droid1.getName() + " wins!");
//            battleRecord.add(droid1.getName() + " wins!");
//        } else if (droid2.isAlive()) {
//            System.out.println(droid2.getName() + " wins!");
//            battleRecord.add(droid2.getName() + " wins!");
//        } else {
//            System.out.println("It's a draw!");
//            battleRecord.add("It's a draw!");
//        }
    }



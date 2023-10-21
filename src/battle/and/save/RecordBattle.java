package battle.and.save;

import main.droid.Droid;
import main.droid.HealDroid;

public class RecordBattle {
    public static void battleDroids(Droid droid1, Droid droid2) {
        if (droid1 instanceof HealDroid && droid2 instanceof HealDroid) {
            System.out.println("Battling " + "(health: " + droid1.getHealth() + " damage: " + droid1.getDamage() + ")" + " vs. " + droid1.getName() + "(health: " + droid2.getHealth() + " damage: " + droid2.getDamage() + ")");

            while (droid1.isAlive() && droid2.isAlive()) {

                int damage1 = droid1.getDamage();
                int damage2 = droid2.getDamage();
                droid2.takeDamage(damage1);
                droid1.takeDamage(damage2);

                ((HealDroid) droid1).takeHeal(((HealDroid) droid1).getHeal());
                ((HealDroid) droid2).takeHeal(((HealDroid) droid2).getHeal());


                System.out.println(droid1.getName() + " (" + droid1.getHealth() + "HP) vs. " + droid2.getName() + " (" + droid2.getHealth() + "HP)");
            }
            if (droid1.getHealth() < 0) {
                droid1.setHealth(0);
            }

            if (droid2.getHealth() < 0) {
                droid2.setHealth(0);
            } else {
                droid1.setHealth(0);
                droid2.setHealth(0);
            }

            if (droid1.isAlive()) {
                System.out.println(droid1.getName() + " wins!");
            } else if (droid2.isAlive()) {
                System.out.println(droid2.getName() + " wins!");
            } else {
                System.out.println("It's a draw!");
            }


        }
    }
}


//        System.out.println("Battling " + "(health: " + droid1.getHealth() + " damage: " + droid1.getDamage() + ")" + " vs. " + droid1.getName() + "(health: " + droid2.getHealth() + " damage: " + droid2.getDamage() + ")");
//        while (droid1.isAlive() && droid2.isAlive()) {

//            int damage1 = droid1.getDamage();
//            int damage2 = droid2.getDamage();
//            droid2.takeDamage(damage1);
//            droid1.takeDamage(damage2);


//            if (droid1.getHealth() < 0){
//                droid1.setHealth(0);
//            }
//
//            if (droid2.getHealth() < 0){
//                droid2.setHealth(0);
//            }
//            else {
//                droid1.setHealth(0);
//                droid2.setHealth(0);
//            }

//
//            System.out.println(droid1.getName() + " (" + droid1.getHealth() + "HP) vs. " + droid2.getName() + " (" + droid2.getHealth() + "HP)");
//            battleRecord.add(droid1.getName() + " (" + droid1.getHealth() + "HP) vs. " + droid2.getName() + " (" + droid2.getHealth() + "HP)");


//        if (droid1.isAlive()) {
//            System.out.println(droid1.getName() + " wins!");
//        } else if (droid2.isAlive()) {
//            System.out.println(droid2.getName() + " wins!");
//        } else {
//            System.out.println("It's a draw!");
//        }

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




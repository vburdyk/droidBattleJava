import main.droid.BattleDroid;
import main.droid.Droid;
import main.droid.HealDroid;
import battle.and.save.RecordBattle;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Droid> droids = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create a Heal Droid");
            System.out.println("2. Create a Battle Droid");
            System.out.println("3. Show the list of created Droids");
            System.out.println("4. Battle 1 vs 1");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Droid name: ");
                    String droidName = scanner.nextLine();
                    System.out.print("Enter Droid health: ");
                    int droidHealth = scanner.nextInt();
                    System.out.print("Enter Droid damage: ");
                    int droidDamage = scanner.nextInt();
                    System.out.print("Enter Droid heal: ");
                    int droidHeal = scanner.nextInt();

                    HealDroid newDroid = new HealDroid();
                    newDroid.setName(droidName);
                    newDroid.setHealth(droidHealth);
                    newDroid.setDamage(droidDamage);
                    newDroid.setHeal(droidHeal);
                    droids.add(newDroid);
                    System.out.println("Healer Droid " + droidName + " created!");
                    break;

                case 2:
                    System.out.print("Enter Droid name: ");
                    String droidName2 = scanner.nextLine();
                    System.out.print("Enter Droid health: ");
                    int droidHealth2 = scanner.nextInt();
                    System.out.print("Enter Droid damage: ");
                    int droidDamage2 = scanner.nextInt();
                    Droid newDroid2 = new BattleDroid(droidName2, droidHealth2, droidDamage2);
                    droids.add(newDroid2);
                    System.out.println("Battle Droid " + droidName2 + " created!");
                    break;

                case 3:
                    System.out.println("List of created Droids:");
                    for (Droid droid : droids) {
                        System.out.println(droid);
                    }
                    break;

                case 4:
                    if (droids.size() < 2) {
                        System.out.println("You need more droids to battle");
                        break;
                    }
                    System.out.println("Select two droids to battle:");
                    for (int i = 0; i < droids.size(); i++) {
                        System.out.println(i + 1 + ". " + droids.get(i).getName());
                    }
                    int droidIndex1 = scanner.nextInt() - 1;
                    int droidIndex2;
                    do {
                        droidIndex2 = scanner.nextInt() - 1;
                    } while (droidIndex1 == droidIndex2);

                    Droid droid1 = droids.get(droidIndex1);
                    Droid droid2 = droids.get(droidIndex2);

                    RecordBattle.battleDroids(droid1, droid2);
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}

import main.droid.BattleDroid;
import main.droid.Droid;
import main.droid.HealDroid;
import battle.and.save.RecordBattle;

import java.util.ArrayList;
import java.util.Scanner;

import static battle.and.save.RecordBattle.saveBattleRecord;
import static battle.and.save.RecordBattle.loadAndPlayBattleRecord;

public class BattleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Droid> droids = new ArrayList<>();
        ArrayList<String> battleRecord = new ArrayList<>();

        ArrayList<String> battleRecord2v2 = new ArrayList<>();


        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create a Heal Droid");
            System.out.println("2. Create a Battle Droid");
            System.out.println("3. Show the list of created Droids");
            System.out.println("4. Battle 1 vs 1");
            System.out.println("5. Battle 2 vs 2");
            System.out.println("6. Save record of the battle");
            System.out.println("7. Play record of the battle");
            System.out.println("8. Exit");

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

                    Droid newDroid2 = new HealDroid();
                    newDroid2.setName(droidName2);
                    newDroid2.setHealth(droidHealth2);
                    newDroid2.setDamage(droidDamage2);
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

                    RecordBattle.battleDroids(droid1, droid2, battleRecord);
                    break;

                case 5:
                    if (droids.size() < 4) {
                        System.out.println("You need more droids to battle");
                        break;
                    }
                    System.out.println("Select four droids to battle:");
                    for (int i = 0; i < droids.size(); i++) {
                        System.out.println(i + 1 + ". " + droids.get(i).getName());
                    }
                    int team1DroidIndex1 = scanner.nextInt() - 1;
                    int team1DroidIndex2;
                    do {
                        team1DroidIndex2 = scanner.nextInt() - 1;
                    } while (team1DroidIndex1 == team1DroidIndex2);

                    int team2DroidIndex1;
                    do {
                        team2DroidIndex1 = scanner.nextInt() - 1;
                    } while (team2DroidIndex1 == team1DroidIndex1 || team2DroidIndex1 == team1DroidIndex2);

                    int team2DroidIndex2;
                    do {
                        team2DroidIndex2 = scanner.nextInt() - 1;
                    } while (team2DroidIndex2 == team1DroidIndex1 || team2DroidIndex2 == team1DroidIndex2 || team2DroidIndex2 == team2DroidIndex1);

                    Droid team1Droid1 = droids.get(team1DroidIndex1);
                    Droid team1Droid2 = droids.get(team1DroidIndex2);
                    Droid team2Droid1 = droids.get(team2DroidIndex1);
                    Droid team2Droid2 = droids.get(team2DroidIndex2);

                    RecordBattle.battle2v2(team1Droid1, team1Droid2, team2Droid1, team2Droid2, battleRecord);
                    break;
                case 6:
                    saveBattleRecord(battleRecord);
                    break;
                case 7:
                    loadAndPlayBattleRecord(battleRecord);
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}

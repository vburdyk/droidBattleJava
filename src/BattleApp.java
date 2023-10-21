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
            System.out.println("4. Exit");

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
                    Droid newDroid = new HealDroid(droidName, droidHealth, droidDamage, droidHeal);
                    droids.add(newDroid);
                    System.out.println("Battle Droid " + droidName +" created!");
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
                    System.out.println("Healer Droid " + droidName2 +" created!");
                    break;
                case 3:
                    System.out.println("List of created Droids:");
                    for (Droid droid : droids) {
                        System.out.println(droid);
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}

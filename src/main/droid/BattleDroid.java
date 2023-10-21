package main.droid;

public class BattleDroid extends Droid {
    public BattleDroid(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public String toString() {
        return "BattleDroid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }
}

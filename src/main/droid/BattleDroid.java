package main.droid;

/**
 * The main.droid.BattleDroid class represents a specialized type of Droid designed for battles.
 * It extends the base Droid class and inherits attributes and methods for handling damage.
 */
public class BattleDroid extends Droid {

    /**
     * Constructor for creating an instance of main.droid.BattleDroid with specified name, health, and damage values.
     *
     * @param name   The name of the main.droid.BattleDroid.
     * @param health The initial health value of the main.droid.BattleDroid.
     * @param damage The damage value of the main.droid.BattleDroid.
     */
    public BattleDroid(String name, int health, int damage) {
        super(name, health, damage);
    }

    /**
     * Overrides the takeDamage method of the base Droid class.
     * It allows the main.droid.BattleDroid to take damage by calling the superclass method.
     *
     * @param damage The amount of damage to be taken.
     */
    @Override
    public void takeDamage(int damage){
        super.takeDamage(damage);

    }

    /**
     * Overrides the toString method to provide a string representation of the main.droid.BattleDroid object.
     *
     * @return A string containing the name, health, and damage values of the main.droid.BattleDroid.
     */
    @Override
    public String toString() {
        return "BattleDroid{" +
                "name='" + getName() + '\'' +
                ", health=" + getHealth() +
                ", damage=" + getDamage() +
                '}';
    }
}

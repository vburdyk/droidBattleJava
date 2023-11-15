package main.droid;

/**
 * The main.droid.Droid class represents a basic unit in a game or simulation.
 * It has attributes such as name, health, and damage, and includes methods for taking damage,
 * checking if it is alive, and determining if it is a specialized HealDroid.
 */
public class Droid {

    // Private fields to store the attributes of the main.droid.Droid.
    private String name;
    private int health;
    private int damage;

    /**
     * Constructor for creating an instance of main.droid.Droid with specified name, health, and damage values.
     *
     * @param name   The name of the main.droid.Droid.
     * @param health The initial health value of the main.droid.Droid.
     * @param damage The damage value of the main.droid.Droid.
     */
    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    /**
     * Default constructor for creating an instance of main.droid.Droid with default values.
     */
    public Droid(){}

    /**
     * Reduces the main.droid.Droid's health by the specified damage amount.
     *
     * @param damage The amount of damage to be taken.
     */
    public void takeDamage(int damage){
        health -= damage;
    }

    /**
     * Checks if the main.droid.Droid is alive based on its current health.
     *
     * @return True if the main.droid.Droid is alive (health > 0), false otherwise.
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Checks if the main.droid.Droid is an instance of the HealDroid class.
     *
     * @return True if the main.droid.Droid is a HealDroid, false otherwise.
     */
    public boolean isHealDroid()
    {
        return this instanceof HealDroid;
    }

    /**
     * Gets the name of the main.droid.Droid.
     *
     * @return The name of the main.droid.Droid.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the main.droid.Droid.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the current health of the main.droid.Droid.
     *
     * @return The current health value.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the health of the main.droid.Droid to the specified value.
     *
     * @param health The new health value.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets the damage value of the main.droid.Droid.
     *
     * @return The damage value.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the damage value of the main.droid.Droid to the specified value.
     *
     * @param damage The new damage value.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
}

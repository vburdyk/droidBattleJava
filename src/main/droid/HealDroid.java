package main.droid;

/**
 * The HealDroid class represents a specialized type of Droid that has the ability to heal itself.
 * It extends the base Droid class and includes additional functionality for healing.
 */
public class HealDroid extends Droid {

    /**
     * Default constructor for creating an instance of HealDroid.
     */
    public HealDroid() {
    }

    // Private field to store the amount of healing the HealDroid can perform.
    private int heal;

    /**
     * Gets the amount of healing the HealDroid can perform.
     *
     * @return The healing value.
     */
    public int getHeal() {
        return heal;
    }

    /**
     * Sets the amount of healing the HealDroid can perform.
     *
     * @param heal The healing value to set.
     */
    public void setHeal(int heal) {
        this.heal = heal;
    }

    /**
     * Overrides the takeDamage method of the base Droid class to include healing functionality.
     * It reduces the Droid's health by the specified damage amount and then applies healing.
     * Prints a message indicating the damage taken.
     *
     * @param damage The amount of damage to be taken.
     */
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        takeHeal(heal);
        System.out.println(getName() + " got damage: " + getDamage());
    }

    /**
     * Performs healing on the HealDroid. Checks if the Droid is a HealDroid before applying healing.
     * If it is a HealDroid, increases the Droid's health by the specified healing amount.
     * Prints a message indicating the amount of health recovered.
     *
     * @param heal The amount of healing to be applied.
     */
    public void takeHeal(int heal) {

        if (isHealDroid()) {
            int currentHP = getHealth();
            currentHP += heal;
            setHealth(currentHP);
            System.out.println(getName() + " recovered " + getHeal() + " HP");
        } else {
            int currentHP = getHealth();
            currentHP += heal;
            setHealth(currentHP);
        }
    }

    /**
     * Overrides the toString method to provide a string representation of the HealDroid object.
     *
     * @return A string containing the name, health, damage, and heal values of the HealDroid.
     */
    @Override
    public String toString() {
        return "HealDroid{" +
                "name='" + getName() + '\'' +
                ", health=" + getHealth() +
                ", damage=" + getDamage() +
                ", heal=" + heal +
                '}';
    }
}

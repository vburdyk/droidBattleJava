package main.droid;

public class HealDroid extends Droid {
    public HealDroid() {
    }

    private int heal;

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        takeHeal(heal);
        System.out.println(getName() + " got damage: " + getDamage());
    }

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

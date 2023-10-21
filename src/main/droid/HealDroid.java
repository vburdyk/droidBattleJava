package main.droid;

public class HealDroid extends Droid {
    public HealDroid(){}

    int heal;
    public HealDroid(String name, int health, int damage, int heal){
        super(name, health, damage);
        this.heal = heal;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public void takeHeal(int heal){
        health += heal;
    }

    @Override
    public String toString() {
        return "HealDroid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", heal=" + heal +
                '}';
    }
}

public class HealDroid extends Droid{
    int heal;
    public HealDroid(String name, int health, int damage, int heal){
        super(name, health, damage);
        this.heal = heal;
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

public class Droid {
    String name;
    int health;
    int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void takeDamage(int damage){
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

}

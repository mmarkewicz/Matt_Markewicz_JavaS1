public class Farmer extends Player {

    public Farmer(String name, int strength, int health, int stamina, int speed, int attackPower) {
        super(name, strength, health, stamina, speed, attackPower);
    }
    
    @Override
    public void run() {
        super.run();
    }

    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void heal() {
        super.heal();
    }

    @Override
    public void decreaseHealth() {
        super.decreaseHealth();
    }

    @Override
    public void increaseStamina() {
        super.increaseStamina();
    }

    @Override
    public void decreaseStamina() {
        super.decreaseStamina();
    }
}

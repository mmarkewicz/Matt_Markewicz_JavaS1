public class Farmer extends Player {

    private int strength = 75;
    private int stamina = 75;
    private int speed = 10;
    private int attackPower = 1;

    public Farmer(String name) {
        super(name);
    }

    public void plow() {
        System.out.println("Plowing...");
    }

    public void harvest() {
        System.out.println("Harvesting...");
    }

    @Override
    public void heal() {
        System.out.println("Healing");
        int health = this.getHealth();
        this.setHealth(health += 10);
    }

    @Override
    public void decreaseHealth() {
        System.out.println("Losing health!");
        int health = this.getHealth();
        this.setHealth(health -= 10);
    }
    @Override
    public void increaseStamina() {
        System.out.println("Increasing stamina");
        int stamina = this.getStamina();
        this.setStamina(stamina += 10);
    }

    @Override
    public void decreaseStamina() {
        System.out.println("Decreasing stamina");
        int stamina = this.getStamina();
        this.setStamina(stamina -= 10);
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getStamina() {
        return stamina;
    }

    @Override
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}

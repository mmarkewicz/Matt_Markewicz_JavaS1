public class Warrior extends Player {

    private int strength = 75;
    private int stamina = 100;
    private int speed = 50;
    private int attackPower = 10;
    private int shieldStrength = 100;

    public Warrior(String name) {
        super(name);
    }

    public void heal() {
        System.out.println("Healing ...");
        int health = getHealth();
        this.setHealth(health += 10);
    }

    public void decreaseHealth() {
        System.out.println("Losing health ...");
        int health = getHealth();
        this.setHealth(health -= 10);
    }

    public void increaseStamina() {
        System.out.println("Increasing stamina ...");
        int stamina = getStamina();
        this.setStamina(stamina += 10);
    }

    public void decreaseStamina() {
        System.out.println("Decreasing stamina ...");
        int stamina = getStamina();
        this.setStamina(stamina -= 10);
    }

    public void decreaseShieldStrength() {
        System.out.println("Decreasing shield strength ...");
        int shieldStrength = getShieldStrength();
        this.setShieldStrength(shieldStrength -= 10);
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

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
}

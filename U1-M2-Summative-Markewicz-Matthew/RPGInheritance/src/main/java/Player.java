public abstract class Player {
    private String name;
    private int strength;
    private int health = 100;
    private int stamina;
    private int speed;
    private int attackPower;

    public Player(String name) {
        System.out.println("Constructing the Player ... ");
        this.name = name;
    }

    public void run() {
        System.out.println("You have run away from battle!");
    }

    public void attack() {
        System.out.println("Attacking!");
    }

    public void heal() {
        System.out.println("Healing");
        health += 10;
    }

    public void decreaseHealth() {
        this.health -= 10;
    }

    public void increaseStamina() {
        this.stamina += 10;
    }

    public void decreaseStamina() {
        this.stamina -= 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
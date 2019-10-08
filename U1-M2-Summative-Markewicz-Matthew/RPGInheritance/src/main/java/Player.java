public abstract class Player {
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    public Player(String name, int strength, int health, int stamina, int speed, int attackPower) {
        System.out.println("Constructing the Player ... ");
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
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

    }

    public void increaseStamina() {

    }

    public void decreaseStamina() {

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
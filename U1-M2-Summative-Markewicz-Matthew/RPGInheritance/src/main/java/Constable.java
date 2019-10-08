public class Constable extends Player {

    private int strength = 60;
    private int stamina = 60;
    private int speed = 20;
    private int attackPower = 5;
    private String jurisdiction;

    public Constable(String name, String jurisdiction) {
        super(name);
        this.jurisdiction = jurisdiction;
    }

    public void arrest() {
        System.out.println("Arresting ...");
    }

    public void heal() {
        System.out.println("Healing");
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

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}

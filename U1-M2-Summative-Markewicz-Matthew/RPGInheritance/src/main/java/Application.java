public class Application {
    public static void main(String[] args) {
        Farmer farmer = new Farmer("Matt", 100, 100, 40, 50, 50);
        Constable constable = new Constable("John", 50, 100, 40, 60, 80);
        Warrior warrior = new Warrior("Rob", 50, 100, 40, 30, 20);
        System.out.println(farmer.getName());
        System.out.println(warrior.getName());
        System.out.println(constable.getName());
    }
}

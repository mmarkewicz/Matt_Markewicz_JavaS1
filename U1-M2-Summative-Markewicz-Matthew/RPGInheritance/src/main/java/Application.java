import com.sun.tools.internal.jxc.ap.Const;

public class Application {
    public static void main(String[] args) {
        Farmer farmer = new Farmer("Matt");
        Constable constable = new Constable("John", "Jurisdiction 1");
        Warrior warrior = new Warrior("Rob");

        // METHOD TESTING
        // farmer methods
        // -------------------------------------------
        farmer.run();
        farmer.plow();
        farmer.harvest();
        farmer.attack();
        farmer.heal();
        System.out.println(farmer.getHealth()); // expected output: 110
        farmer.decreaseHealth();
        System.out.println(farmer.getHealth()); // expected output: 100
        farmer.increaseStamina();
        System.out.println(farmer.getStamina()); // expected output: 85
        farmer.decreaseStamina();
        System.out.println(farmer.getStamina()); // expected output: 75

        // -------------------------------------------

        // constable methods
        // -------------------------------------------
        constable.run();
        constable.arrest();
        constable.attack();
        constable.heal();
        System.out.println(constable.getHealth()); // expected output: 110
        constable.decreaseHealth();
        System.out.println(constable.getHealth()); // expected output: 100
        constable.increaseStamina();
        System.out.println(constable.getStamina()); // expected output: 70
        constable.decreaseStamina();
        System.out.println(constable.getStamina()); // expected output: 60
        // -------------------------------------------

        // warrior methods
        // -------------------------------------------
        warrior.run();
        warrior.attack();
        warrior.heal();
        System.out.println(warrior.getHealth()); // expected output: 110
        warrior.decreaseHealth();
        System.out.println(warrior.getHealth()); // expected output: 100
        warrior.increaseStamina();
        System.out.println(warrior.getStamina()); // expected output: 110
        warrior.decreaseStamina();
        System.out.println(warrior.getStamina()); // expected output: 100
        warrior.decreaseShieldStrength();
        System.out.println(warrior.getShieldStrength()); // expected output: 90
        // -------------------------------------------
    }
}

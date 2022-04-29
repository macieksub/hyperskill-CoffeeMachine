import java.util.Scanner;

/*
water = 400
milk = 540
beans = 120
cups = 9
money = 550
*/

public class CoffeeMachine {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ingredients = {400, 540, 120, 9, 550};
        boolean work = true;
        while (work) {
            work = action(sc, ingredients);
        }
    }
  
    public static void status(int[] ingredients) {
        System.out.println("The coffee machine has:");
        System.out.println(ingredients[0] + " ml of water");
        System.out.println(ingredients[1] + " ml of milk");
        System.out.println(ingredients[2] + " g of coffee beans");
        System.out.println(ingredients[3] + " disposable cups");
        System.out.println("$" + ingredients[4] + " of money");
    }
  
    public static boolean action(Scanner sc, int[] ingredients) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = sc.next();
        boolean run = true;
        if (action.equals("exit")) {
            run = false;
        } else if (action.equals("take")) {
            System.out.println("I gave you $" + ingredients[4]);
            ingredients[4] = 0;
        } else if (action.equals("fill")) {
            System.out.println("Write how many ml of water you want to add:");
            ingredients[0] += sc.nextInt();
            System.out.println("Write how many ml of milk you want to add: ");
            ingredients[1] += sc.nextInt();
            System.out.println("Write how many grams of coffee beans you want to add:");
            ingredients[2] += sc.nextInt();
            System.out.println("Write how many disposable cups of coffee you want to add:");
            ingredients[3] += sc.nextInt();
        } else if (action.equals("buy")) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String choice = sc.next();
            if (choice.equals("1")) {
                int water = 250;
                int beans = 16;
                if (water > ingredients[0] || beans > ingredients[2] || ingredients[3] <= 0) {
                    System.out.println("Sorry, not enough ingredients!");
                } else {
                    System.out.println("Making you a coffee!");
                    ingredients[0] -= 250;
                    ingredients[2] -= 16;
                    ingredients[4] += 4;
                    ingredients[3]--;
                }
            } else if (choice.equals("2")) {
                int water = 350;
                int milk = 75;
                int beans = 20;
                if (water > ingredients[0] || milk > ingredients[1] || beans > ingredients[2] || ingredients[3] <= 0) {
                    System.out.println("Sorry, not enough ingredients!");
                } else {
                    System.out.println("Making you a coffee!");
                    ingredients[0] -= 350;
                    ingredients[1] -= 75;
                    ingredients[2] -= 20;
                    ingredients[4] += 7;
                    ingredients[3]--;
                }
            } else if (choice.equals("3")) {
                int water = 200;
                int milk = 100;
                int beans = 12;
                if (water > ingredients[0] || milk > ingredients[1] || beans > ingredients[2] || ingredients[3] <= 0) {
                    System.out.println("Sorry, not enough ingredients!");
                } else {
                    System.out.println("Making you a coffee!");
                    ingredients[0] -= 200;
                    ingredients[1] -= 100;
                    ingredients[2] -= 12;
                    ingredients[4] += 6;
                    ingredients[3]--;
                }
            }
        }
        else if (action.equals("remaining")) {
            status(ingredients);
        }
        return run;
    }
}

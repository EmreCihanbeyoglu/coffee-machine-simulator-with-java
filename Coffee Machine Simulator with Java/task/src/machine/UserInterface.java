
package machine;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final CoffeeMachine coffeeMachine;

    public UserInterface(CoffeeMachine coffeeMachine){
        scanner = new Scanner(System.in);
        this.coffeeMachine = coffeeMachine;
    }



    public void printOutCurrentQuantityOfSuppliesInTheMachine() {
        String currentQuantityText = """
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """;
        System.out.printf(currentQuantityText,
                coffeeMachine.getCurrentWater(),
                coffeeMachine.getCurrentMilk(),
                coffeeMachine.getCurrentCoffeeBeans(),
                coffeeMachine.getCurrentDisposableCups(),
                coffeeMachine.getCurrentMoney());
    }

    public String getActionFromUser() {
        String selectedAction = null;
        System.out.printf("Write action %s\n", Actions.getPossibleActionsAsStringSurroundedByParanthesis());
        try{
            selectedAction = scanner.nextLine();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return selectedAction;
    }

    public int[] fillSupply() {
        int[] supplies = new int[4];
        while (true) {
            boolean hasSmallerThanZeroElement = false;
            try{
                System.out.println("Write how many ml of water you want to add:");
                supplies[0] = Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many ml of milk you want to add:");
                supplies[1] = Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many grams of coffee beans you want to add:");
                supplies[2] = Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many disposable cups you want to add:");
                supplies[3] = Integer.parseInt(scanner.nextLine());
                for(int supply : supplies) {
                    if(supply < 0) {
                        System.out.println("invalid input");
                        hasSmallerThanZeroElement = true;
                        break;
                    }
                }

                if(!hasSmallerThanZeroElement) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        return supplies;
    }

    public void takeOutMoneyFromMachine() {
        System.out.printf("I gave you $%d%n", coffeeMachine.getCurrentMoney());
    }

    public int getWantedCoffeeTypeFromUser() {
        int selectedTypeIndex;
        while (true){
            System.out.printf("What do you want to buy? %s\n", CoffeeTypes.getAllCoffeeTypesAsOrderedString());
            try {
                String input = scanner.nextLine();
                if(input.equals("back")) {
                    return -1;
                }
                selectedTypeIndex = Integer.parseInt(input);
                if(selectedTypeIndex > 0 && selectedTypeIndex <= CoffeeTypes.values().length){
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("wrong input");
        }

        return selectedTypeIndex;
    }
    public void closeUserInterface() {
        scanner.close();
    }
}
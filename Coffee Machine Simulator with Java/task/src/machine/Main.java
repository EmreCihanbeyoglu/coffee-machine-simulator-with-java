package machine;

public class Main {

    private static UserInterface userInterface;
    private static CoffeeMachine coffeeMachine;
    public static void main(String[] args) {
        start();
        processSelectedAction();
    }


    public static void start() {
        coffeeMachine = new CoffeeMachine();
        userInterface = new UserInterface(coffeeMachine);
    }

    public static void processSelectedAction() {
        boolean applicationRunFlag = true;
        while (applicationRunFlag){
            String command = userInterface.getActionFromUser();
            switch (command) {
                case "buy":
                    int coffeeIndex = userInterface.getWantedCoffeeTypeFromUser();
                    coffeeMachine.makeCoffeeByGivenIndex(coffeeIndex);
                    break;
                case "fill":
                    int[] newSupplies = userInterface.fillSupply();
                    coffeeMachine.addSupply(newSupplies[0], newSupplies[1], newSupplies[2], newSupplies[3]);
                    break;
                case "take":
                    userInterface.takeOutMoneyFromMachine();
                    coffeeMachine.setCurrentMoney(0);
                    break;
                case "remaining":
                    userInterface.printOutCurrentQuantityOfSuppliesInTheMachine();
                    break;
                case "exit":
                    userInterface.closeUserInterface();
                    applicationRunFlag = false;
                    break;
            }
        }

    }

}




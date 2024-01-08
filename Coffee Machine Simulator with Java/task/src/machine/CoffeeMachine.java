
package machine;


public class CoffeeMachine {

    private int currentWater;
    private int currentMilk;
    private int currentCoffeeBeans;
    private int currentMoney;
    private int currentDisposableCups;


    public CoffeeMachine() {
        this.currentWater = 400;
        this.currentMilk = 540;
        this.currentCoffeeBeans = 120;
        this.currentMoney = 550;
        this.currentDisposableCups = 9;
    }


    public int getCurrentWater() {
        return currentWater;
    }

    public int getCurrentMilk() {
        return currentMilk;
    }

    public int getCurrentCoffeeBeans() {
        return currentCoffeeBeans;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public int getCurrentDisposableCups() {
        return currentDisposableCups;
    }

    public void setCurrentMoney(int newValue) {
        currentMoney = newValue;
    }
    public void addSupply(int water, int milk, int coffeeBeans, int disposableCups) {
        currentWater += water;
        currentMilk += milk;
        currentCoffeeBeans += coffeeBeans;
        currentDisposableCups += disposableCups;
    }

    public void makeCoffeeByGivenIndex(int coffeeIndex) {
        if(coffeeIndex == -1) {
            return;
        }
        String missingIngredient = "";
        CoffeeTypes selectedCoffee = CoffeeTypes.findCoffeeByIndex(coffeeIndex);
        if(selectedCoffee != null) {
            if(currentWater < selectedCoffee.getWater()) {
                missingIngredient = "water";
                System.out.printf("Sorry, not enough %s!\n", missingIngredient);
                return;
            }
            if(currentMilk < selectedCoffee.getMilk()) {
                missingIngredient = "milk";
                System.out.printf("Sorry, not enough %s!\n", missingIngredient);
                return;
            }
            if(currentCoffeeBeans < selectedCoffee.getCoffeeBeans()) {
                missingIngredient = "coffee beans";
                System.out.printf("Sorry, not enough %s!\n", missingIngredient);
                return;
            }
            if(currentDisposableCups < 1) {
                missingIngredient = "disposable cups";
                System.out.printf("Sorry, not enough %s!\n", missingIngredient);
                return;
            }

            System.out.println("I have enough resources, making you a coffee!");
            currentWater -= selectedCoffee.getWater();
            currentMilk -= selectedCoffee.getMilk();
            currentCoffeeBeans -= selectedCoffee.getCoffeeBeans();
            currentDisposableCups -= 1;
            currentMoney += selectedCoffee.getPrice();

        }

    }
}

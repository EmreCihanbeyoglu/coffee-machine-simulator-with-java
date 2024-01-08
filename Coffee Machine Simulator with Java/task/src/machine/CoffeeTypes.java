package machine;


public enum CoffeeTypes {
    ESPRESSO("espresso", 1, 250, 0, 16, 4),
    LATTE("latte", 2,350, 75, 20, 7),
    CAPPUCCINO("cappucino", 3, 200,100,12,6);

    private final String name;
    private final int index;
    private final int WATER;
    private final int MILK;
    private final int COFFEE_BEANS;
    private final int PRICE;

    private CoffeeTypes(String name, int index, int water, int milk, int coffeeBeans, int price) {
        this.name = name;
        this.index = index;
        this.WATER = water;
        this.MILK = milk;
        this.COFFEE_BEANS = coffeeBeans;
        this.PRICE = price;
    }


    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public int getWater() {
        return this.WATER;
    }

    public int getMilk() {
        return this.MILK;
    }

    public int getCoffeeBeans() {
        return this.COFFEE_BEANS;
    }

    public int getPrice() {
        return this.PRICE;
    }

    public static String getAllCoffeeTypesAsOrderedString() {
        StringBuilder sb = new StringBuilder();
        for(CoffeeTypes coffee : values()) {
            sb
                    .append(coffee.index)
                    .append(" - ")
                    .append(coffee.name)
                    .append(", ");
        }
        sb.replace(sb.lastIndexOf(","),sb.length(),"");
        return sb.toString();
    }

    public static CoffeeTypes findCoffeeByIndex(int index) {
        for(CoffeeTypes coffee : values()) {
            if(coffee.index == index) {
                return coffee;
            }
        }
        return null;
    }
}
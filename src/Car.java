public class Car {

    private final String carType;
    private final int productionCost;

    public Car(String carType, int productionCost) {
        this.carType = carType;
        this.productionCost = productionCost;
    }

    public int getProductionCost() {
        return productionCost;
    }

    public String getCarType() {
        return carType;
    }
}

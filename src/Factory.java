import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Factory {

    ArrayList<Car> cars = new ArrayList<>();
    private Car car;
    private int production = 0;
    private int factoryFunds = 3000000;
    private int costOfProduction;
    private int profit;
    private int suv;
    private int sport;
    private int offroad;
    private int tricycle;
    private int days;
    private boolean factoryIsRunning = true;

    public void open() {

        Scanner sc = new Scanner(System.in);

        while (factoryIsRunning) {
            System.out.println("\n1 - START PRODUCTION");
            System.out.println("2 - CHECK REPORT");
            System.out.println("3 - CLOSE FACTORY");

            switch (sc.nextLine()) {
                case "1":
                    startProduction();
                    days++;
                    setFactoryFunds(factoryFunds+profit);
                    System.out.println("Day "+days + " completed. Check your report.");
                    break;
                case "2":
                    checkReport();
                    break;
                case "3":
                    factoryIsRunning = false;
                    break;
            }
            checkFactoryStatus();
        }
    }

        public void startProduction () {

            while (production != 100) {

                int random = probability();

                if (random <= 30) {
                    car = new Car("SUV", 10000); //310000
                    cars.add(car);
                    suv++;
                    setFactoryFunds(factoryFunds - 10000);
                } else if (random <= 60) {
                    car = new Car("SPORTS", 30000); //1080000
                    cars.add(car);
                    sport++;
                    setFactoryFunds(factoryFunds - 30000);
                } else if (random <= 80) {
                    car = new Car("OFFROAD", 20000); //540000
                    cars.add(car);
                    setFactoryFunds(factoryFunds - 20000);
                    offroad++;
                } else if (random <= 100) {
                    car = new Car("TRICYCLE", 5000); //30000
                    cars.add(car);
                    setFactoryFunds(factoryFunds - 5000);
                    tricycle++;
                }

                if (probability() <= 15) {
                    cars.remove(car);
                } else {
                    sellCar(car);
                }

                costOfProduction += car.getProductionCost();
                production++;
            }
        }

        public void setFactoryFunds (int factoryFunds){
            this.factoryFunds = factoryFunds;
        }

        public int probability () {
            Random random = new Random();
            return random.nextInt(100 + 1 - 1) + 1;
        }

        public void sellCar (Car car){
            if (!car.getCarType().equals("TRICYCLE") || car.getCarType() != null) {
                profit = (int) (profit + (car.getProductionCost() + (car.getProductionCost() * 0.2)));
                cars.remove(car);
            }
        }

        public void checkReport () {
            System.out.println("TOTAL PRODUCED VEHICLES: " + production);
            System.out.println();
            System.out.println("SUV: " + suv);
            System.out.println("SPORTS: " + sport);
            System.out.println("OFFROAD: " + offroad);
            System.out.println("TRICYCLE: " + tricycle);
            System.out.println();
            System.out.println("COST OF PRODUCTION: " + costOfProduction);
            System.out.println("PROFIT OF SELL: " + profit);
            System.out.println("FACTORY FUNDS: " + factoryFunds);
        }

        public void checkFactoryStatus() {
            if(factoryFunds >= 6000000) {
                System.out.println("Your factory doubled the initial capital. You don't need to work anymore.");
                factoryIsRunning = false;
            }
                if(days == 30 || factoryFunds <= 0) {
                    System.out.println("Your factory don't have the resources to continue the production.");
                    factoryIsRunning = false;
            }
        }
}

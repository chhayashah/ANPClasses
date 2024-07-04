// Vehicle.java
class Vehicle {
    // Method to be overridden
    public String drive() {
        return "Start the engine and drive carefully";
    }
}

// Car.java
class Car extends Vehicle {
    // Overriding the drive() method for Car
    @Override
    public String drive() {
        return "Buckle up and drive on the road";
    }
}

// Motorcycle.java
class Motorcycle extends Vehicle {
    // Overriding the drive() method for Motorcycle
    @Override
    public String drive() {
        return "Wear a helmet and drive on the highway";
    }
}

// Main.java
public class Drive {
    public static void main(String[] args) {
        // Creating objects of Car and Motorcycle
        Vehicle myCar = new Car();
        Vehicle myMotorcycle = new Motorcycle();
        
        // Calling the drive() method and printing the output
        System.out.println(myCar.drive());        // Output: Buckle up and drive on the road
        System.out.println(myMotorcycle.drive()); // Output: Wear a helmet and drive on the highway
    }
}


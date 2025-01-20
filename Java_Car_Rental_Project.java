import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// Represents a car
class Car {
    private String carId;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean available;

    // Constructor
    public Car(String carId, String brand, String model, double pricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    // Getters
    public String getCarId() { return carId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPricePerDay() { return pricePerDay; }
    public boolean isAvailable() { return available; }

    // Rent the car
    public void rent() { available = false; }

    // Return the car
    public void returnCar() { available = true; }
}

// Main GUI Class
public class CarRentalSystemGUI {
    private List<Car> cars;

    public CarRentalSystemGUI() {
        cars = new ArrayList<>();
        cars.add(new Car("Z001", "Toyota", "Hilux", 95.0));
        cars.add(new Car("Z002", "Honda", "City", 80.0));
        cars.add(new Car("Z003", "Mahindra", "Scorpio", 105.0));
    }

    public void displayGUI() {
        JFrame frame = new JFrame("Car Rental System");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JButton rentButton = new JButton("Rent a Car");
        rentButton.addActionListener(e -> rentCar(outputArea));

        JButton returnButton = new JButton("Return a Car");
        returnButton.addActionListener(e -> returnCar(outputArea));

        JPanel panel = new JPanel();
        panel.add(rentButton);
        panel.add(returnButton);

        frame.add(panel, "North");
        frame.add(scrollPane, "Center");

        frame.setVisible(true);
    }

    private void rentCar(JTextArea outputArea) {
        String carId = JOptionPane.showInputDialog("Enter Car ID:");
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && car.isAvailable()) {
                car.rent();
                outputArea.append("Rented: " + car.getBrand() + " " + car.getModel() + "\n");
                return;
            }
        }
        outputArea.append("Car not available or invalid ID.\n");
    }

    private void returnCar(JTextArea outputArea) {
        String carId = JOptionPane.showInputDialog("Enter Car ID:");
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && !car.isAvailable()) {
                car.returnCar();
                outputArea.append("Returned: " + car.getBrand() + " " + car.getModel() + "\n");
                return;
            }
        }
        outputArea.append("Car not rented or invalid ID.\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarRentalSystemGUI().displayGUI());
    }
}

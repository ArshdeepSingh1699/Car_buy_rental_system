import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }
}

class CarRentalSystemGUI extends JFrame {
    private List<Car> cars;
    private JTextArea outputTextArea;

    public CarRentalSystemGUI(List<Car> cars) {
        this.cars = cars;
        setTitle("Car Rental System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("background.jpg"); // Replace with your image path
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        mainPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.setOpaque(false);
        
        JButton rentButton = new JButton("Rent a Car");
        rentButton.setFont(new Font("Arial", Font.BOLD, 14));
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentCar();
            }
        });

        JButton returnButton = new JButton("Return a Car");
        returnButton.setFont(new Font("Arial", Font.BOLD, 14));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnCar();
            }
        });

        buttonPanel.add(rentButton);
        buttonPanel.add(returnButton);

        outputTextArea = new JTextArea(10, 40);
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void rentCar() {
        String carId = JOptionPane.showInputDialog("Enter Car ID:");
        Car selectedCar = null;
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && car.isAvailable()) {
                selectedCar = car;
                break;
            }
        }
        if (selectedCar != null) {
            selectedCar.rent();
            outputTextArea.append("Car rented: " + selectedCar.getBrand() + " " + selectedCar.getModel() + "\n");
        } else {
            outputTextArea.append("Invalid car ID or car not available for rent.\n");
        }
    }

    private void returnCar() {
        String carId = JOptionPane.showInputDialog("Enter Car ID:");
        Car selectedCar = null;
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && !car.isAvailable()) {
                selectedCar = car;
                break;
            }
        }
        if (selectedCar != null) {
            selectedCar.returnCar();
            outputTextArea.append("Car returned: " + selectedCar.getBrand() + " " + selectedCar.getModel() + "\n");
        } else {
            outputTextArea.append("Invalid car ID or car is not rented.\n");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("C001", "Toyota", "Camry", 60.0));
        cars.add(new Car("C002", "Honda", "Accord", 70.0));
        cars.add(new Car("C003", "Mahindra", "Thar", 150.0));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CarRentalSystemGUI gui = new CarRentalSystemGUI(cars);
                gui.setVisible(true);
            }
        });
    }
}

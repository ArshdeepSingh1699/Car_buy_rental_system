### Java Car Rental System

This Java application provides a basic car rental management system with a graphical user interface (GUI). The system allows users to rent and return cars, with real-time updates displayed in the application window.

#### Features

1. User-Friendly GUI:

Built using Swing components like JFrame, JButton, JTextArea, and JOptionPane for simplicity and easy interactions.

2. Car Management:

Car Information: Each car has a unique ID, brand, model, rental price per day, and availability status.

Cars are stored in a List for efficient management.

3. Renting a Car:

Users can rent a car by entering its unique Car ID.

If the car is available, it is marked as rented, and a success message is displayed in the output area.

If the car is unavailable or the ID is invalid, an error message is displayed.

4. Returning a Car:

Users can return a car by entering its Car ID.

If the car was previously rented, it is marked as available, and a success message is displayed.

If the car is not rented or the ID is invalid, an error message is shown.

5. Real-Time Output Display:

A JTextArea in the GUI displays messages about rental or return operations, keeping users informed of their actions.

6. Data Validation:

Ensures only valid Car IDs are processed for renting or returning operations.

7. Preloaded Cars:

Three sample cars (Toyota Camry, Honda Accord, Mahindra Thar) are preloaded with unique IDs and rental prices for demonstration.

8. Simple and Clear Structure:

Methods are self-contained (rentCar, returnCar) and easy to understand.

Minimal layout complexity ensures focus on functionality.

9. Platform-Independent:

Written in Java, it runs on any system with the Java Runtime Environment (JRE).

10. Scalability:

The List<Car> structure allows easy addition of more cars to the system.


#### Getting Started

1. **Prerequisites**: Ensure you have Java Development Kit (JDK) installed.
2. **Compile and Run**:
   ```bash
   javac Main.java
   java Main
   ```
3. **Usage**: Interact with the GUI to rent or return cars by entering their IDs as prompted.

This application is a basic demonstration and can be extended with more advanced features such as persistent data storage, more detailed car information, and user authentication.

### Java Car Rental System

This Java application provides a basic car rental management system with a graphical user interface (GUI). The system allows users to rent and return cars, with real-time updates displayed in the application window.

#### Features

- **Car Management**: A `Car` class encapsulates car details, rental pricing, and availability, including methods for renting and returning cars.
- **Graphical User Interface (GUI)**: The `CarRentalSystemGUI` class, built using Java Swing, provides an interactive interface for managing car rentals.
- **User Interaction**: Users can rent or return cars by entering a car ID through input dialogs, with the status and actions displayed in a text area.
- **Data Display**: Actions are logged in a `JTextArea` within a `JScrollPane`, giving users a clear view of current transactions.
- **Application Initialization**: The `Main` class sets up initial car data and launches the GUI using `SwingUtilities.invokeLater` to ensure thread-safe operations.

#### Getting Started

1. **Prerequisites**: Ensure you have Java Development Kit (JDK) installed.
2. **Compile and Run**:
   ```bash
   javac Main.java
   java Main
   ```
3. **Usage**: Interact with the GUI to rent or return cars by entering their IDs as prompted.

This application is a basic demonstration and can be extended with more advanced features such as persistent data storage, more detailed car information, and user authentication.

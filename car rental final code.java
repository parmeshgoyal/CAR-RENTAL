import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

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

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public double calculateTotalPrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public void rent() {
        isAvailable = false;
    }
}

class Customer {
    private String customerId;
    private String name;
    private String mobileNumber;
    private String address;
    private String drivingLicense;

    public Customer(String customerId, String name, String mobileNumber, String address, String drivingLicense) {
        this.customerId = customerId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.drivingLicense = drivingLicense;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }
}

class Rental {
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}

class RentalSlipGUI extends JFrame {
    public RentalSlipGUI(Rental rental, double totalPrice) {
        super("Rental Slip");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Car: " + rental.getCar().getBrand() + " " + rental.getCar().getModel()));
        panel.add(new JLabel("Rental Days: " + rental.getDays()));
        panel.add(new JLabel("Total Price: ₹" + totalPrice));
        panel.add(new JLabel("Customer Name: " + rental.getCustomer().getName()));
        panel.add(new JLabel("Mobile Number: " + rental.getCustomer().getMobileNumber()));
        panel.add(new JLabel("Driving License: " + rental.getCustomer().getDrivingLicense()));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        panel.add(closeButton);

        add(panel);
        setVisible(true);
    }
}

class CarRentalGUI extends JFrame {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    private JPanel personalDetailsPanel;
    private JPanel carSelectionPanel;

    private JComboBox<String> carComboBox;
    private JTextField daysTextField;
    private JTextField nameTextField;
    private JTextField mobileTextField;
    private JTextField addressTextField;
    private JTextField drivingLicenseTextField;
    private JLabel totalPriceLabel;

    public CarRentalGUI() {
        super("Car Rental System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();

        // Add some sample Indian cars
        cars.add(new Car("C001", "Maruti Suzuki", "Swift", 3000.0));
        cars.add(new Car("C002", "Hyundai", "Creta", 4000.0));
        cars.add(new Car("C003", "Tata", "Nexon", 3500.0));
        cars.add(new Car("C004", "Kia", "Seltos", 4500.0));
        cars.add(new Car("C005", "Mahindra", "XUV700", 5000.0));
        cars.add(new Car("C006", "Renault", "Duster", 3750.0));

        createPersonalDetailsPanel();
        createCarSelectionPanel();
        showPersonalDetailsPanel();
    }

    private void createPersonalDetailsPanel() {
        personalDetailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        personalDetailsPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        nameTextField = new JTextField(10);
        personalDetailsPanel.add(nameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        personalDetailsPanel.add(new JLabel("Mobile Number:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        mobileTextField = new JTextField(10);
        personalDetailsPanel.add(mobileTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        personalDetailsPanel.add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        addressTextField = new JTextField(10);
        personalDetailsPanel.add(addressTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        personalDetailsPanel.add(new JLabel("Driving License:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        drivingLicenseTextField = new JTextField(10);
        personalDetailsPanel.add(drivingLicenseTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> showCarSelectionPanel());
        personalDetailsPanel.add(nextButton, gbc);
    }

    private void createCarSelectionPanel() {
        carSelectionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        carSelectionPanel.add(new JLabel("Available Cars:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        carComboBox = new JComboBox<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                String carInfo = String.format("%s %s - ₹%.2f per day", car.getBrand(), car.getModel(), car.getBasePricePerDay());
                carComboBox.addItem(carInfo);
            }
        }
        carSelectionPanel.add(carComboBox, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        carSelectionPanel.add(new JLabel("Total Price:"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        totalPriceLabel = new JLabel();
        carSelectionPanel.add(totalPriceLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        carSelectionPanel.add(new JLabel("Rental Days:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        daysTextField = new JTextField(10);
        carSelectionPanel.add(daysTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        JButton rentButton = new JButton("Rent");
        rentButton.addActionListener(e -> rentCar());
        carSelectionPanel.add(rentButton, gbc);
    }

    private void showPersonalDetailsPanel() {
        setTitle("Personal Details");
        getContentPane().removeAll();
        add(personalDetailsPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void showCarSelectionPanel() {
        setTitle("Car Selection");
        getContentPane().removeAll();
        add(carSelectionPanel, BorderLayout.CENTER);

        // Update the price label to show the price of the selected car
        int selectedIndex = carComboBox.getSelectedIndex();
        if (selectedIndex >= 0) {
            String daysStr = daysTextField.getText();
            if (!daysStr.isEmpty()) {
                int rentalDays = Integer.parseInt(daysStr);
                if (rentalDays > 0) {
                    Car selectedCar = cars.get(selectedIndex);
                    double totalPrice = selectedCar.calculateTotalPrice(rentalDays);
                    totalPriceLabel.setText(String.format("₹%.2f", totalPrice));
                }
            }
        }

        revalidate();
        repaint();
    }

    private void rentCar() {
        int selectedIndex = carComboBox.getSelectedIndex();
        if (selectedIndex >= 0) {
            String name = nameTextField.getText();
            String mobileNumber = mobileTextField.getText();
            String address = addressTextField.getText();
            String drivingLicense = drivingLicenseTextField.getText();
            String daysStr = daysTextField.getText();
            if (!name.isEmpty() && !mobileNumber.isEmpty() && !address.isEmpty() && !drivingLicense.isEmpty() && !daysStr.isEmpty()) {
                int rentalDays = Integer.parseInt(daysStr);
                if (rentalDays > 0) {
                    Car selectedCar = cars.get(selectedIndex);
                    double totalPrice = selectedCar.calculateTotalPrice(rentalDays);
                    totalPriceLabel.setText(String.format("₹%.2f", totalPrice));

                    // Create the customer object
                    Customer customer = new Customer("", name, mobileNumber, address, drivingLicense);

                    // Rent the car and update the GUI
                    selectedCar.rent();
                    carComboBox.removeItemAt(selectedIndex);
                    clearFields();
                    showPersonalDetailsPanel(); // Go back to personal details panel after renting

                    // Create rental object
                    Rental rental = new Rental(selectedCar, customer, rentalDays);

                    // Display rental slip
                    new RentalSlipGUI(rental, totalPrice);
                } else {
                    JOptionPane.showMessageDialog(this, "Rental days should be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a car to rent.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameTextField.setText("");
        mobileTextField.setText("");
        addressTextField.setText("");
        drivingLicenseTextField.setText("");
        daysTextField.setText("");
        totalPriceLabel.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarRentalGUI gui = new CarRentalGUI();
            gui.setVisible(true);
        });
    }
}
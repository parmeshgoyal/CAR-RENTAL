# 🚗 Car Rental System

A Java-based Car Rental System built as an academic project, featuring two modes of interaction — a **command-line (terminal) interface** and a **graphical user interface (GUI)** built with Java Swing.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Core Classes](#core-classes)
- [Versions](#versions)
  - [Terminal Version](#terminal-version-mainjava)
  - [Basic GUI Version](#basic-gui-version-car-rental-guitxt)
  - [Final GUI Version (Recommended)](#final-gui-version-car-rental-final-codejava)
- [Prerequisites](#prerequisites)
- [How to Run](#how-to-run)
  - [Running the Terminal Version](#running-the-terminal-version)
  - [Running the GUI Version](#running-the-gui-version)
  - [Using NetBeans IDE](#using-netbeans-ide)
- [Sample Cars Included](#sample-cars-included)
- [Usage Walkthrough](#usage-walkthrough)
- [Screenshots](#screenshots)
- [Documentation](#documentation)
- [Technologies Used](#technologies-used)

---

## Overview

This is a **Java desktop application** that simulates a car rental service. It was developed as a Java programming course project. The system allows users to browse available cars, provide customer details, select a car, specify a rental duration, and receive a rental slip with the total cost.

The project evolved through multiple iterations — starting from a simple terminal-based menu system all the way to a full Swing-based GUI with a multi-step form flow and a printable rental slip dialog.

---

## Features

### Terminal Version
- 📋 View list of all available cars
- 🔑 Rent a car by entering car ID and number of days
- 🔁 Return a previously rented car
- 💵 Automatic price calculation based on daily rate × rental days
- ✅ Rental confirmation prompt before finalizing

### GUI Version (Final)
- 🖥️ Clean Swing-based graphical interface
- 📝 **Step 1 – Personal Details Form**: Collects customer name, mobile number, address, and driving license number
- 🚘 **Step 2 – Car Selection**: Dropdown showing all available cars with daily rates (₹)
- 💰 Live total price calculation
- 🧾 **Rental Slip Dialog**: Displays a summary popup with all rental details after booking
- ✅ Input validation with user-friendly error messages
- 🔄 Available car list updates dynamically after each rental

---

## Project Structure

```
CAR-RENTAL/
│
├── Main.java                        # Terminal/CLI version (entry point: Main class)
├── car rental final code.java       # Final GUI version (entry point: CarRentalGUI)
├── best code car rental.java        # Intermediate GUI version
├── car rental gui.txt               # Early GUI prototype
├── car rent terminal.java           # Early terminal prototype
│
├── build.xml                        # Apache Ant build script (NetBeans project)
├── manifest.mf                      # JAR manifest file
├── carproject.rar                   # Archived NetBeans project
│
├── Assets/                          # Screenshots of the running application
│   ├── personal_details.png
│   ├── car_selection.png
│   └── rental_slip.png
│
├── JAVA PROJECT REPORT.docx         # Project report (Word format)
├── JAVA_PROJECT_REPORT .pdf         # Project report (PDF format)
└── JAVA PROJECT.pptx                # Project presentation (PowerPoint)
```

---

## Core Classes

All versions of the project share the same three core domain classes:

### `Car`
Represents a rental vehicle.

| Field              | Type      | Description                        |
|--------------------|-----------|-------------------------------------|
| `carId`            | `String`  | Unique identifier (e.g., `C001`)   |
| `brand`            | `String`  | Car manufacturer (e.g., `Toyota`)  |
| `model`            | `String`  | Car model name (e.g., `Camry`)     |
| `basePricePerDay`  | `double`  | Daily rental rate                  |
| `isAvailable`      | `boolean` | Rental availability status         |

Key methods: `calculatePrice(int days)`, `rent()`, `returnCar()`, `isAvailable()`

---

### `Customer`
Represents a customer renting a car.

| Field             | Type     | Description                              |
|-------------------|----------|------------------------------------------|
| `customerId`      | `String` | Auto-generated ID (e.g., `CUS1`)         |
| `name`            | `String` | Customer's full name                     |
| `mobileNumber`    | `String` | Contact number *(GUI version only)*      |
| `address`         | `String` | Residential address *(GUI version only)* |
| `drivingLicense`  | `String` | DL number *(GUI version only)*           |

---

### `Rental`
Links a `Car`, a `Customer`, and the number of rental days together.

| Field      | Type       | Description             |
|------------|------------|-------------------------|
| `car`      | `Car`      | The rented car object   |
| `customer` | `Customer` | The customer object     |
| `days`     | `int`      | Number of rental days   |

---

### `CarRentalSystem` *(Terminal version only)*
Manages the collections of cars, customers, and rentals. Exposes `rentCar()`, `returnCar()`, and `menu()` methods.

### `CarRentalGUI` *(GUI versions)*
Extends `JFrame`. Manages the full GUI lifecycle — panels, combo box population, form validation, and rental logic.

### `RentalSlipGUI` *(Final GUI version only)*
A secondary `JFrame` that pops up after a successful rental showing the full booking summary.

---

## Versions

### Terminal Version — `Main.java`

The simplest version. Runs entirely in the console with a numbered menu.

**Pre-loaded cars:**
| ID   | Brand    | Model  | Rate/Day |
|------|----------|--------|----------|
| C001 | Toyota   | Camry  | $60.00   |
| C002 | Honda    | Accord | $70.00   |
| C003 | Mahindra | Thar   | $150.00  |

---

### Basic GUI Version — `car rental gui.txt`

An early Swing GUI prototype. Single-panel layout with a car dropdown, rental days input, and a Rent button. No customer details collected.

---

### Final GUI Version (Recommended) — `car rental final code.java`

The most complete version. Features a two-panel flow:
1. **Personal Details Panel** — Name, Mobile, Address, Driving License
2. **Car Selection Panel** — Dropdown, Rental Days, Live Price, Rent Button

After booking, a **Rental Slip** popup appears with full details.

**Pre-loaded Indian cars:**
| ID   | Brand          | Model   | Rate/Day |
|------|----------------|---------|----------|
| C001 | Maruti Suzuki  | Swift   | ₹3,000   |
| C002 | Hyundai        | Creta   | ₹4,000   |
| C003 | Tata           | Nexon   | ₹3,500   |
| C004 | Kia            | Seltos  | ₹4,500   |
| C005 | Mahindra       | XUV700  | ₹5,000   |
| C006 | Renault        | Duster  | ₹3,750   |

---

## Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- **Java Runtime Environment (JRE)** for running compiled `.class` files
- *(Optional)* **Apache NetBeans IDE** — the project includes a `build.xml` Ant script compatible with NetBeans

Verify your Java installation:
```bash
java -version
javac -version
```

---

## How to Run

### Running the Terminal Version

```bash
# Compile
javac Main.java

# Run
java Main
```

### Running the GUI Version

The final GUI version (`car rental final code.java`) has a space in its filename. Rename it first:

```bash
# Rename the file (Windows)
rename "car rental final code.java" CarRentalFinal.java
```

> **Note:** Also update the class name inside the file to match (the main class is already `CarRentalGUI`).

```bash
# Compile
javac CarRentalFinal.java

# Run
java CarRentalGUI
```

### Using NetBeans IDE

1. Unzip `carproject.rar` to a local directory.
2. Open **NetBeans IDE**.
3. Go to **File → Open Project** and select the extracted `carproject` folder.
4. Click **Run Project** (F6) or use the **Build** toolbar.

---

## Usage Walkthrough

### Terminal Version
```
===== Car Rental System =====
1. Rent a Car
2. Return a Car
3. Exit
Enter your choice: 1

== Rent a Car ==
Enter your name: John Doe

Available Cars:
C001 - Toyota Camry
C002 - Honda Accord
C003 - Mahindra Thar

Enter the car ID you want to rent: C002
Enter the number of days for rental: 3

== Rental Information ==
Customer ID: CUS1
Customer Name: John Doe
Car: Honda Accord
Rental Days: 3
Total Price: $210.00

Confirm rental (Y/N): Y

Car rented successfully.
```

### GUI Version Flow

1. **Launch** the application → Personal Details form appears.
2. **Fill in** your Name, Mobile Number, Address, and Driving License number.
3. Click **Next** → Car Selection panel appears.
4. **Choose** a car from the dropdown and enter the number of rental days.
5. Click **Rent** → A **Rental Slip** dialog pops up with all booking details.
6. Click **Close** on the slip → You are returned to the Personal Details form for the next customer.

---

## 📸 Screenshots

### Step 1 — Personal Details
![Personal Details Form](https://raw.githubusercontent.com/parmeshgoyal/CAR-RENTAL/main/Assets/personal_details.png)

### Step 2 — Car Selection
![Car Selection Panel](https://raw.githubusercontent.com/parmeshgoyal/CAR-RENTAL/main/Assets/car_selection.png)

### Step 3 — Rental Slip
![Rental Slip Dialog](https://raw.githubusercontent.com/parmeshgoyal/CAR-RENTAL/main/Assets/rental_slip.png)

---

## Documentation

The repository includes supporting academic documents:

| File | Description |
|------|-------------|
| `JAVA PROJECT REPORT.docx` | Detailed project report in Word format |
| `JAVA_PROJECT_REPORT .pdf` | Same report in PDF format |
| `JAVA PROJECT.pptx` | Project presentation slides |

---

## Technologies Used

| Technology | Purpose |
|------------|---------|
| **Java SE** | Core programming language |
| **Java Swing** (`javax.swing`) | GUI framework for desktop interface |
| **Java AWT** (`java.awt`) | Layout managers and event handling |
| **Apache Ant** | Build automation (`build.xml`) |
| **NetBeans IDE** | Development environment (project structure) |
| **ArrayList / List** | In-memory data storage for cars, customers, rentals |

---

## Author

**Parmesh Goyal**  
[GitHub Profile](https://github.com/parmeshgoyal)

---

> *This project was developed as part of a Java programming course to demonstrate object-oriented programming concepts including encapsulation, class design, collections, event-driven programming, and GUI development with Swing.*

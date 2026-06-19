# 🏛️ System Design & Low-Level Design (LLD) in Java

Welcome to the **System Design and Low-Level Design (LLD)** repository! This repository serves as a comprehensive resource for understanding, implementing, and practicing object-oriented design principles, classic design patterns, and full-scale LLD case studies in Java.

---

## 📂 Repository Structure

The codebase is organized into two primary sections: classic **Design Patterns** and a production-grade **Parking Lot LLD case study**.

```
System Design/
│
├── FactoryPatterns.pdf          # Slides and documentation on Factory Patterns
├── FactoryPatterns.pptx         # Editable presentation on Factory Design Patterns
│
└── LLD/                         # Low-Level Design Implementations
    ├── LLD.iml
    └── src/
        ├── DesignPatterns/      # Core Gang of Four (GoF) Design Patterns
        │   ├── AbstractFactory/ # Factory of factories pattern (Hyundai/Maruti Car factory)
        │   ├── Builder/         # Constructing complex objects step-by-step
        │   ├── FactoryMethod/   # Creation framework allowing subclass decisions
        │   ├── Observer/        # Weather monitoring system with pub-sub mechanics
        │   ├── Prototype/       # Object cloning pattern for vehicles/cars
        │   ├── SingleTon/       # Thread-safe double-checked lock Singleton
        │   └── Strategy/        # Dynamic payment strategy routing
        │
        └── ParkingLot/          # Concurrency-Aware Parking Lot Case Study
            ├── Client.java      # Entry point / Concurrent Simulation test-harness
            ├── Enums/           # VehicleType, PaymentType, PricingStrategyType, etc.
            ├── Factory/         # Factories for Vehicles, Payments, and Pricing Strategies
            ├── Models/          # Object-Oriented Domain Entities (Gates, Spots, Tickets, etc.)
            ├── Service/         # Core Services (ParkingLot manager, PaymentProcessor)
            └── Strategy/        # Dynamic Spot-Allocation and Parking-Pricing Algorithms
```

---

## 🎨 Implemented Design Patterns

Here is a summary of the design patterns implemented inside `LLD/src/DesignPatterns/`:

| Pattern | Category | Use Case & Description | Key Package Location |
| :--- | :--- | :--- | :--- |
| **Abstract Factory** | Creational | Creates families of related objects (Engine, Tyres, Dashboard) without specifying concrete classes. Models `HyundaiFactory` and `MarutiFactory`. | [AbstractFactory](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/DesignPatterns/AbstractFactory) |
| **Factory Method** | Creational | Defines an interface for creating an object, letting subclasses decide which class to instantiate. | [FactoryMethod](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/DesignPatterns/FactoryMethod) |
| **Builder** | Creational | Separates the construction of a complex object (`Car`) from its representation, allowing step-by-step creation. | [Builder](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/DesignPatterns/Builder) |
| **Prototype** | Creational | Clones existing objects (`Car`, `Vehicle`) rather than creating them from scratch, optimizing resource footprint. | [Prototype](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/DesignPatterns/Prototype) |
| **Singleton** | Creational | Ensures a class has only one instance and provides a global point of access. Implemented with **Double-Checked Locking** for thread safety. | [SingleTon](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/DesignPatterns/SingleTon) |
| **Observer** | Behavioral | Implements a subscription mechanism (Pub-Sub) to notify multiple observers (WebSite, Email, WhatsApp) of weather changes. | [Observer](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/DesignPatterns/Observer) |
| **Strategy** | Behavioral | Defines a family of algorithms, encapsulates each one, and makes them interchangeable at runtime. Used for Payment Routing. | [Strategy](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/DesignPatterns/Strategy) |

---

## 🚗 LLD Case Study: Concurrency-Aware Parking Lot

The `ParkingLot` system is a fully realized low-level design case study implementing OOP principles (SOLID), design patterns, and thread-safe operations.

### Key Features
1. **Multi-Floor & Multi-Spot Support**: Handles parking allocation for various vehicle types (Bikes, Cars, and Trucks).
2. **Dynamic Pricing Strategy**: Calculates fees dynamically using a `PricingStrategy` (e.g., time-based pricing) powered by the **Strategy Pattern**.
3. **Flexible Payment Integration**: Supports multiple payment modes (Cash, Card, UPI) processed through a factory-based `PaymentProcessor`.
4. **Thread-Safe Allocation**: Uses Atomic variables to prevent double-booking of parking spots under concurrent parking requests.

---

## ⚙️ How to Run

### Prerequisites
* Java Development Kit (JDK) 8 or higher
* An IDE such as IntelliJ IDEA or Eclipse

### Running the Parking Lot Simulation
To run the simulation which demonstrates multi-threaded parking requests:
1. Navigate to `LLD/src/ParkingLot/`.
2. Open and run the [Client.java](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/ParkingLot/Client.java) file.

---

## 💡 Developer Notes & Concurrency Analysis

### 🔒 Thread-Safe Spot Allocation
In [ParkingSpot.java](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/ParkingLot/Models/Parking/ParkingSpot.java), thread safety is implemented to prevent race conditions when multiple gates try to occupy the same spot simultaneously:
```java
public AtomicBoolean occupied = new AtomicBoolean(false);

public boolean tryOccupy(){
    return occupied.compareAndExchange(false, true);
}
```

> [!WARNING]
> **Important Concurrency Note**:
> `AtomicBoolean.compareAndExchange(expectedValue, newValue)` returns the **witness value** (the value *before* the attempted transition).
> * If the spot was free (`false`), `compareAndExchange` successfully changes it to `true` and returns **`false`**.
> * If the spot was already occupied (`true`), the swap fails and it returns **`true`**.
>
> In [ParkingLot.java](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/ParkingLot/Service/ParkingLot.java#L55), the spot-occupancy check expects a truthy result:
> `if(spot != null && spot.tryOccupy())`
>
> Since successful acquisition returns `false` (the witness value), this logic will fail to park the vehicle and might allow booking on an occupied spot instead. To align this with standard boolean checks, consider updating [ParkingSpot.java](file:///c:/YASHIT/java_lec/System%20Design/LLD/src/ParkingLot/Models/Parking/ParkingSpot.java#L21-L23) to use **`compareAndSet`**:
> ```java
> public boolean tryOccupy(){
>     return occupied.compareAndSet(false, true); // Returns true on success
> }
> ```

---

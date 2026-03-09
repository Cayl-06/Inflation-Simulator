# 📊 Inflation & Cost of Living Simulator

Welcome to the **Inflation & Cost of Living Simulator**, a terminal-based strategy game designed to model the economic challenges of surviving in the Philippines. This project demonstrates core **Object-Oriented Programming (OOP)** principles while simulating real-world financial pressures.

---

## 📝 The Concept

In this simulation, you take on the role of a household head managing a budget over a set number of days. As time passes, **inflation** causes the price of goods—like Rice, Meat, and Transportation—to rise.

Your goal is simple but difficult: **Survive the duration without going broke while meeting your daily survival needs.**

### 🏠 Choose Your Household

Every player starts with a different financial standing, affecting their strategy:

* **Low Income (₱5,000):** Stricter limits; every peso counts.
* **Middle Income (₱12,000):** A balance between essentials and potential savings.
* **High Income (₱25,000):** More flexibility, but higher expectations.

---

## 🎮 Gameplay Mechanics

### 1. The Daily Loop

Each day, the market opens with updated prices. You must navigate the menu to purchase items.

* **Inflation:** Prices increase by a set percentage (default 5%) every day.
* **Market Shortages:** Random events (like a Rice shortage) can cause specific prices to spike unexpectedly.

### 2. Survival Constraints

To "survive" a day, your household must purchase at least:

1. **One Food Item** (e.g., Rice, Meat, Vegetables)
2. **One Transport Item** (e.g., Jeepney fare, Fuel)

### 3. Scoring System 🏆

Your performance is tracked through a **Survival Score**.

* **+20 Points:** Meeting both Food and Transport needs for the day.
* **-10 Points:** Failing to secure an essential category.
* **Bonus Points:** Awarded at the end of the simulation for remaining savings and avoiding debt.

---

## 💻 Technical Architecture (OOP)

This project is built using a modular approach, divided into three main packages:

* **`household` (Inheritance & Polymorphism):** Manages budget logic and unique household behaviors.
* **`market` (Encapsulation):** Handles product data, price updates, and the inflation calculator math.
* **`simulation` (Abstraction & Exception Handling):** The "brain" of the game. It manages the loop and uses `try-catch` blocks to prevent the simulation from crashing when a user overspends.

---

## 🚀 How to Run

1. **Navigate** to the `src` directory in your terminal.
2. **Compile** the code:
```bash
javac Main.java

```


3. **Run** the simulation:
```bash
java Main

```



---

## 🛠️ Requirements

* **Java Development Kit (JDK)** 8 or higher.
* A terminal/command prompt that supports text input.

---

## 📈 Win/Loss Conditions

* **WIN:** Successfully complete all simulated days with a positive budget.
* **LOSS:** Your budget hits ₱0 (Bankruptcy) or you consistently fail to meet survival needs, leading to a failing Survival Score.

---

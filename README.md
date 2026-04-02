# 🃏 Blackjack Game (JavaFX)

A fully interactive **Blackjack desktop application** built using **Java and JavaFX**, featuring real-time gameplay, betting mechanics, and a graphical user interface.

Developed as part of a Software Development & Network Engineering program.

---

## 🚀 Features

* 🎮 **Full Blackjack Gameplay**

  * Hit, Stand, Deal functionality
  * Dealer logic (hits until 17)
  * Automatic win/loss detection

* 💰 **Betting System**

  * Interactive betting UI using JavaFX
  * Dynamic bet tracking and result calculation
  * Payout logic (Blackjack, win, loss, tie)

* 🖥️ **Graphical User Interface**

  * Built with **JavaFX**
  * Real-time card rendering using images
  * Clean and responsive layout

* 🧠 **Game Logic**

  * Object-oriented design (Dealer, Player, Card, Deck)
  * Hand value calculation (including Ace handling)
  * Game state management

---

## 🏗️ Project Structure

```
blackjack/
│
├── BlackjackUI.java        # Main JavaFX application (UI + game flow)
├── Dealer.java             # Dealer logic (hit, play, rules)
├── Card.java               # Card model (suit, value, image handling)
├── bettingController.java  # Betting system logic (FXML controller)
├── bettingApp.java         # Betting window launcher
│
└── resources/
    └── cards/              # Card images used in the UI
```

---

## 🧩 Key Components

### 🃏 Card System

* Uses enums for **Suit** and **Value**
* Dynamically loads card images from local resources
* Handles Blackjack values (Face cards = 10, Ace = 11)

### 🤖 Dealer Logic

* Automatically plays according to Blackjack rules:

  * Hits until hand value ≥ 17
* Manages its own hand and UI updates

### 🎯 Game Controller (UI)

* Handles:

  * Player actions (Hit, Stand, Deal)
  * Game state transitions
  * Result calculation and display

### 💸 Betting सिस्टम

* JavaFX-based popup window
* Slider-based bet selection
* Confirmation dialogs for user interaction

---

## 🛠️ Technologies Used

* **Java**
* **JavaFX**
* **FXML**
* **Object-Oriented Programming (OOP)**

---

## ▶️ How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/blackjack-game.git
   ```

2. Open in IDE (IntelliJ / Eclipse recommended)

3. Ensure JavaFX is properly configured:

   * Add JavaFX SDK
   * Set VM options if needed:

     ```
     --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml
     ```

4. Run:

   ```
   BlackjackUI.java
   ```

---

## 📸 Screenshots

### 🎮 Gameplay
<img src="FINAL_PROJECT_BLACKJACK/Blackjack_Group/Screenshots/BlackJAck1.png" width="500"/>

### 💰 Betting System
<img src="FINAL_PROJECT_BLACKJACK/Blackjack_Group/Screenshots/BlackJAck2.png" width="500"/>

### 🏆 Game Result
<img src="FINAL_PROJECT_BLACKJACK/Blackjack_Group/Screenshots/BlackJack3.png" width="500"/>

### 🃏 Dealer Play
<img src="FINAL_PROJECT_BLACKJACK/Blackjack_Group/Screenshots/BlackJack4.png" width="500"/>

---

## 👨‍💻 Author

**Justin Kadyrov**
Software Development & Network Engineering Graduate



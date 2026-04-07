# 🃏 Blackjack – Desktop Game

## 📸 Preview

<p align="center">
  <img src="FINAL_PROJECT_BLACKJACK/Blackjack_Group/Screenshots/BlackJAck1.png" width="24%"/>
  <img src="FINAL_PROJECT_BLACKJACK/Blackjack_Group/Screenshots/BlackJAck2.png" width="24%"/>
  <img src="FINAL_PROJECT_BLACKJACK/Blackjack_Group/Screenshots/BlackJack3.png" width="24%"/>
  <img src="FINAL_PROJECT_BLACKJACK/Blackjack_Group/Screenshots/BlackJack4.png" width="24%"/>
</p>

---

## Blackjack

This is a fully interactive Blackjack desktop application I built using Java and JavaFX.

The goal of this project was to recreate a classic casino experience with a clean UI while learning object-oriented design, UI development, and game logic. It includes everything from real gameplay mechanics to betting and user accounts.

---

##  Features

**Blackjack Gameplay**
  - Hit, Stand, and Deal functionality  
  - Dealer follows real rules (hits until 17)  
  - Automatic win/loss/tie detection  

**Betting System**
  - Place and track bets in real-time  
  - Handles payouts (win, loss, blackjack, tie)  
  - Balance updates dynamically  

**User Authentication**
  - Login and registration system  
  - File-based user storage  
  - Input validation and alerts  

**Graphical UI**
  - Built using JavaFX  
  - Real-time card rendering with images  
  - Clean and responsive layout  

**Game Logic**
  - Fully object-oriented design  
  - Accurate hand value calculations (Ace handling)  
  - Game state management  

---

---

## 🏗️ Project Structure

```id="full-structure"
blackjack/
│
├── Main_Login.java         # Entry point (launches login screen)
├── LoginController.java   # Handles login & registration logic
│
├── BlackjackUI.java       # Main JavaFX game UI & controller
├── bettingApp.java        # Betting window launcher
├── bettingController.java # Betting system logic
│
├── Player.java            # Player logic (hit, score, UI updates)
├── Dealer.java            # Dealer AI logic (rules-based play)
├── Hand.java              # Manages player/dealer hands & values
├── Deck.java              # Deck creation, shuffle, and dealing
├── Card.java              # Card model (suit, value, images)
│
└── resources/
    ├── cards/             # Card images used in UI
    └── blackjack.fxml     # UI layout files (FXML)
```

---











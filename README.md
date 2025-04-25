# 🌿 Plantain Presidio

**Plantain Presidio** is a text-based adventure game where you try to escape and interconnected chamber by finding plantain chips, fighting enemies, and searching for heals.

Originally created by me and a friend, I recently tweaked, improved the code, and added more features for clarity and easier execution.

---

## 🎮 Game Overview

- Move through rooms using W, A, S, D
- Fight enemies, heal up, and collect enough plantain chips
- Gather 5 plantain chips to unlock the exit.
- Your goal is to escape the chamber your brother trapped you in!

---

## 🛠️ Running in Eclipse (Recommended)

This project is structured to work smoothly in Eclipse.

### Steps:

1. Open Eclipse.
2. Go to **File > Open Projects from File System**.
3. Choose the root project folder (`Plantain presidio`).
4. Eclipse will recognize the `src` directory as the source folder.
5. Navigate to `Main.java` inside the `plantainPresidio` package.
6. Click the green **Run** button to start the game.

---

## 💻 Running Manually in VS Code or Terminal

If you're using VS Code or running from terminal, follow these steps:

### 1. Navigate into the `src` directory:

The file structure should look like this:

**Plantain-presidio/ <---- You are here**
└── src/
    └── plantainPresidio/
        ├── DefaultRoom.java
        ├── EnemyRoom.java
        ├── HealingRoom.java
        ├── Main.java
        ├── Player.java
        ├── Script.java
        ├── SpecialRoom.java
        ├── StarterRoom.java
        └── … other .java files

In the terminal change your directory to src:

cd src

### 2. Compile the code:

Once inside, you can compile the .java files using this command:

javac *.java

### 2. Run the code:

You can then run the program using this command:

java Main
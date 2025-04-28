# TicToeProject using Java (JavaSwing + Mariadb)
This _overengineered_ TicTacToe game is a showcase of my Java Literacy.

To run it make sure you have **MariaDB** or vanilla **MySQL** installed in your system along with **Java**.

## Creating Database
First Create the Database :
```sql
CREATE DATABASE IF NOT EXISTS tictactoe;

USE tictactoe;

CREATE TABLE IF NOT EXISTS playerInfo (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Password VARCHAR(255),
    Point INT DEFAULT 0
);
```

## Compiling and running
Use these command to run (Pro Tip: Always put your binaries on a separate folder such as bin/)
```bash
cd Projects_path
javac -d bin -cp "lib/mysql-connector-java.jar:src" src/Main.java
java -cp "lib/mysql-connector-java.jar:bin" ui/Main
```

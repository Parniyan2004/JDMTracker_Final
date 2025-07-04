# JDM Tracker System (Digital CMAS Monitoring)

A Java-based CLI application designed to assist with tracking CMAS scores and exercises for patients diagnosed with Juvenile Dermatomyositis (JDM). This tool allows adding new patients, assigning exercises, entering CMAS results, and viewing patient data via a simple terminal-based interface.



## Features

- Register new patients with name and age  
- Assign exercise tasks with description and date  
- Add CMAS scores manually  
- View patient’s progress and test history  
- Command-Line Interface (CLI)  
- Stores and reads data from a local SQLite database (`jdm.db`)  
- Imports CSV data from the `PatientX` dataset using DB Browser for SQLite  


## Background

**Juvenile Dermatomyositis (JDM)** is a rare autoimmune disease affecting muscles in children.  
**CMAS** (Childhood Myositis Assessment Scale) is a physical test used to track disease severity.

This system helps:
- Simplify data recording at home  
- Store test results digitally  
- Provide access to CMAS reports in one place  


## Project Structure

JDM_TRACKER_PROJECT/

├── src/

│ ├── main/ # Entry point (Main.java)

│ ├── dao/ # Database access (PatientDAO, ExerciseDAO, ReportDAO)

│ └── model/ # Data models (Patient, Exercise, Report)

├── lib/ # SQLite JDBC driver

├── out/ # Compiled classes

├── jdm.db # SQLite database (imported PatientX dataset)

├── README.md # This file

└── Report_Project_JDM.pdf # Final report


## How to Run

### Requirements
- Java 17 or higher  
- SQLite JDBC driver (included in `lib/`)  
- DB Browser for SQLite (for importing CSV)  


```bash
Step 1 – Compile:
javac -d out -cp "src/main/lib/sqlite-jdbc-3.50.2.0.jar" src/dao/*.java src/model/*.java src/main/*.java

Step 2 – Run:
```bash
java -cp "src/main/lib/sqlite-jdbc-3.50.2.0.jar;out" main.Main

```
## Dataset

Dataset used from PatientX folder includes:

Patient basic info 

CMAS scores 


## Use-Cases Implemented
Add and view patient profiles

Assign exercises to patients

Add CMAS scores

View reports by patient


## Technologies Used
Java 17

SQLite + JDBC

Visual Studio Code

DB Browser for SQLite

## License

This project was developed as part of the “Introduction to Software Engineering” course at ZUYD University (ADSAI 2025) by Zahra Amiri.





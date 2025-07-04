package main;
import dao.*;
import model.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for CLI-based interaction with JDM Monitoring System.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Database.initialize();
            menu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void menu() throws SQLException {
        while (true) {
            System.out.println("\n--- JDM CMAS Tracker ---");
            System.out.println("1. Register new patient");
            System.out.println("2. Assign new exercise");
            System.out.println("3. Add CMAS report");
            System.out.println("4. View patient reports");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> assignExercise();
                case 3 -> addReport();
                case 4 -> viewReports();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void registerPatient() throws SQLException {
        System.out.print("Patient name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt(); scanner.nextLine();
        PatientDAO.insert(new Patient(name, age));
        System.out.println("Patient registered.");
    }

    private static void assignExercise() throws SQLException {
        List<Patient> patients = PatientDAO.listAll();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (Patient p : patients)
            System.out.printf("%d: %s (%d y/o)\n", p.getId(), p.getName(), p.getAge());
        System.out.print("Enter patient ID: ");
        int pid = scanner.nextInt(); scanner.nextLine();
        System.out.print("Exercise name: ");
        String ename = scanner.nextLine();
        System.out.print("Description: ");
        String desc = scanner.nextLine();
        String date = LocalDateTime.now().toString();
        ExerciseDAO.insert(new Exercise(pid, ename, desc, date));
        System.out.println("Exercise assigned.");
    }

    private static void addReport() throws SQLException {
        System.out.print("Exercise ID: ");
        int eid = scanner.nextInt(); scanner.nextLine();
        System.out.print("CMAS Score (0-52): ");
        int score = scanner.nextInt(); scanner.nextLine();
        System.out.print("Muscle Status: ");
        String status = scanner.nextLine();
        String date = LocalDateTime.now().toString();
        ReportDAO.insert(new Report(eid, score, status, date));
        System.out.println("Report added.");
    }

    private static void viewReports() throws SQLException {
        System.out.print("Patient ID: ");
        int pid = scanner.nextInt(); scanner.nextLine();
        List<Exercise> exercises = ExerciseDAO.getByPatient(pid);
        for (Exercise ex : exercises) {
            System.out.printf("Exercise %d - %s: %s\n", ex.getId(), ex.getName(), ex.getDate());
            List<Report> reports = ReportDAO.getByExercise(ex.getId());
            for (Report r : reports) {
                System.out.printf("  → Score: %d | Status: %s | Date: %s\n", r.getCmasScore(), r.getMuscleStatus(), r.getCreatedAt());
            }
        }
    }
}
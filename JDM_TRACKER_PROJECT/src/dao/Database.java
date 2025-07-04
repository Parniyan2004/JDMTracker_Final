package dao;

import java.sql.*;

/**
 * Manages SQLite connection and initializes tables for the system.
 */
public class Database {
    private static final String URL = "jdbc:sqlite:jdm.db";
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(URL);
        }
        return conn;
    }

    public static void initialize() throws SQLException {
        Connection c = getConnection();
        Statement stmt = c.createStatement();

        // Table for patients
        stmt.executeUpdate("""
            CREATE TABLE IF NOT EXISTS patient (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                age INTEGER NOT NULL
            );
        """);

        // Table for exercises assigned to patients
        stmt.executeUpdate("""
            CREATE TABLE IF NOT EXISTS exercise (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                patient_id INTEGER NOT NULL,
                name TEXT NOT NULL,
                description TEXT,
                date TEXT NOT NULL,
                FOREIGN KEY(patient_id) REFERENCES patient(id)
            );
        """);

        // Table for reports filled by doctor
        stmt.executeUpdate("""
            CREATE TABLE IF NOT EXISTS report (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                exercise_id INTEGER NOT NULL,
                cmas_score INTEGER NOT NULL,
                muscle_status TEXT NOT NULL,
                created_at TEXT NOT NULL,
                FOREIGN KEY(exercise_id) REFERENCES exercise(id)
            );
        """);

        stmt.close();
    }
}
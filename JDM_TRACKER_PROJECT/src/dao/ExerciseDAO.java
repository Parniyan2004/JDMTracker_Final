package dao;

import model.Exercise;
import java.sql.*;
import java.util.*;

public class ExerciseDAO {
    public static void insert(Exercise e) throws SQLException {
        var ps = Database.getConnection().prepareStatement(
            "INSERT INTO exercise(patient_id, name, description, date) VALUES (?, ?, ?, ?)");
        ps.setInt(1, e.getPatientId());
        ps.setString(2, e.getName());
        ps.setString(3, e.getDescription());
        ps.setString(4, e.getDate());
        ps.executeUpdate();
    }

    public static List<Exercise> getByPatient(int pid) throws SQLException {
        List<Exercise> list = new ArrayList<>();
        var ps = Database.getConnection().prepareStatement("SELECT * FROM exercise WHERE patient_id = ?");
        ps.setInt(1, pid);
        var rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Exercise(rs.getInt("id"), pid, rs.getString("name"), rs.getString("description"), rs.getString("date")));
        }
        return list;
    }
}

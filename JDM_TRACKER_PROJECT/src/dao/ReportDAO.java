package dao;

import model.Report;
import java.sql.*;
import java.util.*;

public class ReportDAO {
    public static void insert(Report r) throws SQLException {
        var ps = Database.getConnection().prepareStatement(
            "INSERT INTO report(exercise_id, cmas_score, muscle_status, created_at) VALUES (?, ?, ?, ?)");
        ps.setInt(1, r.getExerciseId());
        ps.setInt(2, r.getCmasScore());
        ps.setString(3, r.getMuscleStatus());
        ps.setString(4, r.getCreatedAt());
        ps.executeUpdate();
    }

    public static List<Report> getByExercise(int exId) throws SQLException {
        List<Report> list = new ArrayList<>();
        var ps = Database.getConnection().prepareStatement("SELECT * FROM report WHERE exercise_id = ?");
        ps.setInt(1, exId);
        var rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Report(rs.getInt("id"), exId, rs.getInt("cmas_score"), rs.getString("muscle_status"), rs.getString("created_at")));
        }
        return list;
    }
}

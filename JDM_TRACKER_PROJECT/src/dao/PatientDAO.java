package dao;

import model.Patient;
import java.sql.*;
import java.util.*;

public class PatientDAO {
    public static void insert(Patient p) throws SQLException {
        var ps = Database.getConnection().prepareStatement("INSERT INTO patient(name, age) VALUES(?, ?)");
        ps.setString(1, p.getName());
        ps.setInt(2, p.getAge());
        ps.executeUpdate();
    }

    public static List<Patient> listAll() throws SQLException {
        List<Patient> list = new ArrayList<>();
        var rs = Database.getConnection().createStatement().executeQuery("SELECT * FROM patient");
        while (rs.next()) {
            list.add(new Patient(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
        }
        return list;
    }
}


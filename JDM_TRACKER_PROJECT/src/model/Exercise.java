package model;

/**
 * Represents an exercise assigned to a patient.
 */
public class Exercise {
    private int id;
    private int patientId;
    private String name;
    private String description;
    private String date;

    public Exercise(int id, int patientId, String name, String description, String date) {
        this.id = id; this.patientId = patientId;
        this.name = name; this.description = description; this.date = date;
    }

    public Exercise(int patientId, String name, String description, String date) {
        this(-1, patientId, name, description, date);
    }

    public int getId() { return id; }
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getDate() { return date; }
}

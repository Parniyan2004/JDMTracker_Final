package model;

/**
 * Represents a CMAS report for a specific exercise.
 */
public class Report {
    private int id;
    private int exerciseId;
    private int cmasScore;
    private String muscleStatus;
    private String createdAt;

    public Report(int id, int exerciseId, int cmasScore, String muscleStatus, String createdAt) {
        this.id = id; this.exerciseId = exerciseId;
        this.cmasScore = cmasScore; this.muscleStatus = muscleStatus; this.createdAt = createdAt;
    }

    public Report(int exerciseId, int cmasScore, String muscleStatus, String createdAt) {
        this(-1, exerciseId, cmasScore, muscleStatus, createdAt);
    }

    public int getId() { return id; }
    public int getExerciseId() { return exerciseId; }
    public int getCmasScore() { return cmasScore; }
    public String getMuscleStatus() { return muscleStatus; }
    public String getCreatedAt() { return createdAt; }
}

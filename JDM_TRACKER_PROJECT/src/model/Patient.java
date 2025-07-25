package model;

/**
 * Represents a patient with JDM.
 */
public class Patient {
    private int id;
    private String name;
    private int age;

    public Patient(int id, String name, int age) {
        this.id = id; this.name = name; this.age = age;
    }

    public Patient(String name, int age) {
        this(-1, name, age);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
}

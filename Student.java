// Student.java

public class Student {
    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toFileString() {
        return id + "," + name + "," + marks;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        return new Student(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
    }
}

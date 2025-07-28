// StudentManager.java

import java.io.*;
import java.util.*;

public class StudentManager {
    static final String FILE_NAME = "students.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Thanks for using!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            Student s = new Student(id, name, marks);
            FileWriter fw = new FileWriter(FILE_NAME, true);
            fw.write(s.toFileString() + "\n");
            fw.close();

            System.out.println("✅ Student added successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file.");
        }
    }

    public static void displayStudents() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists() || file.length() == 0) {
                System.out.println("No student records found.");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = br.readLine()) != null) {
                Student s = Student.fromFileString(line);
                s.display();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("❌ Error reading file.");
        }
    }
}

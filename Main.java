import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        // Load previously saved data automatically
        ArrayList<Student> loadedStudents = FileHandler.loadFromFile();
        management.getStudents().addAll(loadedStudents);

        System.out.println("====================================");
        System.out.println("   STUDENT MANAGEMENT SYSTEM");
        System.out.println("====================================");

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save Data");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    // Add Student
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();

                    Student student = new Student(id, name, age, course, marks);
                    management.addStudent(student);
                    break;

                case 2:
                    // View Students
                    management.viewStudents();
                    break;

                case 3:
                    // Search Student
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();

                    Student found = management.searchStudent(searchId);

                    if (found != null) {
                        System.out.println("\nStudent Found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Update Student
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();

                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();

                    management.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newCourse,
                            newMarks
                    );
                    break;

                case 5:
                    // Delete Student
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();

                    management.deleteStudent(deleteId);
                    break;

                case 6:
                    // Save Data
                    FileHandler.saveToFile(management.getStudents());
                    break;

                case 7:
                    // Exit
                    FileHandler.saveToFile(management.getStudents());
                    System.out.println("Data saved. Exiting...");
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);

        scanner.close();
    }
}
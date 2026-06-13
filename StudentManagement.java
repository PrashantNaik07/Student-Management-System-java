import java.util.ArrayList;

public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    // Return the student list
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Add Student
    public void addStudent(Student student) {
        // Check for duplicate Student ID
        for (Student s : students) {
            if (s.getStudentId() == student.getStudentId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    // View All Students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Search Student by ID
    public Student searchStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    // Update Student
    public boolean updateStudent(int studentId,
                                 String name,
                                 int age,
                                 String course,
                                 double marks) {

        Student student = searchStudent(studentId);

        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            student.setMarks(marks);

            System.out.println("Student updated successfully.");
            return true;
        }

        System.out.println("Student not found.");
        return false;
    }

    // Delete Student
    public boolean deleteStudent(int studentId) {
        Student student = searchStudent(studentId);

        if (student != null) {
            students.remove(student);

            System.out.println("Student deleted successfully.");
            return true;
        }

        System.out.println("Student not found.");
        return false;
    }
}
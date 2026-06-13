import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "students.dat";

    // Save students to file
    public static void saveToFile(ArrayList<Student> students) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(students);
            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }

    // Load students from file
    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (ArrayList<Student>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading data: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Human {
    private String gender;
    private String status;
    private String country;
    private int age;

    private static final List<String> GENDERS = Arrays.asList("Male", "Female", "Nonbinary");
    private static final List<String> STATUSES = Arrays.asList("Rich", "Middle-class", "So-So", "Poor");
    private static final List<String> COUNTRIES = Arrays.asList("USA", "Canada", "Mexico", "India");

    public Human() {
        Random random = new Random() ;
        this.gender = GENDERS.get(random.nextInt(GENDERS.size())) ;
        this.status = STATUSES.get(random.nextInt(STATUSES.size()));
        this.country = COUNTRIES.get(random.nextInt(COUNTRIES.size()));
        this.age = random.nextInt(100) + 1;
    }
    public void liveMonth() {
        age += 1 / 12;
    }
    public void liveYear() {
        age += 1;
    }
    public List<String> getAllProperties() {
        return Arrays.asList("Gender: " + gender, "Status: " + status, "Country: " + country, "Age: " + age);
    }
    public void printAllProperties() {
        List<String> properties = getAllProperties();
        for (String prop : properties) {
            System.out.println(prop);
        }
    }
    public static Human createRandomHuman() {
        return new Human();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to create a random character? (y/n)");
        String choise = scanner.nextLine();

        if (choise.equalsIgnoreCase("y")) {
            Human randomCharacter = createRandomHuman();
            System.out.println("Randomly generated character: ");
            randomCharacter.printAllProperties();
        }else {
            System.out.println("No Character created. Goodbye!");
        }
    }
}

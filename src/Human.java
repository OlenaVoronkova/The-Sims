import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Human {
    private final String gender;
    private String status;
    private String country;
    private int age;
    private int budget;
    private boolean hasRelationships;
    private boolean hasBadHabits;

    private static final List<String> GENDERS = Arrays.asList("Male", "Female", "Nonbinary");
    private static final List<String> STATUSES = Arrays.asList("Rich", "Middle-class", "So-So", "Poor");
    private static final List<String> COUNTRIES = Arrays.asList("USA", "Canada", "Mexico", "India");

    public Human() {
        Random random = new Random();
        this.gender = GENDERS.get(random.nextInt(GENDERS.size()));
        this.status = STATUSES.get(random.nextInt(STATUSES.size()));
        this.country = COUNTRIES.get(random.nextInt(COUNTRIES.size()));
        this.age = random.nextInt(100) + 1;
        setBudgetBasedOnCountry();
    }

    private void setBudgetBasedOnCountry() {
        switch (country) {
            case "India":
                budget = 200;
                break;
            case "Mexico":
                budget = 600;
                break;
            case "Canada":
                budget = 1200;
                break;
            case "USA":
                budget = 3000;
                break;
            default:
                budget = 1000;
        }
    }

    public void liveMonth() {
        age += 1 / 12;
        performLifeEvents();
        simulateRandomEvent();
    }

    public void liveYear() {
        age += 1;
        performLifeEvents();
        simulateRandomEvent();
    }

    public void performLifeEvents() {
        if (age == 16) {

        } else if (age == 18) {

        } else if (age > 18 && age <= 30) {

        }
        if (!hasRelationships && age >= 5) {
            age -= 5;
        }
        if (hasBadHabits) {
            age -= 3;
        }
        if (budget < 0) {
            age -= 2;
        }
    }

    private void simulateRandomEvent() {
        Random random = new Random();
        int chanceOfDeath = random.nextInt(100);
        if (chanceOfDeath < 5) {
            System.out.println("Oh no! You had an accident and passed away.");
        }
    }

    public List<String> getAllProperties() {
        return Arrays.asList(
                "Gender: " + gender,
                "Status: " + status,
                "Country: " + country,
                "Age: " + age,
                "Budget: $" + budget,
                "Relationship: " + hasRelationships,
                "Bad Habits: " + hasBadHabits
        );
    }

    public void printAllProperties() {
        List<String> properties = getAllProperties();
        for (String prop : properties) {
            System.out.println(prop);
        }
    }

    public static void main(String[] args) {
        Human player = new Human();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Life Simulation Game!");
        System.out.println("Press 'Enter' to start the game...");

        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equals("")) {
                player.liveMonth();
                player.printAllProperties();
                System.out.println("Press 'Enter' to continue or 'q' to quit...");
            } else if (userInput.equalsIgnoreCase("q")) {
                System.out.println("Exiting the game...");
                break;
            }
        }
    }
}

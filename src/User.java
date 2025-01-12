import java.util.List;

public class User {
    private String name;
    private String gender;
    private int age;
    private List<String> interests;

    // Constructor
    public User(String name, String gender, int age, List<String> interests) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.interests = interests;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public List<String> getInterests() {
        return interests;
    }

    // Method to calculate the similarity score based on interests
    public int calculateInterestSimilarity(User otherUser) {
        int matchCount = 0;
        for (String interest : this.interests) {
            if (otherUser.getInterests().contains(interest)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Age: " + age + ", Interests: " + interests;
    }
}

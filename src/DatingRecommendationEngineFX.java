import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DatingRecommendationEngineFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        
        Label genderLabel = new Label("Gender:");
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female");
        
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        
        Label interestsLabel = new Label("Interests (comma separated):");
        TextField interestsField = new TextField();
        
        Button findMatchButton = new Button("Find Match");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        // Layout
        VBox layout = new VBox(10, nameLabel, nameField, genderLabel, genderComboBox, ageLabel, ageField, interestsLabel, interestsField, findMatchButton, resultArea);
        layout.setAlignment(Pos.CENTER);
        layout.setPrefSize(400, 400);
        
        // Sample users (in a real application, these would be entered dynamically or fetched from a database)
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", "Female", 25, List.of("Reading", "Music", "Traveling")));
        users.add(new User("Bob", "Male", 30, List.of("Movies", "Music", "Gaming")));
        users.add(new User("Charlie", "Male", 24, List.of("Reading", "Hiking", "Traveling")));
        users.add(new User("Dana", "Female", 28, List.of("Cooking", "Yoga", "Traveling")));

        // Event handler for button
        findMatchButton.setOnAction(e -> {
            String name = nameField.getText();
            String gender = genderComboBox.getValue();
            int age = Integer.parseInt(ageField.getText());
            String[] interestsInput = interestsField.getText().split(",");
            List<String> interests = List.of(interestsInput);

            User currentUser = new User(name, gender, age, interests);

            // Find closest match
            User closestMatch = findClosestMatch(currentUser, users);
            if (closestMatch != null) {
                resultArea.setText("Your closest match is:\n" + closestMatch);
            } else {
                resultArea.setText("No match found.");
            }
        });

        // Set up the scene
        Scene scene = new Scene(layout);
        primaryStage.setTitle("Dating Recommendation Engine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Function to find the closest match
    public static User findClosestMatch(User currentUser, List<User> users) {
        User closestMatch = null;
        int maxScore = -1;

        for (User user : users) {
            // Apply gender rule: opposite gender preferred
            if (user.getGender().equals(currentUser.getGender())) {
                continue; // Skip if the same gender
            }

            // Calculate age difference
            int ageDifference = Math.abs(currentUser.getAge() - user.getAge());

            // Calculate interest match score
            int interestMatch = currentUser.calculateInterestSimilarity(user);

            // Apply all rules and calculate a score for each user
            int totalScore = (100 - ageDifference) + interestMatch;

            // Update closest match if we have a better match
            if (totalScore > maxScore) {
                maxScore = totalScore;
                closestMatch = user;
            }
        }

        return closestMatch;
    }
}

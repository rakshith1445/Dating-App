---> Project structure: 

DatingRecommendationEngineFX
├── src
│   ├── DatingRecommendationEngineFX.java
│   ├── User.java
└── .classpath
└── .project

-------------------------------------------------------------------------------------------

Step 1: Add JavaFX Dependencies:
->If you're using VSCode, you'll need to ensure you have JavaFX set up. You can do this by adding the necessary libraries in your project setup. Here's an example of how to set up JavaFX dependencies:
->Download the JavaFX SDK and extract it to a folder.
->When compiling, you need to reference the JavaFX libraries in the command line.

-------------------------------------------------------------------------------------------

Step 2: Running the Code in VSCode

Setup VSCode:
Install the Java Extension Pack in VSCode.
Open VSCode and create a new folder for your project.
Inside the folder, create the src folder and add the User.java and DatingRecommendationEngineFX.java files.
Download the JavaFX SDK and set it up as described earlier.
Compile and Run:

Open a terminal in VSCode and navigate to the project folder.
Compile the Java files using:       javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d out src/*.java

Run the program using:        java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp out DatingRecommendationEngineFX

----------------------------------------------------------------------------------------------
Output:
The interface will ask for the user's name, gender, age, and interests. After filling these in and clicking "Find Match," the application will find the closest match and display the result in a text area.



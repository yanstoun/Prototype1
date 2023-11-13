package EffortLogger;
import javafx.scene.control.ScrollPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class PlanningPoker extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Planning Poker");
        
        Label taskLabel = new Label("Enter Task Name:");
        TextField taskField = new TextField();
        
        Label nameLabel = new Label("Enter your name:");
        TextField nameField = new TextField();

        Label numberLabel = new Label("Enter a difficulty level (1-10):");
        TextField numberField = new TextField();

        TextArea logBox = new TextArea();
        logBox.setPrefSize(300, 200);
        logBox.setEditable(false);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            // Get input values
        	String task = taskField.getText();
            String name = nameField.getText();
            String number = numberField.getText();

            // Display the input values
            logBox.appendText("Task: " + task + "     Name: " + name + "     Difficulty: " + number + "\n");
        });

        // Create layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(taskLabel, taskField, nameLabel, nameField, numberLabel, numberField, submitButton, new ScrollPane(logBox));

        // Set up the scene
        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
        
    }
}
    

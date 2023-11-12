package EffortLogger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Dashboard1 extends Application {
	Stage primaryStage;
	@Override
	public void start(Stage primary) {
		primaryStage = primary;
		
		primaryStage.setTitle("Support Center");
        System.out.println("User Support Center Started");
        
        VBox root = new VBox(10); // spacing of 10 between nodes
        primaryStage.setScene(new Scene(root, 300, 250));
        root.setPadding(new Insets(10, 0, 0, 10)); // Top, Right, Bottom, Left padding

        Text text = new Text("How can we help you?");
        text.setStyle("-fx-font-size: 16;");
        root.getChildren().add(text);
        
        Button btn1 = createButton("Help");
        root.getChildren().add(btn1);
        
        Button btn2 = createButton("Navigation");
        root.getChildren().add(btn2);
        
        Button btn3 = createButton("Tutorial");
        root.getChildren().add(btn3);
        
        Button btn4 = createButton("Report a Problem");
        root.getChildren().add(btn4);
        
        Button btn5 = createButton("Planning Poker");
        root.getChildren().add(btn5);
        
        Button btn6 = createButton("Contact Us");
        root.getChildren().add(btn6);
        
        primaryStage.show();
    }
    
    private Button createButton(String title) {
        Button button = new Button(title);
        button.setOnAction(event -> openNewWindow(title));
        return button;
    }

    private void openNewWindow(String title) {
        System.out.println(title + " Page opened");
        Stage stage = new Stage();
        stage.setTitle(title);

        BorderPane pane = new BorderPane();
        VBox topLeftBox = new VBox(10);  // Spacing of 10

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            stage.close();
            primaryStage.show();
        });

        topLeftBox.getChildren().add(backButton);
        topLeftBox.setAlignment(Pos.TOP_LEFT);
        topLeftBox.setPadding(new Insets(10, 10, 10, 10)); // Uniform padding

        pane.setTop(topLeftBox);

        if ("Help".equals(title)) {
            Text helpText = new Text(
                "Welcome to EffortLogger!\n\n" +
                "EffortLogger streamlines task management with an intuitive interface, allowing users to log and track their\n"
                + "tasks efficiently. The platform offers detailed insights into efforts, categorized by day, week, or month.\n"
                + "Users can benefit from an integrated tutorial and have the convenience of a built-in problem reporting\n"
                + "system. Moreover, a dedicated contact section ensures prompt support and assistance. Overall,\n"
                + "EffortLogger is designed to simplify and enhance task tracking experiences."
            );
            
            VBox centerBox = new VBox(helpText);
            centerBox.setPadding(new Insets(10, 10, 10, 10)); // Uniform padding
            pane.setCenter(centerBox);
        }
        
        if ("Navigation".equals(title)) {
            Text navigationText = new Text(
                "Navigating EffortLogger\n\n" +
                "Dashboard:\n" +
                "Central hub for your tasks and logs.\n" +
                "Glance at recent efforts and overallstats.\n\n" +
                "Menu Bar:\n" +
                "Access point for all functionalities.\n" +
                "Toggle between projects and functionalities.\n\n" +
                "Task List:\n" +
                "Manage your tasks.\n" +
                "Sort by date, priority, project.\n\n" +
                "Search Bar:\n" +
                "Quickly find results using keywords.\n" +
                "Get directed to what you need.\n\n" +
                "Settings:\n" +
                "Personalize your EffortLogger experience.\n" +
                "Edit profile data.\n"
            );
            
            VBox centerBox = new VBox(navigationText);
            centerBox.setPadding(new Insets(10, 10, 10, 10)); // Uniform padding
            pane.setCenter(centerBox);
        }
        
        if ("Tutorial".equals(title)) {
            Text tutorialText = new Text(
                "EffortLogger Tutorial:\n\n" +
                "Setup:\n" +
                "Recieve username and password from administrator.\n" +
                "Log in and change password to your preference.\n\n" +
                
                "Tasks:\n" +
                "Click on menu and select Tasks.\n" +
                "Manage and view tasks sorted by date, priority, project\n\n" +
                
                "Tracking Effort:\n" +
                "Once logged in, EffortLogger will update your progress.\n" +
                "Signing out of EffortLogger stops logging progress.\n\n" +
                
                "Performance Data & Privacy:\n" +
                "You can access personal data at any time.\n" +
                "See who can view performance data.\n\n"
                
            );
            
            VBox centerBox = new VBox(tutorialText);
            centerBox.setPadding(new Insets(10, 10, 10, 10)); // Uniform padding
            pane.setCenter(centerBox);
        }
        

        if ("Report a Problem".equals(title)) {
            
            
            Text titleText = new Text("Title:");
            TextField titleInput = new TextField();
            titleInput.setPromptText("Maximum 20 Words");
            
            Text descriptionText = new Text("Description:");
            TextArea descriptionInput = new TextArea();
            descriptionInput.setPromptText("Maximum 200 Words");
            descriptionInput.setWrapText(true);
            descriptionInput.setPrefRowCount(5);  // Adjust as needed for the desired size
            
            Button submitButton = new Button("Submit");
            submitButton.setOnAction(e -> {
                // Handle problem reporting logic here
                // For example, save the issue details to a database or send an email notification
            	System.out.println("Problem Report was Submitted");
                // Reset the fields after handling
                titleInput.clear();          // Clear the title input
                descriptionInput.clear();    // Clear the description
            });
           
            
            VBox reportForm = new VBox(10, 
                titleText, titleInput, 
                descriptionText, descriptionInput, 
                submitButton
            );
            
            reportForm.setPadding(new Insets(10, 10, 10, 10)); // Uniform padding
            pane.setCenter(reportForm);
        }
        if ("Planning Poker".equals(title)) {
        	Text pokerHeader = new Text("Planning Poker");
        	pokerHeader.setStyle("-fx-font-size: 24;");
        	Text planningPoker = new Text(
        			"Planning poker is a planning and estimation technique.\n"+
        			"It is used by Agile teams after a product backlog creation.\n");
        	
        	VBox pokerDesc = new VBox(10, pokerHeader, planningPoker);
        	pokerDesc.setPadding(new Insets(10, 10, 10, 10));
        	pane.setCenter(pokerDesc);
        }
        
        if ("Contact Us".equals(title)) {
            Text contactHeaderText = new Text("Contact Us");
            contactHeaderText.setStyle("-fx-font-size: 24;");
            
            Text phoneText = new Text("Phone: 867-5309");
            Text emailText = new Text("Email: support@effortlogger.com");
            Text websiteText = new Text("Website: www.effortloggerth56.com");
            
            Text addressHeader = new Text("Office Address:");
            addressHeader.setStyle("-fx-font-size: 24;");
            Text addressText = new Text(
                "3828 Piermont Dr.\n" +
                "Albuquerque, New Mexico\n" +
                "United States"
            );
            
            VBox contactBox = new VBox(10, 
                contactHeaderText, phoneText, emailText, websiteText, 
                addressHeader, addressText
            );
            contactBox.setPadding(new Insets(10, 10, 10, 10));
            pane.setCenter(contactBox);
        }






        stage.setScene(new Scene(pane, 600, 400)); // Size for readability
        primaryStage.hide();  // hides the main window
        stage.show();  // shows the new window
    }
		
	
	public static void main(String[] args) {
		launch(args);
	}
}

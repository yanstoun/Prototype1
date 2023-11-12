package EffortLogger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Login");
		
		//create a window
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(12, 12, 12, 12));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		
		//add username textbox
		final TextField username = new TextField();
		username.setPromptText("Username:");
		username.setPrefColumnCount(10);
		username.getText();
		GridPane.setConstraints(username, 0, 0);
		gridPane.getChildren().add(username);
		
		//add password textbox
		final PasswordField password = new PasswordField();
		password.setPromptText("Password:");
		GridPane.setConstraints(password, 0, 1);
		gridPane.getChildren().add(password);
		
		//add Login button
		Button loginButton = new Button("Login");
		GridPane.setConstraints(loginButton,  1, 0);
		gridPane.getChildren().add(loginButton);
		
		//add Login button functionality
		final Text action = new Text();
		GridPane.setConstraints(action, 1, 1);
		gridPane.getChildren().add(action);
		
		loginButton.setOnAction(event -> {
			Dashboard1 dashboard = new Dashboard1();
			dashboard.start(new Stage());
			primaryStage.close();
			
		});
		
		 loginButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		 primaryStage.setTitle("Login Page");
		 Scene scene = new Scene(gridPane, 300, 200);
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 
	}
	

}

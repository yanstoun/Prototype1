package EffortLogger;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login2 extends Application {
    private static final String username1 = "user";
    private static final String password1 = "pass";
    private static final String code = "123456"; // Replace with your desired 2FA code

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        // create a window
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(12, 12, 12, 12));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // add username textbox
        final TextField username = new TextField();
        username.setPromptText("Username:");
        username.setPrefColumnCount(10);
        username.getText();
        GridPane.setConstraints(username, 0, 0);
        gridPane.getChildren().add(username);

        // add password textbox
        final PasswordField password = new PasswordField();
        password.setPromptText("Password:");
        GridPane.setConstraints(password, 0, 1);
        gridPane.getChildren().add(password);

        // add Login button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 0);
        gridPane.getChildren().add(loginButton);

        // add Login button functionality
        final Text action = new Text();
        GridPane.setConstraints(action, 1, 1);
        gridPane.getChildren().add(action);

        Button enterButton = new Button("Enter");
        final TextField twoFactorCode = new TextField();

        loginButton.setOnAction(event -> {
            String usernameInput = username.getText();
            String passwordInput = password.getText();

            if (usernameInput.equals(username1) && passwordInput.equals(password1)) {
                twoFactorCode.setPromptText("2FA Code:");
                GridPane.setConstraints(twoFactorCode, 0, 4);
                gridPane.getChildren().add(twoFactorCode);

                GridPane.setConstraints(enterButton,  1, 4);
                gridPane.getChildren().add(enterButton);

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Credentials");
                alert.setHeaderText(null);
                alert.setContentText("The username or password is incorrect. Please try again.");
                alert.showAndWait();
            }
        });

        enterButton.setOnAction(event -> {
                    String twoFactorInput = twoFactorCode.getText();

                    if (twoFactorInput.equals(code)) {
                        Dashboard1 dashboard = new Dashboard1();
                        dashboard.start(new Stage());
                        primaryStage.close();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Incorrect Credentials");
                        alert.setHeaderText(null);
                        alert.setContentText("The 2FA code is incorrect. Please try again.");
                        alert.showAndWait();
                    }
                });

        loginButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        primaryStage.setTitle("Login Page");
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

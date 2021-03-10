package app.controller;

import app.entity.User;
import app.repository.UserRepository;
import app.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    public TextField usernameField;

    @FXML
    public TextField passwordField;

    @FXML
    public Button loginButton;

    @FXML
    public Button registerButton;

    @FXML
    public Label usernameLabel;

    private final UserService userService = new UserService(new UserRepository());


    public void register(ActionEvent actionEvent) {
        if (!usernameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            userService.saveUser(new User(usernameField.getText(), passwordField.getText()));
        }
    }

    public void login(ActionEvent actionEvent) {
        if (!usernameField.getText().isBlank() && !passwordField.getText().isBlank()) {

            boolean isRegistered = userService.isRegistered(new User(usernameField.getText(), passwordField.getText()));

            if (isRegistered) {
                System.out.println("User is registered!");

                if (actionEvent.getSource() == loginButton) {

                    try {
                        Node node = (Node) actionEvent.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.close();

                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Fooldal.fxml")));
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                }

            } else {
                System.out.println("User is not yet registered, please click on register!");
            }

        }
    }
}

package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button okBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private void initialize() {
        createBindings();
    }

    private void createBindings() {
        pwd.editableProperty().bind(Bindings.createBooleanBinding(
                () -> userId.getText().length() >= 6,
                userId.textProperty()
        ));
        BooleanBinding fieldsEmpty = userId.textProperty().isEmpty().and(pwd.textProperty().isEmpty());
        cancelBtn.disableProperty().bind(fieldsEmpty);
        BooleanBinding validPassword = Bindings.createBooleanBinding(() -> {
            String password = pwd.getText();
            return password.length() >= 8 && password.chars().anyMatch(Character::isUpperCase) &&
                    password.chars().anyMatch(Character::isDigit);
        }, pwd.textProperty());

        okBtn.disableProperty().bind(validPassword.not());
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}
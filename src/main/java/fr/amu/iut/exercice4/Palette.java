package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    private HBox haut;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        label = new Label();
        panneau = new Pane();
        bas = new HBox();
        haut = new HBox();
        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        bas.getChildren().addAll(vert, rouge, bleu);
        bas.setAlignment(Pos.CENTER);

        haut.getChildren().add(label);
        haut.setAlignment(Pos.CENTER);

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            ++nbVert;
            panneau.setStyle("-fx-background-color: green");
            label.setText("Vert choisi "+nbVert+" fois");
        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            ++nbRouge;
            panneau.setStyle("-fx-background-color: red");
            label.setText("Rouge choisi "+nbRouge+" fois");
        });
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            ++nbBleu;
            panneau.setStyle("-fx-background-color: blue");
            label.setText("Bleu choisi "+nbBleu+" fois");
        });

        root.setCenter(panneau);
        root.setTop(haut);
        root.setBottom(bas);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setScene( scene );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


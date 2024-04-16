package fr.amu.iut.exercice5;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Rectangle {

    public Obstacle(double x, double y, double width, double height) {
        super(x, y, width, height);
    }
    boolean murCollision(Personnage autrePersonnage) {
        return getBoundsInParent().contains(autrePersonnage.getBoundsInParent())
                || autrePersonnage.getBoundsInParent().contains(getBoundsInParent());
    }
}

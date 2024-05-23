package fr.amu.iut.exercice12;

import javafx.beans.property.IntegerProperty;
import javafx.scene.control.Button;

import javax.annotation.processing.Generated;

public class CustomButton extends Button {

    private String couleur;
    private IntegerProperty nbClics;

    public int getNbClics() {
        return nbClics.get();
    }

    public IntegerProperty nbClicsProperty() {
        return nbClics;
    }

    public void setNbClics(int nbClics) {
        this.nbClics.set(nbClics);
    }

    public CustomButton(String texte, String couleur) {
        super(texte);
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }
}

package fr.amu.iut.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Creeper extends Personnage {

    private Circle baseTete;

    private Rectangle oeilGauche;

    private Rectangle oeilDroit;

    private Rectangle Nez;

    private Rectangle BaseBouche;

    private Rectangle Bouche2;

    private Rectangle Bouche1;

    public Creeper() {
        super("droite", Color.GREEN, Color.GREEN);
        baseTete = new Circle(6, 6, 2, Color.GREEN);

        oeilGauche = new Rectangle(4, 4, 4, 4);
        oeilGauche.setFill(Color.BLACK);

        oeilDroit = new Rectangle(12, 4, 4, 4);
        oeilDroit.setFill(Color.BLACK);

        Nez = new Rectangle(8, 8, 4, 4);
        Nez.setFill(Color.BLACK);

        BaseBouche = new Rectangle(6, 12, 8, 4);
        BaseBouche.setFill(Color.BLACK);

        Bouche1 = new Rectangle(6, 14, 2, 4);
        Bouche1.setFill(Color.BLACK);

        Bouche2 = new Rectangle(12, 14, 2, 4);
        Bouche2.setFill(Color.BLACK);

        super.getChildren().add(baseTete);
        super.getChildren().add(oeilGauche);
        super.getChildren().add(oeilDroit);
        super.getChildren().add(Nez);
        super.getChildren().add(BaseBouche);
        super.getChildren().add(Bouche1);
        super.getChildren().add(Bouche2);
    }

    @Override
    public void deplacerAGauche() {
        super.deplacerAGauche();
    }
    @Override
    public void deplacerADroite(double largeurJeu) {
        super.deplacerADroite(largeurJeu);
    }
    @Override
    public void deplacerEnBas(double hauteurJeu) {
        super.deplacerEnBas(hauteurJeu);
    }
    @Override
    public void deplacerEnHaut() {
        super.deplacerEnHaut();
    }
}

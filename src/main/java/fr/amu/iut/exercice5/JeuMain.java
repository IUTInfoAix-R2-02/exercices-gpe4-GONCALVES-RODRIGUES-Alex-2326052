package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();
        root.setStyle("-fx-background-color: #454141");
        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        Personnage creeper = new Creeper();
        // on positionne le fantôme 40 positions vers la droite et 20 vers le bas
        fantome.setLayoutX(42 * 10);
        fantome.setLayoutY(12 * 10);
        // on possitionne le creeper a cote du fatome car ils sont dans la meme equipe
        creeper.setLayoutX(44*10);
        creeper.setLayoutY(12*10);
        // on positionne le pacman 16 psoitions vers la droite et 20 vers le bas
        pacman.setLayoutX(10 * 10);
        pacman.setLayoutY(8 * 10);



        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(creeper);

        // Creation des obstacles
        Obstacle obstacle1 = new Obstacle(280, 100, 20, 220);
        Obstacle obstacle2 = new Obstacle(20, 60, 20, 20);
        Obstacle obstacle3 = new Obstacle(160, 120, 220, 20);
        Obstacle obstacle4 = new Obstacle(200, 160, 60, 20);
        Obstacle obstacle5 = new Obstacle(20, 20, 60, 20);
        Obstacle obstacle6 = new Obstacle(360, 160, 60, 20);
        Obstacle obstacle7 = new Obstacle(320, 160, 20, 20);
        Obstacle obstacle8 = new Obstacle(20, 100, 20, 80);
        Obstacle obstacle9 = new Obstacle(60, 60, 20, 140);
        Obstacle obstacle10 = new Obstacle(0, 200, 100, 20);
        Obstacle obstacle11 = new Obstacle(100, 0, 20, 80);
        Obstacle obstacle12 = new Obstacle(100, 100, 20,80);
        Obstacle obstacle13 = new Obstacle(140, 160, 40,20);
        Obstacle obstacle14 = new Obstacle(120, 120, 20,20);
        Obstacle obstacle15 = new Obstacle(140, 80, 60,20);
        Obstacle obstacle16 = new Obstacle(140, 0, 20,60);
        Obstacle obstacle17 = new Obstacle(180, 20, 80,20);
        Obstacle obstacle18 = new Obstacle(280, 0, 20,80);
        Obstacle obstacle19 = new Obstacle(220, 60, 40, 40);
        Obstacle petitcarre = new Obstacle(180, 60, 20, 20);
        Obstacle baseF1 = new Obstacle(400, 100, 20, 80);
        Obstacle baseF2 = new Obstacle(400, 100, 80, 20);
        Obstacle baseF3 = new Obstacle(480,100, 20, 100);
        Obstacle baseF4 = new Obstacle(400, 180, 60, 20);
        // Construction des limitations de la map a la main
        Obstacle coteD = new Obstacle(640, 0, 20, 480);
        Obstacle coteB = new Obstacle(0, 480, 640, 20);

        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);
        obstacles.add(obstacle7);
        obstacles.add(obstacle8);
        obstacles.add(obstacle9);
        obstacles.add(obstacle10);
        obstacles.add(obstacle11);
        obstacles.add(obstacle12);
        obstacles.add(obstacle13);
        obstacles.add(obstacle14);
        obstacles.add(obstacle15);
        obstacles.add(obstacle16);
        obstacles.add(obstacle17);
        obstacles.add(obstacle18);
        obstacles.add(obstacle19);
        obstacles.add(petitcarre);
        obstacles.add(baseF1);
        obstacles.add(baseF2);
        obstacles.add(baseF3);
        obstacles.add(baseF4);
        obstacles.add(coteD);
        obstacles.add(coteB);
        for(int i =0; i<obstacles.size(); i++){
            jeu.getChildren().add(obstacles.get(i));
        }

        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, obstacles, creeper);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, ArrayList<Obstacle> obstacles, Personnage Creep) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            // Sauvegarde des positions des joueurs.
            double J1X=j1.getLayoutX();
            double J1Y=j1.getLayoutY();
            double J2X=j2.getLayoutX();
            double J2Y=j2.getLayoutY();
            double CreepX=Creep.getLayoutX();
            double CreepY=Creep.getLayoutY();
            switch (event.getCode()) {
                // Deplacment pour le Pacman
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                // Deplacement pour le fantome.
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                // Deplacement pour le Creeper.
                case U:
                    Creep.deplacerEnHaut();
                    break;
                case J:
                    Creep.deplacerEnBas(scene.getHeight());
                    break;
                case H:
                    Creep.deplacerAGauche();
                    break;
                case K:
                    Creep.deplacerADroite(scene.getWidth());
                    break;
            }
            for(Obstacle value : obstacles) // Boucle pour les collisions avec les murs.
            {
                if (value.murCollision(j1)) {
                    j1.setLayoutX(J1X);
                    j1.setLayoutY(J1Y);
                }
                if (value.murCollision(j2)) {
                    j2.setLayoutX(J2X);
                    j2.setLayoutY(J2Y);
                }
                if (value.murCollision(Creep)){
                    Creep.setLayoutX(CreepX);
                    Creep.setLayoutY(CreepY);
                }
            }
            // Plusieurs boucle if pour les collisions avec les joueurs.
            if (j1.estEnCollision(j2)) {
                System.out.println("Vous avez perdu !");
                System.exit(0);
            }
            if (j1.estEnCollision(Creep)){
                System.out.println("Vous avez perdu !");
                System.exit(0);
            }
            if (j2.estEnCollision(Creep)){
                j2.setLayoutY(J2Y);
                j2.setLayoutX(J2X);
            }
            if (Creep.estEnCollision(j2)){
                Creep.setLayoutX(CreepX);
                Creep.setLayoutY(CreepY);
            }
        });
    }
}

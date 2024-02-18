package de.game.modules;



import de.game.modules.model.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



//TODO: Shift into 2-D World after finishing the console
public class GameGui extends Application
{
    private ImageView playerIcon;
    private ImageView enemyIcon;
    private HBox vsBox;
    public AbstractCharacter enemy;

    public GameGui() {
        //initializeIcons(enemy);
        //initializeVsBox();
    }


    @Override
    public void start(Stage stage) throws Exception {

        //GameClass game = new GameClass(this);
        //game.startGameWithGui();

        //initializeIcons(game);

        AbstractCharacter enemy = new Zombie(2);

        initializeIcons(enemy);
        initializeVsBox();

        VBox layout = new VBox();
        layout.getChildren().addAll(playerIcon, enemyIcon);

        Scene scene = new Scene(layout, 400, 300);



        stage.setTitle("Dungeon Game");
        stage.setScene(scene);
        stage.show();

    }


    public void initializeIcons(AbstractCharacter enemy) {
        //String currentWorkDir = System.getProperty("user.dir");
        playerIcon = new ImageView(getClass().getResource("Images/swordman.png").toExternalForm());


        enemyIcon = new ImageView(getClass().getResource(getEnemyIconPath(enemy)).toExternalForm());

        playerIcon.setVisible(false);
        enemyIcon.setVisible(false);

    }

    void initializeVsBox() {
        vsBox = new HBox();
        vsBox.setStyle("-fx-background-color: rgba(83,26,26,0.8);");

        Label vsLabel = new Label("vs.");
        vsLabel.setFont(new Font("Arial", 20));

        vsBox.getChildren().addAll(playerIcon, vsLabel, enemyIcon);
        vsBox.setVisible(false);
    }

    private String getEnemyIconPath(AbstractCharacter enemy) {
        //TODO: change to sys-env variable
        if (enemy instanceof Skeleton) {
            return "Images/skeleton.png";
        } else if (enemy instanceof Zombie) {
            return "Images/zombie.png";
        } else if (enemy instanceof Warrior) {
            return "Images/warrior.png";
        } else if (enemy instanceof Assassin) {
            return "Images/assassin.png";
        } else {

            return "Image/swordman.png";
        }
    }


    public void showIcons() {
        playerIcon.setVisible(true);
        enemyIcon.setVisible(true);
    }

    public void hideIcons() {
        playerIcon.setVisible(false);
        enemyIcon.setVisible(false);
    }

    public void showVsBox() {
        vsBox.setVisible(true);
    }

    public void hideVsBox() {
        vsBox.setVisible(false);
    }

    public HBox getVsBox() {
        return vsBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

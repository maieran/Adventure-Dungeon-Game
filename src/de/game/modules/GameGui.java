package de.game.modules;



import de.game.modules.model.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class GameGui extends Application
{
    private ImageView playerIcon;
    private ImageView enemyIcon;
    private AbstractCharacter enemy;

    @Override
    public void start(Stage stage) throws Exception {

        initializeIcons();

        VBox layout = new VBox();
        layout.getChildren().addAll(playerIcon,enemyIcon);

        Scene scene = new Scene(layout, 400, 300);

        stage.setTitle("Dungeon Game");
        stage.setScene(scene);
        stage.show();
    }

    private void initializeIcons() {
        //String currentWorkDir = System.getProperty("user.dir");
        playerIcon = new ImageView(getClass().getResource("Images/swordman.png").toExternalForm());

        //playerIcon.setX(100);
        //playerIcon.setY(100);

                //new Image("/src/de/game/modules/Images/swordman.png"));

        //TODO:implement for all possible enemies
        //new ImageView(new Image(getEnemyIconPath(enemy)));
        enemyIcon = new ImageView(getClass().getResource("Images/skeleton.png").toExternalForm());



        playerIcon.setVisible(false);
        enemyIcon.setVisible(false);

    }

    private String getEnemyIconPath(AbstractCharacter enemy) {
        //TODO: change to sys-env variable
        if (enemy instanceof Skeleton) {
            return "Images/skeleton.png";
        } else if (enemy instanceof Zombie) {
            return "/Users/PEAQ/Desktop/Own Projects/Adventure-Dungeon-Game/src/de/game/modules/Images/zombie.png";
        } else if (enemy instanceof Warrior) {
            return "/Users/PEAQ/Desktop/Own Projects/Adventure-Dungeon-Game/src/de/game/modules/Images/warrior.png";
        } else if (enemy instanceof Assassin) {
            return "/Users/PEAQ/Desktop/Own Projects/Adventure-Dungeon-Game/src/de/game/modules/Images/assassin.png";
        } else {

            return "/Users/PEAQ/Desktop/Own Projects/Adventure-Dungeon-Game/src/de/game/modules/Image/swordman.png";
        }
    }


    public void showIcons() {
        playerIcon.setVisible(true);
        enemyIcon.setVisible(true);
    }

    // Method to hide icons
    public void hideIcons() {
        playerIcon.setVisible(false);
        enemyIcon.setVisible(false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

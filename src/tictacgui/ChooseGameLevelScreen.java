/*
This is the scrren where the user get  to chooses the game level easy or hard
 */
package tictacgui;

import game.GameLevel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Mahy
 */
public class ChooseGameLevelScreen extends Pane {

    protected final ImageView imageView;
    protected final Button homeButt;
    protected final Button easyButt;
    protected final ImageView imageView0;
    protected final Button hardButt;
    protected final ImageView imageView1;
    public static GameLevel level = null;

    public ChooseGameLevelScreen(Stage stage) {

        imageView = new ImageView();
        homeButt = new Button();
        easyButt = new Button();
        imageView0 = new ImageView();
        hardButt = new Button();
        imageView1 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(606.0);

        imageView.setFitHeight(500.0);
        imageView.setFitWidth(606.0);
        imageView.setLayoutX(2.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/images/tokenOptions.png").toExternalForm()));

        homeButt.setLayoutX(519.0);
        homeButt.setLayoutY(23.0);
        homeButt.setMnemonicParsing(false);
        homeButt.setOpacity(0.0);
        homeButt.setPrefHeight(56.0);
        homeButt.setPrefWidth(52.0);

        easyButt.setLayoutX(167.0);
        easyButt.setLayoutY(261.0);
        easyButt.setMnemonicParsing(false);
        easyButt.setPrefHeight(89.0);
        easyButt.setPrefWidth(87.0);
        easyButt.setFont(new Font("Gill Sans MT", 24));
        easyButt.setStyle("-fx-background-color: #D3711D ; -fx-text-fill:#FFFFFF; ");

        imageView0.setFitHeight(81.0);
        imageView0.setFitWidth(74.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        easyButt.setText("Easy");

        hardButt.setLayoutX(370.0);
        hardButt.setLayoutY(261.0);
        hardButt.setMnemonicParsing(false);
        hardButt.setPrefHeight(89.0);
        hardButt.setPrefWidth(87.0);
        hardButt.setFont(new Font("Gill Sans MT", 24));
        hardButt.setStyle("-fx-background-color: #D3711D ; -fx-text-fill:#FFFFFF; ");

        imageView1.setFitHeight(73.0);
        imageView1.setFitWidth(75.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        hardButt.setText("Hard");

        getChildren().add(imageView);
        getChildren().add(homeButt);
        getChildren().add(easyButt);
        getChildren().add(hardButt);
        
        homeButt.setOnAction((event) -> {
            Parent root = new HomeScreen(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });

        hardButt.setOnAction((event) -> {
            try {
                level =  GameLevel.HARD;
                Parent root = new SinglePlayerBoard(stage);
                Scene scene1 = new Scene(root);
                stage.setScene(scene1);
                stage.show();
            } catch (SQLException ex) {
                Logger.getLogger(ChooseGameLevelScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        easyButt.setOnAction((event) -> {
            try {
                level =  GameLevel.EASY;
                Parent root = new SinglePlayerBoard(stage);
                Scene scene1 = new Scene(root);
                stage.setScene(scene1);
                stage.show();
            } catch (SQLException ex) {
                Logger.getLogger(ChooseGameLevelScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
}

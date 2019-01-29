/**
 *
 * First screen the user sees when he opens the game 
 */

package tictacgui;

/**
 *
 * @author Miramar
 */

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeScreen extends Pane {

    protected final ImageView imageView;
    protected final Button playButt;
    protected final Button exitButt;
    protected final Button settingButt3;

    public HomeScreen(Stage stage) {

        imageView = new ImageView();
        playButt = new Button();
        exitButt = new Button();
        settingButt3 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(501.0);
        setPrefWidth(605.0);

        imageView.setFitHeight(500.0);
        imageView.setFitWidth(605.0);
        imageView.setLayoutX(1.0);
        imageView.setLayoutY(1.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/images/mainMenu.png").toExternalForm()));

        playButt.setLayoutX(213.0);
        playButt.setLayoutY(203.0);
        playButt.setMnemonicParsing(false);
        playButt.setOpacity(0.0);
        playButt.setPrefHeight(72.0);
        playButt.setPrefWidth(196.0);
        playButt.setTextFill(javafx.scene.paint.Color.valueOf("#00000037"));

        exitButt.setLayoutX(213.0);
        exitButt.setLayoutY(317.0);
        exitButt.setMnemonicParsing(false);
        exitButt.setOpacity(0.0);
        exitButt.setPrefHeight(72.0);
        exitButt.setPrefWidth(196.0);
        exitButt.setTextFill(javafx.scene.paint.Color.valueOf("#00000037"));

        settingButt3.setLayoutX(26.0);
        settingButt3.setLayoutY(426.0);
        settingButt3.setMnemonicParsing(false);
        settingButt3.setOpacity(0.0);
        settingButt3.setPrefHeight(51.0);
        settingButt3.setPrefWidth(59.0);

        getChildren().add(imageView);
        getChildren().add(playButt);
        getChildren().add(exitButt);
        getChildren().add(settingButt3);

        playButt.setOnAction((event) -> {
            Parent root = new UsernameScreen(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });

        settingButt3.setOnAction((event) -> {
            Parent root = new OptionScreen(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });

        exitButt.setOnAction((event) -> {
            Platform.exit();
        });

    }
}

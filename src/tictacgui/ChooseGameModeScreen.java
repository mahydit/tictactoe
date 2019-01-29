package tictacgui;

import game.Game;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ChooseGameModeScreen extends Pane {

    protected final ImageView imageView;
    protected final Button singleButt;
    protected final Button multiButt;
    protected final Button netButt;
    protected final Button playbackButt;
    protected final Button scoreButt;
    protected final Button homeButt;
    public static File selectedFile;

    public ChooseGameModeScreen(Stage stage) {

        imageView = new ImageView();
        singleButt = new Button();
        multiButt = new Button();
        netButt = new Button();
        playbackButt = new Button();
        scoreButt = new Button();
        homeButt = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(605.0);

        imageView.setFitHeight(500.0);
        imageView.setFitWidth(605.0);
        imageView.setLayoutX(1.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/images/gameOptions.png").toExternalForm()));

        singleButt.setLayoutX(226.0);
        singleButt.setLayoutY(130.0);
        singleButt.setMnemonicParsing(false);
        singleButt.setOpacity(0.0);
        singleButt.setPrefHeight(48.0);
        singleButt.setPrefWidth(172.0);

        multiButt.setLayoutX(225.0);
        multiButt.setLayoutY(189.0);
        multiButt.setMnemonicParsing(false);
        multiButt.setOpacity(0.0);
        multiButt.setPrefHeight(48.0);
        multiButt.setPrefWidth(172.0);

        netButt.setLayoutX(226.0);
        netButt.setLayoutY(250.0);
        netButt.setMnemonicParsing(false);
        netButt.setOpacity(0.0);
        netButt.setPrefHeight(48.0);
        netButt.setPrefWidth(172.0);

        playbackButt.setLayoutX(224.0);
        playbackButt.setLayoutY(306.0);
        playbackButt.setMnemonicParsing(false);
        playbackButt.setOpacity(0.0);
        playbackButt.setPrefHeight(55.0);
        playbackButt.setPrefWidth(172.0);

        scoreButt.setLayoutX(226.0);
        scoreButt.setLayoutY(369.0);
        scoreButt.setMnemonicParsing(false);
        scoreButt.setOpacity(0.0);
        scoreButt.setPrefHeight(41.0);
        scoreButt.setPrefWidth(172.0);

        homeButt.setLayoutX(512.0);
        homeButt.setLayoutY(20.0);
        homeButt.setMnemonicParsing(false);
        homeButt.setOpacity(0.0);
        homeButt.setPrefHeight(55.0);
        homeButt.setPrefWidth(69.0);

        getChildren().add(imageView);
        getChildren().add(singleButt);
        getChildren().add(multiButt);
        getChildren().add(netButt);
        getChildren().add(playbackButt);
        getChildren().add(scoreButt);
        getChildren().add(homeButt);

        multiButt.setOnAction((event) -> {
            ChooseGameModeScreen.gameMusicVolume(0.6);
            Parent root = new MultiPlayerBoard(stage);
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();
        });

        singleButt.setOnAction((event) -> {
            ChooseGameModeScreen.gameMusicVolume(0.6);
            Parent root = new ChooseGameLevelScreen(stage);
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();
        });

        netButt.setOnAction((event) -> {
            ChooseGameModeScreen.gameMusicVolume(0.6);
            Parent root = new IPAddressScreen(stage);
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();
        });

        homeButt.setOnAction((event) -> {
            Parent root = new HomeScreen(stage);
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();
        });

        scoreButt.setOnAction(( event) -> {
            try {
                Parent root = new ScoresScreen(stage);
                Scene scene1 = new Scene(root);
                stage.setScene(scene1);
                stage.show();
            } catch (SQLException ex) {
                Logger.getLogger(ChooseGameModeScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

      playbackButt.setOnAction((event) -> {
            File currentDirectory = new File(System.getProperty("user.home") + File.separator + "tictactoe/savedgames"); //setting directory
            if (currentDirectory.exists() && currentDirectory.isDirectory()) {
                selectedFile = null;
                FileChooser fileChooser = new FileChooser(); //creating file chooser
                fileChooser.setTitle("Choose a game");
                fileChooser.getExtensionFilters().addAll( //adding filters
                        new FileChooser.ExtensionFilter("Text Files", "*.txt")
                );
                fileChooser.setInitialDirectory(currentDirectory);
                selectedFile = fileChooser.showOpenDialog(stage);
                if (selectedFile != null && Game.verifyFileContent(selectedFile)) {
                    //checking the file before moving to the board screen
                    Parent root = new ReplayScreen(stage);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    
                }
                
                else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("An Error Found");
                        alert.setContentText("Choose Correct File");
                        alert.showAndWait();
                }
            }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("An Error Found");
                        alert.setContentText("Record A Game to Playback ");
                        alert.showAndWait();
				
			}
        });


    }

    //Changing the game voulme if the music was on
    public static void gameMusicVolume(Double range) {
        if (OptionScreen.musicFlag) {
            TicTacGui.gameMusic.setVolume(range);
        }
    }
}

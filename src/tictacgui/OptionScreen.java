package tictacgui;

import game.RecordGameMode;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OptionScreen extends Pane {

    protected final ImageView imageView;
    protected final Button RecordButt;
    protected final Button musicButt;
    protected final Button helpButt;
    protected final Button homeButt;
    protected final Button settingButt;
    protected final Button closeButt;
    protected final Stage stage;
    public static boolean musicFlag = true;
    public static RecordGameMode recordFlag = RecordGameMode.NONE;

    public OptionScreen(Stage stage) {
        
        this.stage = stage;
        imageView = new ImageView();
        RecordButt = new Button();
        musicButt = new Button();
        helpButt = new Button();
        homeButt = new Button();
        settingButt = new Button();
        closeButt = new Button();

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
        imageView.setImage(new Image(getClass().getResource("/images/gameSetings.png").toExternalForm()));

        RecordButt.setLayoutX(151.0);
        RecordButt.setLayoutY(139.0);
        RecordButt.setMnemonicParsing(false);
        RecordButt.setOpacity(0.0);
        RecordButt.setPrefHeight(41.0);
        RecordButt.setPrefWidth(184.0);

        musicButt.setLayoutX(151.0);
        musicButt.setLayoutY(209.0);
        musicButt.setMnemonicParsing(false);
        musicButt.setOpacity(0.0);
        musicButt.setPrefHeight(41.0);
        musicButt.setPrefWidth(184.0);

        helpButt.setLayoutX(151.0);
        helpButt.setLayoutY(286.0);
        helpButt.setMnemonicParsing(false);
        helpButt.setOpacity(0.0);
        helpButt.setPrefHeight(41.0);
        helpButt.setPrefWidth(184.0);

        homeButt.setLayoutX(518.0);
        homeButt.setLayoutY(22.0);
        homeButt.setMnemonicParsing(false);
        homeButt.setOpacity(0.0);
        homeButt.setPrefHeight(53.0);
        homeButt.setPrefWidth(60.0);

        settingButt.setLayoutX(21.0);
        settingButt.setLayoutY(424.0);
        settingButt.setMnemonicParsing(false);
        settingButt.setOpacity(0.0);
        settingButt.setPrefHeight(53.0);
        settingButt.setPrefWidth(60.0);

        closeButt.setLayoutX(273.0);
        closeButt.setLayoutY(350.0);
        closeButt.setMnemonicParsing(false);
        closeButt.setOpacity(0.0);
        closeButt.setPrefHeight(65.0);
        closeButt.setPrefWidth(60.0);

        getChildren().add(imageView);
        getChildren().add(RecordButt);
        getChildren().add(musicButt);
        getChildren().add(helpButt);
        getChildren().add(homeButt);
        getChildren().add(settingButt);
        getChildren().add(closeButt);

        closeButt.setOnAction((event) -> {
            Parent root = new HomeScreen(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });

        settingButt.setOnAction((event) -> {
            Parent root = new OptionScreen(stage);
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();
        });

        RecordButt.setOnAction((event) -> { //setting rcord flag
            if (recordFlag == RecordGameMode.NONE) {
                recordFlag = RecordGameMode.RECORD;
                System.out.println("Record is on");
            } else if (recordFlag == RecordGameMode.RECORD) {
                recordFlag = RecordGameMode.NONE;
                System.out.println("Record is off");
            }
        });

        musicButt.setOnAction((event) -> { //setting music flag
            if (musicFlag) {
                TicTacGui.gameMusic.pause();
                musicFlag = false;
            } else {
                TicTacGui.gameMusic.play();
                musicFlag = true;
            }
        });

        homeButt.setOnAction((event) -> {
            Parent root = new HomeScreen(stage);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });

    }

}

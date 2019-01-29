/*
This is the replay game screen
where pre-recorded games is played
 */
package tictacgui;

import game.Game;
import game.TicTacToe;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ReplayScreen extends Pane {

    protected final ImageView imageView;
    protected final Button homeButt;
    protected final Button settingButt;
    protected final ImageView slot1imgO;
    protected final ImageView slot1imgX;
    protected final Button slot1;
    protected final ImageView slot2imgO;
    protected final ImageView slot2imgX;
    protected final Button slot2;
    protected final ImageView slot3imgO;
    protected final ImageView slot3imgX;
    protected final Button slot3;
    protected final ImageView slot4imgX;
    protected final ImageView slot4imgO;
    protected final Button slot4;
    protected final ImageView slot5imgO;
    protected final ImageView slot5imgX;
    protected final Button slot5;
    protected final ImageView slot6imgO;
    protected final ImageView slot6imgX;
    protected final Button slot6;
    protected final ImageView slot7imgO;
    protected final ImageView slot7imgX;
    protected final Button slot7;
    protected final ImageView slot8imgO;
    protected final ImageView slot8imgX;
    protected final Button slot8;
    protected final ImageView slot9imgO;
    protected final ImageView slot9imgX;
    protected final Button slot9;

    public ReplayScreen(Stage stage) {

        imageView = new ImageView();
        homeButt = new Button();
        settingButt = new Button();
        slot1imgO = new ImageView();
        slot1imgX = new ImageView();
        slot1 = new Button();
        slot2imgO = new ImageView();
        slot2imgX = new ImageView();
        slot2 = new Button();
        slot3imgO = new ImageView();
        slot3imgX = new ImageView();
        slot3 = new Button();
        slot4imgX = new ImageView();
        slot4imgO = new ImageView();
        slot4 = new Button();
        slot5imgO = new ImageView();
        slot5imgX = new ImageView();
        slot5 = new Button();
        slot6imgO = new ImageView();
        slot6imgX = new ImageView();
        slot6 = new Button();
        slot7imgO = new ImageView();
        slot7imgX = new ImageView();
        slot7 = new Button();
        slot8imgO = new ImageView();
        slot8imgX = new ImageView();
        slot8 = new Button();
        slot9imgO = new ImageView();
        slot9imgX = new ImageView();
        slot9 = new Button();

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
        imageView.setImage(new Image(getClass().getResource("/images/board.png").toExternalForm()));

        homeButt.setLayoutX(521.0);
        homeButt.setLayoutY(23.0);
        homeButt.setMnemonicParsing(false);
        homeButt.setOpacity(0.0);
        homeButt.setPrefHeight(51.0);
        homeButt.setPrefWidth(55.0);

        settingButt.setLayoutX(26.0);
        settingButt.setLayoutY(420.0);
        settingButt.setMnemonicParsing(false);
        settingButt.setOpacity(0.0);
        settingButt.setPrefHeight(57.0);
        settingButt.setPrefWidth(62.0);

        slot1imgO.setFitHeight(83.0);
        slot1imgO.setFitWidth(87.0);
        slot1imgO.setLayoutX(155.0);
        slot1imgO.setLayoutY(126.0);
        slot1imgO.setPickOnBounds(true);
        slot1imgO.setPreserveRatio(true);
        slot1imgO.setVisible(false);
        slot1imgO.setImage(new Image(getClass().getResource("/images/oToken.png").toExternalForm()));

        slot1imgX.setFitHeight(83.0);
        slot1imgX.setFitWidth(87.0);
        slot1imgX.setLayoutX(162.0);
        slot1imgX.setLayoutY(121.0);
        slot1imgX.setPickOnBounds(true);
        slot1imgX.setPreserveRatio(true);
        slot1imgX.setVisible(false);
        slot1imgX.setImage(new Image(getClass().getResource("/images/xToken.png").toExternalForm()));

        slot1.setLayoutX(155.0);
        slot1.setLayoutY(126.0);
        slot1.setMnemonicParsing(false);
        slot1.setOpacity(0.0);
        slot1.setPrefHeight(83.0);
        slot1.setPrefWidth(87.0);
        slot1.setDisable(true);

        slot2imgO.setFitHeight(83.0);
        slot2imgO.setFitWidth(87.0);
        slot2imgO.setLayoutX(260.0);
        slot2imgO.setLayoutY(131.0);
        slot2imgO.setPickOnBounds(true);
        slot2imgO.setPreserveRatio(true);
        slot2imgO.setVisible(false);
        slot2imgO.setImage(new Image(getClass().getResource("/images/oToken.png").toExternalForm()));

        slot2imgX.setFitHeight(83.0);
        slot2imgX.setFitWidth(87.0);
        slot2imgX.setLayoutX(267.0);
        slot2imgX.setLayoutY(126.0);
        slot2imgX.setPickOnBounds(true);
        slot2imgX.setPreserveRatio(true);
        slot2imgX.setVisible(false);
        slot2imgX.setImage(new Image(getClass().getResource("/images/xToken.png").toExternalForm()));

        slot2.setLayoutX(260.0);
        slot2.setLayoutY(126.0);
        slot2.setMnemonicParsing(false);
        slot2.setOpacity(0.0);
        slot2.setPrefHeight(83.0);
        slot2.setPrefWidth(87.0);
        slot2.setDisable(true);

        slot3imgO.setFitHeight(83.0);
        slot3imgO.setFitWidth(87.0);
        slot3imgO.setLayoutX(374.0);
        slot3imgO.setLayoutY(129.0);
        slot3imgO.setPickOnBounds(true);
        slot3imgO.setPreserveRatio(true);
        slot3imgO.setVisible(false);
        slot3imgO.setImage(new Image(getClass().getResource("/images/oToken.png").toExternalForm()));

        slot3imgX.setFitHeight(83.0);
        slot3imgX.setFitWidth(87.0);
        slot3imgX.setLayoutX(374.0);
        slot3imgX.setLayoutY(123.0);
        slot3imgX.setPickOnBounds(true);
        slot3imgX.setPreserveRatio(true);
        slot3imgX.setVisible(false);
        slot3imgX.setImage(new Image(getClass().getResource("/images/xToken.png").toExternalForm()));

        slot3.setLayoutX(367.0);
        slot3.setLayoutY(128.0);
        slot3.setMnemonicParsing(false);
        slot3.setOpacity(0.0);
        slot3.setPrefHeight(83.0);
        slot3.setPrefWidth(87.0);
        slot3.setDisable(true);

        slot4imgX.setFitHeight(83.0);
        slot4imgX.setFitWidth(87.0);
        slot4imgX.setLayoutX(162.0);
        slot4imgX.setLayoutY(230.0);
        slot4imgX.setPickOnBounds(true);
        slot4imgX.setPreserveRatio(true);
        slot4imgX.setVisible(false);
        slot4imgX.setImage(new Image(getClass().getResource("/images/xToken.png").toExternalForm()));

        slot4imgO.setFitHeight(83.0);
        slot4imgO.setFitWidth(87.0);
        slot4imgO.setLayoutX(148.0);
        slot4imgO.setLayoutY(233.0);
        slot4imgO.setPickOnBounds(true);
        slot4imgO.setPreserveRatio(true);
        slot4imgO.setVisible(false);
        slot4imgO.setImage(new Image(getClass().getResource("/images/oToken.png").toExternalForm()));

        slot4.setLayoutX(155.0);
        slot4.setLayoutY(230.0);
        slot4.setMnemonicParsing(false);
        slot4.setOpacity(0.0);
        slot4.setPrefHeight(83.0);
        slot4.setPrefWidth(87.0);

        slot5imgO.setFitHeight(83.0);
        slot5imgO.setFitWidth(87.0);
        slot5imgO.setLayoutX(267.0);
        slot5imgO.setLayoutY(236.0);
        slot5imgO.setPickOnBounds(true);
        slot5imgO.setPreserveRatio(true);
        slot5imgO.setVisible(false);
        slot5imgO.setImage(new Image(getClass().getResource("/images/oToken.png").toExternalForm()));

        slot5imgX.setFitHeight(83.0);
        slot5imgX.setFitWidth(87.0);
        slot5imgX.setLayoutX(274.0);
        slot5imgX.setLayoutY(230.0);
        slot5imgX.setPickOnBounds(true);
        slot5imgX.setPreserveRatio(true);
        slot5imgX.setVisible(false);
        slot5imgX.setImage(new Image(getClass().getResource("/images/xToken.png").toExternalForm()));

        slot5.setLayoutX(260.0);
        slot5.setLayoutY(230.0);
        slot5.setMnemonicParsing(false);
        slot5.setOpacity(0.0);
        slot5.setPrefHeight(83.0);
        slot5.setPrefWidth(87.0);
        slot5.setDisable(true);

        slot6imgO.setFitHeight(83.0);
        slot6imgO.setFitWidth(87.0);
        slot6imgO.setLayoutX(366.0);
        slot6imgO.setLayoutY(236.0);
        slot6imgO.setPickOnBounds(true);
        slot6imgO.setPreserveRatio(true);
        slot6imgO.setVisible(false);
        slot6imgO.setImage(new Image(getClass().getResource("/images/oToken.png").toExternalForm()));

        slot6imgX.setFitHeight(83.0);
        slot6imgX.setFitWidth(87.0);
        slot6imgX.setLayoutX(381.0);
        slot6imgX.setLayoutY(230.0);
        slot6imgX.setPickOnBounds(true);
        slot6imgX.setPreserveRatio(true);
        slot6imgX.setVisible(false);
        slot6imgX.setImage(new Image(getClass().getResource("/images/xToken.png").toExternalForm()));

        slot6.setLayoutX(366.0);
        slot6.setLayoutY(230.0);
        slot6.setMnemonicParsing(false);
        slot6.setOpacity(0.0);
        slot6.setPrefHeight(83.0);
        slot6.setPrefWidth(87.0);
        slot6.setDisable(true);

        slot7imgO.setFitHeight(83.0);
        slot7imgO.setFitWidth(87.0);
        slot7imgO.setLayoutX(154.0);
        slot7imgO.setLayoutY(343.0);
        slot7imgO.setPickOnBounds(true);
        slot7imgO.setPreserveRatio(true);
        slot7imgO.setVisible(false);
        slot7imgO.setImage(new Image(getClass().getResource("/images/oToken.png").toExternalForm()));

        slot7imgX.setFitHeight(83.0);
        slot7imgX.setFitWidth(87.0);
        slot7imgX.setLayoutX(169.0);
        slot7imgX.setLayoutY(337.0);
        slot7imgX.setPickOnBounds(true);
        slot7imgX.setPreserveRatio(true);
        slot7imgX.setVisible(false);
        slot7imgX.setImage(new Image(getClass().getResource("/images/xToken.png").toExternalForm()));

        slot7.setLayoutX(155.0);
        slot7.setLayoutY(337.0);
        slot7.setMnemonicParsing(false);
        slot7.setOpacity(0.0);
        slot7.setPrefHeight(83.0);
        slot7.setPrefWidth(87.0);
        slot7.setDisable(true);

        slot8imgO.setFitHeight(83.0);
        slot8imgO.setFitWidth(87.0);
        slot8imgO.setLayoutX(259.0);
        slot8imgO.setLayoutY(340.0);
        slot8imgO.setPickOnBounds(true);
        slot8imgO.setPreserveRatio(true);
        slot8imgO.setVisible(false);
        slot8imgO.setImage(new Image(getClass().getResource("/images/oToken.png").toExternalForm()));

        slot8imgX.setFitHeight(83.0);
        slot8imgX.setFitWidth(87.0);
        slot8imgX.setLayoutX(266.0);
        slot8imgX.setLayoutY(337.0);
        slot8imgX.setPickOnBounds(true);
        slot8imgX.setPreserveRatio(true);
        slot8imgX.setVisible(false);
        slot8imgX.setImage(new Image(getClass().getResource("/images/xToken.png").toExternalForm()));

        slot8.setLayoutX(260.0);
        slot8.setLayoutY(337.0);
        slot8.setMnemonicParsing(false);
        slot8.setOpacity(0.0);
        slot8.setPrefHeight(83.0);
        slot8.setPrefWidth(87.0);
        slot8.setDisable(true);

        slot9imgO.setFitHeight(83.0);
        slot9imgO.setFitWidth(87.0);
        slot9imgO.setLayoutX(366.0);
        slot9imgO.setLayoutY(340.0);
        slot9imgO.setPickOnBounds(true);
        slot9imgO.setPreserveRatio(true);
        slot9imgO.setVisible(false);
        slot9imgO.setImage(new Image(getClass().getResource("/images/oToken.png").toExternalForm()));

        slot9imgX.setFitHeight(83.0);
        slot9imgX.setFitWidth(87.0);
        slot9imgX.setLayoutX(373.0);
        slot9imgX.setLayoutY(337.0);
        slot9imgX.setPickOnBounds(true);
        slot9imgX.setPreserveRatio(true);
        slot9imgX.setVisible(false);
        slot9imgX.setImage(new Image(getClass().getResource("/images/xToken.png").toExternalForm()));

        slot9.setLayoutX(366.0);
        slot9.setLayoutY(337.0);
        slot9.setMnemonicParsing(false);
        slot9.setOpacity(0.0);
        slot9.setPrefHeight(83.0);
        slot9.setPrefWidth(87.0);
        slot8.setDisable(true);

        getChildren().add(imageView);
        getChildren().add(homeButt);
        getChildren().add(settingButt);
        getChildren().add(slot1imgO);
        getChildren().add(slot1imgX);
        getChildren().add(slot1);
        getChildren().add(slot2imgO);
        getChildren().add(slot2imgX);
        getChildren().add(slot2);
        getChildren().add(slot3imgO);
        getChildren().add(slot3imgX);
        getChildren().add(slot3);
        getChildren().add(slot4imgX);
        getChildren().add(slot4imgO);
        getChildren().add(slot4);
        getChildren().add(slot5imgO);
        getChildren().add(slot5imgX);
        getChildren().add(slot5);
        getChildren().add(slot6imgO);
        getChildren().add(slot6imgX);
        getChildren().add(slot6);
        getChildren().add(slot7imgO);
        getChildren().add(slot7imgX);
        getChildren().add(slot7);
        getChildren().add(slot8imgO);
        getChildren().add(slot8imgX);
        getChildren().add(slot8);
        getChildren().add(slot9imgO);
        getChildren().add(slot9imgX);
        getChildren().add(slot9);

        // recreating the game board
        ArrayList<Integer> gameMoves;
        try {
            gameMoves = Game.replayGame(ChooseGameModeScreen.selectedFile);
            TicTacToe game = new TicTacToe(3, 3, gameMoves.get(0));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int move : gameMoves.subList(1, gameMoves.size())) {
                        showMove(move, game);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                                 Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error Dialog");
                                alert.setHeaderText("An Error Found");
                                alert.setContentText("InterruptedException");
                                alert.showAndWait();
                        }
                    }
                }

            }).start();
        } catch (FileNotFoundException ex) { //Error Dialog box NEEDEEDD
                Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("An Error Found");
                        alert.setContentText("FileNotFoundException");
                        alert.showAndWait();
        } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("An Error Found");
                        alert.setContentText("IO EXCEPTION");
        }

        homeButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new HomeScreen(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

    }

    //setting the write token 
    private void showMove(Integer move, TicTacToe game) {
        int currentPlayer = game.getCurrentTurn();
        switch (currentPlayer) {
            case Game.PLAYER_ONE:
                moveTokenX(move);
                game.setCurrentTurn(Game.PLAYER_TWO);
                break;
            case Game.PLAYER_TWO:
                moveTokenO(move);
                game.setCurrentTurn(Game.PLAYER_ONE);
                break;
        }
    }

    //showing x Token
    private void moveTokenX(int index) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                switch (index) {
                    case 0:
                        slot1imgX.setVisible(true);
                        break;
                    case 1:
                        slot2imgX.setVisible(true);
                        break;
                    case 2:
                        slot3imgX.setVisible(true);
                        break;
                    case 3:
                        slot4imgX.setVisible(true);
                        break;
                    case 4:
                        slot5imgX.setVisible(true);
                        break;
                    case 5:
                        slot6imgX.setVisible(true);
                        break;
                    case 6:
                        slot7imgX.setVisible(true);
                        break;
                    case 7:
                        slot8imgX.setVisible(true);
                        break;
                    case 8:
                        slot9imgX.setVisible(true);
                        break;

                }
            }
        });
    }

    //Showing O token
    private void moveTokenO(Integer index) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                switch (index) {
                    case 0:
                        slot1imgO.setVisible(true);
                        break;
                    case 1:
                        slot2imgO.setVisible(true);
                        break;
                    case 2:
                        slot3imgO.setVisible(true);
                        break;
                    case 3:
                        slot4imgO.setVisible(true);
                        break;
                    case 4:
                        slot5imgO.setVisible(true);
                        break;
                    case 5:
                        slot6imgO.setVisible(true);
                        break;
                    case 6:
                        slot7imgO.setVisible(true);
                        break;
                    case 7:
                        slot8imgO.setVisible(true);
                        break;
                    case 8:
                        slot9imgO.setVisible(true);
                        break;

                }
            }
        });

    }
}
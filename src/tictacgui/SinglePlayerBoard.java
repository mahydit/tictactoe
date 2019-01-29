/*
This is the board for a user vs AI.
 */
package tictacgui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import game.AIPlayer;
import game.DbHandle;
import game.Game;
import game.HumanPlayer;
import game.RecordGameMode;
import game.TicTacToe;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import static tictacgui.OptionScreen.recordFlag;
import static tictacgui.UsernameScreen.username;

/**
 *
 * @author Mahy
 */
public class SinglePlayerBoard extends Pane {

    protected final ImageView imageView;
    protected final Button homeButt;
    protected final Button settingButt;
    protected final Label girlLabel;
    protected final Label boyLabel;
    protected final Label tieLabel;
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
    protected AudioClip winningEffect;
    protected AudioClip losingEffect;
    private AIPlayer ai;
    private HumanPlayer p2;
    private TicTacToe game;

    public SinglePlayerBoard(Stage stage) throws SQLException {

        imageView = new ImageView();
        homeButt = new Button();
        settingButt = new Button();
        girlLabel = new Label();
        boyLabel = new Label();
        tieLabel = new Label();
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

        girlLabel.setLayoutX(49.0);
        girlLabel.setLayoutY(284.0);
        girlLabel.setPrefHeight(85.0);
        girlLabel.setPrefWidth(80.0);
        girlLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        girlLabel.setFont(new Font("Gill Sans MT", 40.0));

        boyLabel.setLayoutX(486.0);
        boyLabel.setLayoutY(291.0);
        boyLabel.setPrefHeight(85.0);
        boyLabel.setPrefWidth(80.0);
        boyLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        boyLabel.setFont(new Font("Gill Sans MT", 40.0));
        
        tieLabel.setLayoutX(49.0);
        tieLabel.setLayoutY(284.0);
        tieLabel.setPrefHeight(83.0);
        tieLabel.setPrefWidth(78.0);
        tieLabel.setFont(new Font("Gill Sans MT", 40.0));
        tieLabel.setVisible(false);


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
        slot1.setText("0");

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
        slot2.setVisible(true);
        slot2.setText("1");

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
        slot3.setText("2");

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
        slot4.setText("3");

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
        slot5.setText("4");

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
        slot6.setText("5");

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
        slot7.setText("6");

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
        slot8.setText("7");

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
        slot9.setText("8");

        getChildren().add(imageView);
        getChildren().add(homeButt);
        getChildren().add(settingButt);
        getChildren().add(girlLabel);
        getChildren().add(boyLabel);
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

        initGame(); //intializing the game and players
        createWinningEffect(); // creating sound effects
        createLosingEffect();
        AITurn();//AI making the first move

        /*
        for each board slot their is an invisible button 
        each button has X and O token 
        by clicking on each button we set the O token to visible and disable the button
        we also save the move to game board array as well as o the file if the recording moode is activated
        each time a move is performed we have to check if their is a winner or not
         */
        slot1.setOnAction((event) -> {
            try {
                savePlayerMove(slot1.getText()); //saving the move to the file
                slot1imgO.setVisible(true); //setting the O token to visble
                slot1.setDisable(true); // disabling the button
                p2.performMove(slot1.getText(), game.getGameBoard()); // adding the move o the game board array
                findWinner(); //looking for a winner
                game.setCurrentTurn(Game.PLAYER_ONE); //setting the next turn to AI
                AITurn(); // letting AI make a move
            } catch (SQLException ex) {
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        slot2.setOnAction((event) -> {
            try {
                savePlayerMove(slot2.getText());
                slot2imgO.setVisible(true);
                slot2.setDisable(true);
                p2.performMove(slot2.getText(), game.getGameBoard());
                findWinner();
                game.setCurrentTurn(Game.PLAYER_ONE);
                AITurn();
            } catch (SQLException ex) {
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        slot3.setOnAction((event) -> {
            try {
                savePlayerMove(slot3.getText());
                slot3imgO.setVisible(true);
                slot3.setDisable(true);
                p2.performMove(slot3.getText(), game.getGameBoard());
                findWinner();
                game.setCurrentTurn(Game.PLAYER_ONE);
                AITurn();
            } catch (SQLException ex) {
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        slot4.setOnAction((event) -> {
            try {
                savePlayerMove(slot4.getText());
                slot4imgO.setVisible(true);
                slot4.setDisable(true);
                p2.performMove(slot4.getText(), game.getGameBoard());
                findWinner();
                game.setCurrentTurn(Game.PLAYER_ONE);
                AITurn();
            } catch (SQLException ex) {
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        slot5.setOnAction((event) -> {
            try {
                savePlayerMove(slot5.getText());
                slot5imgO.setVisible(true);
                slot5.setDisable(true);
                p2.performMove(slot5.getText(), game.getGameBoard());
                findWinner();
                game.setCurrentTurn(Game.PLAYER_ONE);
                AITurn();
            } catch (SQLException ex) {
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        slot6.setOnAction((event) -> {
            try {
                savePlayerMove(slot6.getText());
                slot6imgO.setVisible(true);
                slot6.setDisable(true);
                p2.performMove(slot6.getText(), game.getGameBoard());
                findWinner();
                game.setCurrentTurn(Game.PLAYER_ONE);
                AITurn();
            } catch (SQLException ex) {
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        slot7.setOnAction((event) -> {
            try {
                savePlayerMove(slot7.getText());
                slot7imgO.setVisible(true);
                slot7.setDisable(true);
                p2.performMove(slot7.getText(), game.getGameBoard());
                findWinner();
                game.setCurrentTurn(Game.PLAYER_ONE);
                AITurn();
            } catch (SQLException ex) {
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        slot8.setOnAction((event) -> {
            try {
                savePlayerMove(slot8.getText());
                slot8imgO.setVisible(true);
                slot8.setDisable(true);
                p2.performMove(slot8.getText(), game.getGameBoard());
                findWinner();
                game.setCurrentTurn(Game.PLAYER_ONE);
                AITurn();
            } catch (SQLException ex) {
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        slot9.setOnAction((event) -> {
            try {
                savePlayerMove(slot9.getText());
                slot9imgO.setVisible(true);
                slot9.setDisable(true);
                p2.performMove(slot9.getText(), game.getGameBoard());
                findWinner();
                game.setCurrentTurn(Game.PLAYER_ONE);
                AITurn();
            } catch (SQLException ex) {
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        homeButt.setOnAction((event) -> {
            if (OptionScreen.recordFlag == RecordGameMode.RECORD) {
                game.endRecording();
            }
            ChooseGameModeScreen.gameMusicVolume(1.0);
            Parent root = new ChooseGameModeScreen(stage);
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();
        });

    }

    /*
    iniating the game logic
     */
    private void initGame() {
        if (recordFlag == RecordGameMode.RECORD) {
            try {
                game = new TicTacToe(3, 3, Game.PLAYER_ONE, recordFlag);
            } catch (FileNotFoundException ex) { //error dialoge
                OptionScreen.recordFlag = RecordGameMode.NONE;
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            game = new TicTacToe(3, 3);
        }
        ai = new AIPlayer(ChooseGameLevelScreen.level);
        p2 = new HumanPlayer(game.PLAYER_TWO);
        game.setCurrentTurn(game.PLAYER_ONE);
    }

    /*
    AI performs a move when its recorded on the game board then its shown on the GUI board
     */
    private void AITurn() throws SQLException {
        int index = ai.performMove(game.getGameBoard());
        savePlayerMove(index);
        switch (index) {
            case 0:
                slot1imgX.setVisible(true);
                slot1.setDisable(true);
                break;
            case 1:
                slot2imgX.setVisible(true);
                slot2.setDisable(true);
                break;
            case 2:
                slot3imgX.setVisible(true);
                slot3.setDisable(true);
                break;
            case 3:
                slot4imgX.setVisible(true);
                slot4.setDisable(true);
                break;
            case 4:
                slot5imgX.setVisible(true);
                slot5.setDisable(true);
                break;
            case 5:
                slot6imgX.setVisible(true);
                slot6.setDisable(true);
                break;
            case 6:
                slot7imgX.setVisible(true);
                slot7.setDisable(true);
                break;
            case 7:
                slot8imgX.setVisible(true);
                slot8.setDisable(true);
                break;
            case 8:
                slot9imgX.setVisible(true);
                slot9.setDisable(true);
                break;

        }
        //Checking whether to restart the game or not
        boolean endGameFlag = findWinner();
        if (!endGameFlag) {
            game.setCurrentTurn(game.PLAYER_TWO);
        } else {
            AITurn();
        }

    }

    /*
    Update the board if a winner was found
     */
    private boolean findWinner() throws SQLException {
        DbHandle db = new DbHandle();
        int winner = game.checkBoardforWinner();
        int score;
        String str;
        switch (winner) {
            case Game.PLAYER_ONE:
                losingScreen();
                str = (girlLabel.getText() == "") ? "0" : girlLabel.getText();
                score = Integer.parseInt(str);
                score++;
                girlLabel.setText(Integer.toString(score)); //setting the score
                if (username.length() != 0 ){
                 db.insertScore(username, score, "losses");}
                clearboardButtons(); // clearing the board 
                game.getGameBoard().clearBoard();
                game.setCurrentTurn(Game.PLAYER_ONE);
                if (OptionScreen.recordFlag == RecordGameMode.RECORD) {
            try {
                game.restartGameRecording(); //restart recording again
            } catch (FileNotFoundException ex) {//dialog error to be added
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
                OptionScreen.recordFlag = RecordGameMode.NONE;
            }
                }
                return true;
            case Game.PLAYER_TWO:
                winningScreen();
                str = (boyLabel.getText() != "") ? boyLabel.getText() : "0";
                score = Integer.parseInt(str);
                score++;
                boyLabel.setText(Integer.toString(score));
                if (username.length()!= 0 ){
                 db.insertScore(username, score, "wins");}
                clearboardButtons();
                game.getGameBoard().clearBoard();
                game.setCurrentTurn(Game.PLAYER_ONE);
                if (OptionScreen.recordFlag == RecordGameMode.RECORD) {
            try {
                game.restartGameRecording();
            } catch (FileNotFoundException ex) { //dialog error to be added
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
                OptionScreen.recordFlag = RecordGameMode.NONE;
            }
                }
                return true;
            case -1:
                losingScreen(); 
                str = (tieLabel.getText() != "") ? tieLabel.getText() : "0";
                score = Integer.parseInt(str);
                score++;
                tieLabel.setText(Integer.toString(score));
                if (username.length()!= 0 ){
                db.insertScore(username, score, "ties");}
                game.getGameBoard().clearBoard();
                clearboardButtons();
                game.setCurrentTurn(Game.PLAYER_ONE);
                if (OptionScreen.recordFlag == RecordGameMode.RECORD) {
            try {
                game.restartGameRecording();
            } catch (FileNotFoundException ex) { //dialog error to be added
                Logger.getLogger(SinglePlayerBoard.class.getName()).log(Level.SEVERE, null, ex);
                OptionScreen.recordFlag = RecordGameMode.NONE;
            }
                }
                return true;
        }
        return false;
    }

    private void clearboardButtons() {
        // enabling the buttons 
        slot1.setDisable(false);
        slot2.setDisable(false);
        slot3.setDisable(false);
        slot4.setDisable(false);
        slot5.setDisable(false);
        slot6.setDisable(false);
        slot7.setDisable(false);
        slot8.setDisable(false);
        slot9.setDisable(false);
        //hidding token X
        slot1imgX.setVisible(false);
        slot2imgX.setVisible(false);
        slot3imgX.setVisible(false);
        slot4imgX.setVisible(false);
        slot5imgX.setVisible(false);
        slot6imgX.setVisible(false);
        slot7imgX.setVisible(false);
        slot8imgX.setVisible(false);
        slot9imgX.setVisible(false);
        //hiding token O
        slot1imgO.setVisible(false);
        slot2imgO.setVisible(false);
        slot3imgO.setVisible(false);
        slot4imgO.setVisible(false);
        slot5imgO.setVisible(false);
        slot6imgO.setVisible(false);
        slot7imgO.setVisible(false);
        slot8imgO.setVisible(false);
        slot9imgO.setVisible(false);
    }

    /*
    Overloading the savePlayerMove according to who is calling it
    since the player calls the method using a string(index) that is saved in the button
     */
    private void savePlayerMove(String index) {
        if (OptionScreen.recordFlag == RecordGameMode.RECORD) {
            game.recordMove(index);
        }
    }

    private void savePlayerMove(int index) {
        if (OptionScreen.recordFlag == RecordGameMode.RECORD) {
            game.recordMove(index);
        }
    }

    private void createWinningEffect() {
        final URL resource = getClass().getResource("/music/WinningSoundEffect.mp3");
        winningEffect = new AudioClip(resource.toString());
    }

    private void createLosingEffect() {
        final URL resource = getClass().getResource("/music/LosingSoundEffect.mp3");
        losingEffect = new AudioClip(resource.toString());
    }
    
    
     private void winningScreen() {
        Stage newWindow = new Stage();
        ImageView imageview = new ImageView();

        imageview.setImage(new Image(getClass().getResource("/gif/winner.gif").toExternalForm()));

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(imageview);

        Scene secondScene = new Scene(secondaryLayout, imageView.getFitHeight(), imageView.getFitWidth());

        // New window (Stage)
        newWindow.setTitle("Match Ended");
        newWindow.setScene(secondScene);

        newWindow.show();
        //playing sound effect
        winningEffect.play();

        //closing scene after a certain duration
        PauseTransition delay = new PauseTransition(Duration.seconds(4));
        delay.setOnFinished(event -> newWindow.close());
        delay.play();
    }
    
   private void losingScreen() {
        Stage newWindow = new Stage();
        ImageView imageview = new ImageView();

        imageview.setImage(new Image(getClass().getResource("/gif/losing-saddnes.gif").toExternalForm()));

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(imageview);

        Scene secondScene = new Scene(secondaryLayout, 800, 600);

        // New window (Stage)
        newWindow.setTitle("Match Ended");
        newWindow.setScene(secondScene);

        newWindow.show();
        //playing sound effect
        losingEffect.play(); //playong sound effect

        //closing scene after a certain duration
        PauseTransition delay = new PauseTransition(Duration.seconds(4));
        delay.setOnFinished(event -> newWindow.close());
        delay.play();
    }

}

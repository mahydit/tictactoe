package tictacgui;

import game.DbHandle;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static tictacgui.UsernameScreen.username;

public class ScoresScreen extends Pane {

    protected final ImageView imageView;
    protected final Button homeButt;
    protected final Label lossLabel;
    protected final Label tiesLabel;
    protected final Label winLabel;
    protected final Button backButt;

    public ScoresScreen(Stage stage) throws SQLException {

        imageView = new ImageView();
        homeButt = new Button();
        lossLabel = new Label();
        tiesLabel = new Label();
        winLabel = new Label();
        backButt = new Button();

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
        imageView.setImage(new Image(getClass().getResource("/images/scoresBoard.png").toExternalForm()));

        homeButt.setLayoutX(521.0);
        homeButt.setLayoutY(24.0);
        homeButt.setMnemonicParsing(false);
        homeButt.setOpacity(0.0);
        homeButt.setPrefHeight(48.0);
        homeButt.setPrefWidth(52.0);

        lossLabel.setAlignment(javafx.geometry.Pos.CENTER);
        lossLabel.setLayoutX(384.0);
        lossLabel.setLayoutY(277.0);
        lossLabel.setPrefHeight(48.0);
        lossLabel.setPrefWidth(68.0);
        lossLabel.setTextFill(javafx.scene.paint.Color.valueOf("#e4920d"));
        lossLabel.setFont(new Font("Bauhaus 93", 23.0));

        tiesLabel.setAlignment(javafx.geometry.Pos.CENTER);
        tiesLabel.setLayoutX(269.0);
        tiesLabel.setLayoutY(277.0);
        tiesLabel.setPrefHeight(48.0);
        tiesLabel.setPrefWidth(77.0);
        tiesLabel.setTextFill(javafx.scene.paint.Color.valueOf("#e4920d"));
        tiesLabel.setFont(new Font("Bauhaus 93", 23.0));

        winLabel.setAlignment(javafx.geometry.Pos.CENTER);
        winLabel.setLayoutX(161.0);
        winLabel.setLayoutY(277.0);
        winLabel.setPrefHeight(48.0);
        winLabel.setPrefWidth(68.0);
        winLabel.setTextFill(javafx.scene.paint.Color.valueOf("#e4920d"));
        winLabel.setFont(new Font("Bauhaus 93", 23.0));

        backButt.setLayoutX(31.0);
        backButt.setLayoutY(421.0);
        backButt.setMnemonicParsing(false);
        backButt.setOpacity(0.0);
        backButt.setPrefHeight(33.0);
        backButt.setPrefWidth(104.0);

        getChildren().add(imageView);
        getChildren().add(homeButt);
        getChildren().add(lossLabel);
        getChildren().add(tiesLabel);
        getChildren().add(winLabel);
        getChildren().add(backButt);
        
         DbHandle db = new DbHandle();
         
         if (username.length() == 0){
         winLabel.setText("--");
         tiesLabel.setText("--");
         lossLabel.setText("--");
         }
         else{
             
         
         winLabel.setText(Integer.toHexString(db.getScore("wins", db.getUserId(username))));
         tiesLabel.setText(Integer.toHexString(db.getScore("ties", db.getUserId(username))));
         lossLabel.setText(Integer.toHexString(db.getScore("losses", db.getUserId(username))));
         
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

        backButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new ChooseGameModeScreen(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

    }
}

package tictacgui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class IPAddressScreen extends Pane {

    protected final ImageView imageView;
    protected final TextField textField;
    protected final Button homeButt;
    protected final Button nextButt;


    public IPAddressScreen(Stage stage) {

        imageView = new ImageView();
        textField = new TextField();
        homeButt = new Button();
        nextButt = new Button();
       

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(606.0);

        imageView.setFitHeight(500.0);
        imageView.setFitWidth(606.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/images/ipAddress.png").toExternalForm()));

        textField.setAlignment(javafx.geometry.Pos.CENTER);
        textField.setLayoutX(222.0);
        textField.setLayoutY(275.0);
        textField.setPrefHeight(32.0);
        textField.setPrefWidth(178.0);
        textField.setFont(new Font("Bauhaus 93", 16.0));

        homeButt.setLayoutX(518.0);
        homeButt.setLayoutY(26.0);
        homeButt.setMnemonicParsing(false);
        homeButt.setOpacity(0.0);
        homeButt.setPrefHeight(48.0);
        homeButt.setPrefWidth(52.0);

        nextButt.setLayoutX(470.0);
        nextButt.setLayoutY(420.0);
        nextButt.setMnemonicParsing(false);
        nextButt.setOpacity(0.0);
        nextButt.setPrefHeight(48.0);
        nextButt.setPrefWidth(88.0);

        getChildren().add(imageView);
        getChildren().add(textField);
        getChildren().add(homeButt);
        getChildren().add(nextButt);

        homeButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new HomeScreen(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

        nextButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new OverNetworkBoard(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

    
}
}
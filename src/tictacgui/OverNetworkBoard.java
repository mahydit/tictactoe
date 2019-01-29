package tictacgui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class OverNetworkBoard extends Pane {

    protected final ImageView imageView;
    protected final Button homeButt;
    protected final Button settingButt;
    protected final Label girlLabel;
    protected final Label boyLabel;
    protected final Button slot1;
    protected final ImageView slot1img;
    protected final Button slot2;
    protected final ImageView slot2img;
    protected final Button slot3;
    protected final ImageView slot3img;
    protected final Button slot4;
    protected final ImageView slot4img;
    protected final Button slot5;
    protected final ImageView slot5img;
    protected final Button slot6;
    protected final ImageView slot6img;
    protected final Button slot7;
    protected final ImageView slot7img;
    protected final Button slot8;
    protected final ImageView slot8img;
    protected final Button slot9;
    protected final ImageView slot8img0;

    public OverNetworkBoard(Stage stage) {

        imageView = new ImageView();
        homeButt = new Button();
        settingButt = new Button();
        girlLabel = new Label();
        boyLabel = new Label();
        slot1 = new Button();
        slot1img = new ImageView();
        slot2 = new Button();
        slot2img = new ImageView();
        slot3 = new Button();
        slot3img = new ImageView();
        slot4 = new Button();
        slot4img = new ImageView();
        slot5 = new Button();
        slot5img = new ImageView();
        slot6 = new Button();
        slot6img = new ImageView();
        slot7 = new Button();
        slot7img = new ImageView();
        slot8 = new Button();
        slot8img = new ImageView();
        slot9 = new Button();
        slot8img0 = new ImageView();

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
        girlLabel.setPrefHeight(83.0);
        girlLabel.setPrefWidth(78.0);

        boyLabel.setLayoutX(486.0);
        boyLabel.setLayoutY(291.0);
        boyLabel.setPrefHeight(73.0);
        boyLabel.setPrefWidth(69.0);
        boyLabel.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        boyLabel.setFont(new Font("Gill Sans MT", 40.0));

        slot1.setLayoutX(155.0);
        slot1.setLayoutY(126.0);
        slot1.setMnemonicParsing(false);
        slot1.setOpacity(0.0);
        slot1.setPrefHeight(83.0);
        slot1.setPrefWidth(87.0);

        slot1img.setFitHeight(54.0);
        slot1img.setFitWidth(68.0);
        slot1img.setPickOnBounds(true);
        slot1img.setPreserveRatio(true);
        slot1.setGraphic(slot1img);

        slot2.setLayoutX(260.0);
        slot2.setLayoutY(126.0);
        slot2.setMnemonicParsing(false);
        slot2.setOpacity(0.0);
        slot2.setPrefHeight(83.0);
        slot2.setPrefWidth(87.0);

        slot2img.setFitHeight(54.0);
        slot2img.setFitWidth(68.0);
        slot2img.setPickOnBounds(true);
        slot2img.setPreserveRatio(true);
        slot2.setGraphic(slot2img);

        slot3.setLayoutX(366.0);
        slot3.setLayoutY(126.0);
        slot3.setMnemonicParsing(false);
        slot3.setOpacity(0.0);
        slot3.setPrefHeight(83.0);
        slot3.setPrefWidth(87.0);

        slot3img.setFitHeight(54.0);
        slot3img.setFitWidth(68.0);
        slot3img.setPickOnBounds(true);
        slot3img.setPreserveRatio(true);
        slot3.setGraphic(slot3img);

        slot4.setLayoutX(155.0);
        slot4.setLayoutY(230.0);
        slot4.setMnemonicParsing(false);
        slot4.setOpacity(0.0);
        slot4.setPrefHeight(83.0);
        slot4.setPrefWidth(87.0);

        slot4img.setFitHeight(54.0);
        slot4img.setFitWidth(68.0);
        slot4img.setPickOnBounds(true);
        slot4img.setPreserveRatio(true);
        slot4.setGraphic(slot4img);

        slot5.setLayoutX(260.0);
        slot5.setLayoutY(230.0);
        slot5.setMnemonicParsing(false);
        slot5.setOpacity(0.0);
        slot5.setPrefHeight(83.0);
        slot5.setPrefWidth(87.0);

        slot5img.setFitHeight(54.0);
        slot5img.setFitWidth(68.0);
        slot5img.setPickOnBounds(true);
        slot5img.setPreserveRatio(true);
        slot5.setGraphic(slot5img);

        slot6.setLayoutX(366.0);
        slot6.setLayoutY(230.0);
        slot6.setMnemonicParsing(false);
        slot6.setOpacity(0.0);
        slot6.setPrefHeight(83.0);
        slot6.setPrefWidth(87.0);

        slot6img.setFitHeight(54.0);
        slot6img.setFitWidth(68.0);
        slot6img.setPickOnBounds(true);
        slot6img.setPreserveRatio(true);
        slot6.setGraphic(slot6img);

        slot7.setLayoutX(155.0);
        slot7.setLayoutY(337.0);
        slot7.setMnemonicParsing(false);
        slot7.setOpacity(0.0);
        slot7.setPrefHeight(83.0);
        slot7.setPrefWidth(87.0);

        slot7img.setFitHeight(54.0);
        slot7img.setFitWidth(68.0);
        slot7img.setPickOnBounds(true);
        slot7img.setPreserveRatio(true);
        slot7.setGraphic(slot7img);

        slot8.setLayoutX(260.0);
        slot8.setLayoutY(337.0);
        slot8.setMnemonicParsing(false);
        slot8.setOpacity(0.0);
        slot8.setPrefHeight(83.0);
        slot8.setPrefWidth(87.0);

        slot8img.setFitHeight(54.0);
        slot8img.setFitWidth(68.0);
        slot8img.setPickOnBounds(true);
        slot8img.setPreserveRatio(true);
        slot8.setGraphic(slot8img);

        slot9.setLayoutX(366.0);
        slot9.setLayoutY(337.0);
        slot9.setMnemonicParsing(false);
        slot9.setOpacity(0.0);
        slot9.setPrefHeight(83.0);
        slot9.setPrefWidth(87.0);

        slot8img0.setFitHeight(54.0);
        slot8img0.setFitWidth(68.0);
        slot8img0.setPickOnBounds(true);
        slot8img0.setPreserveRatio(true);
        slot9.setGraphic(slot8img0);

        getChildren().add(imageView);
        getChildren().add(homeButt);
        getChildren().add(settingButt);
        getChildren().add(girlLabel);
        getChildren().add(boyLabel);
        getChildren().add(slot1);
        getChildren().add(slot2);
        getChildren().add(slot3);
        getChildren().add(slot4);
        getChildren().add(slot5);
        getChildren().add(slot6);
        getChildren().add(slot7);
        getChildren().add(slot8);
        getChildren().add(slot9);

        slot1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hi");
                Image xImg = new Image(getClass().getResourceAsStream("/images/xToken.png"));
                slot1.setGraphic(new ImageView(xImg));
            }
        });

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
}

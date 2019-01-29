package tictacgui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ErrorUsername extends Pane {

    protected final ImageView imageView;
    protected final Button okButt;
    protected final Button homeButt;
  

    public ErrorUsername (Stage stage) {

        imageView = new ImageView();
        okButt = new Button();
        homeButt = new Button();
        

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
        imageView.setImage(new Image(getClass().getResource("/images/userError.png").toExternalForm()));

        okButt.setLayoutX(268.0);
        okButt.setLayoutY(379.0);
        okButt.setMnemonicParsing(false);
        okButt.setOpacity(0.0);
        okButt.setPrefHeight(42.0);
        okButt.setPrefWidth(72.0);

        homeButt.setLayoutX(517.0);
        homeButt.setLayoutY(24.0);
        homeButt.setMnemonicParsing(false);
        homeButt.setOpacity(0.0);
        homeButt.setPrefHeight(50.0);
        homeButt.setPrefWidth(60.0);
 

        getChildren().add(imageView);
        getChildren().add(okButt);
        getChildren().add(homeButt);
     

         homeButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new HomeScreen(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
         
            okButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = new UsernameScreen(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
    }
}


/*
This is the scrren where the user can see all his scores (wins, loss. ties) for a specific user
 */

package tictacgui;

/**
 *
 * @author Miramar
 */

import game.DbHandle;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class UsernameScreen extends Pane {

    protected final ImageView imageView;
    protected final TextField userTextbox;
    protected final Button settingButt;
    protected final Button homeButt;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Button closeButt;
    protected final Button nextButt;
     public static String username;

    public UsernameScreen(Stage stage) {

        imageView = new ImageView();
        userTextbox = new TextField();
        settingButt = new Button();
        homeButt = new Button();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        closeButt = new Button();
        nextButt = new Button();

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
        imageView.setImage(new Image(getClass().getResource("/images/username.png").toExternalForm()));

        userTextbox.setAlignment(javafx.geometry.Pos.CENTER);
        userTextbox.setLayoutX(227.0);
        userTextbox.setLayoutY(284.0);
        userTextbox.setPrefHeight(34.0);
        userTextbox.setPrefWidth(173.0);
        userTextbox.setFont(new Font("Bauhaus 93", 15.0));

        settingButt.setLayoutX(29.0);
        settingButt.setLayoutY(423.0);
        settingButt.setMnemonicParsing(false);
        settingButt.setOpacity(0.0);
        settingButt.setPrefHeight(53.0);
        settingButt.setPrefWidth(54.0);

        homeButt.setLayoutX(520.0);
        homeButt.setLayoutY(24.0);
        homeButt.setMnemonicParsing(false);
        homeButt.setOpacity(0.0);
        homeButt.setPrefHeight(53.0);
        homeButt.setPrefWidth(54.0);

        imageView0.setFitHeight(63.0);
        imageView0.setFitWidth(64.0);
        imageView0.setLayoutX(24.0);
        imageView0.setLayoutY(418.0);
        imageView0.setImage(new Image(getClass().getResource("/images/closeIcon.png").toExternalForm()));

        imageView1.setFitHeight(63.0);
        imageView1.setFitWidth(78.0);
        imageView1.setLayoutX(264.0);
        imageView1.setLayoutY(371.0);
        imageView1.setImage(new Image(getClass().getResource("/images/arrowIcon.png").toExternalForm()));

        closeButt.setLayoutX(24.0);
        closeButt.setLayoutY(422.0);
        closeButt.setMnemonicParsing(false);
        closeButt.setOpacity(0.0);
        closeButt.setPrefHeight(53.0);
        closeButt.setPrefWidth(64.0);

        nextButt.setLayoutX(264.0);
        nextButt.setLayoutY(378.0);
        nextButt.setMnemonicParsing(false);
        nextButt.setOpacity(0.0);
        nextButt.setPrefHeight(53.0);
        nextButt.setPrefWidth(78.0);

        getChildren().add(imageView);
        getChildren().add(userTextbox);
        getChildren().add(settingButt);
        getChildren().add(homeButt);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(closeButt);
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
                 
                 
            closeButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                username = "";
                Parent root = new ChooseGameModeScreen(stage);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                }
        });
                    
           nextButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            
               
         try {if (userTextbox.getText().length()== 0 ||userTextbox.getText().contains(" ") || Character.isDigit( userTextbox.getText().charAt(0))){
                        Parent root = new ErrorUsername(stage);
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();}
             else{
                         DbHandle data = new DbHandle();
                           username = userTextbox.getText();
                        if (data.CheckUsername(username.toLowerCase())){
                            Alert alert = new Alert(AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation Dialog");
                            alert.setHeaderText("Username Confirmation");
                            alert.setContentText("Username Already Exists\n Would do like to Continue?");
                            Optional<ButtonType> result = alert.showAndWait();
                                 if (result.get() == ButtonType.OK){
                                 Parent root = new ChooseGameModeScreen(stage);
                                    Scene scene = new Scene(root);
                                    stage.setScene(scene);
                                    stage.show();}
                               else {
                                     Parent root = new UsernameScreen(stage);
                                     Scene scene = new Scene(root);
                                     stage.setScene(scene);
                                     stage.show();
                            }}
                        
                        else{
                          
                            data.Insert("users","username",userTextbox.getText());
                            Parent root = new ChooseGameModeScreen(stage);
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                                } }
                } catch (SQLException ex) {
                    Logger.getLogger(UsernameScreen.class.getName()).log(Level.SEVERE, null, ex);
                } 
                   
                
            }
        });
         
        
        
    }
}
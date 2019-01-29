/*
Main  File
 */
package tictacgui;

import java.net.URL;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Miramar
 */
public class TicTacGui extends Application {
    public static MediaPlayer gameMusic;

    @Override
    public void start(Stage stage) throws Exception {
        //Creating mediaplayer for setting the game music
        final URL resource = getClass().getResource("/music/Komiku.mp3");
        final Media media = new Media(resource.toString());
        gameMusic = new MediaPlayer(media);
        gameMusic.play(); //playing the music
        gameMusic.setOnEndOfMedia(new Runnable() {
            public void run() {
                //setting the media to play on an infinite loop
                gameMusic.seek(Duration.ZERO);
            }
        });
        //starting the main stage
        Parent root = new HomeScreen(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

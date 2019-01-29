/*
Abstract Class for all board games
 */
package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mahy
 */
public abstract class Game {

    protected Board gameBoard; //game board 
    public final static int PLAYER_ONE = 1;
    public final static int PLAYER_TWO = 2;
    protected int currentTurn;
    protected static FilesHandler saveGame; //file handler reference in case the recording mode was on

    public void setCurrentTurn(int turn) {
        this.currentTurn = turn;
    }

    public int getCurrentTurn() {
        return this.currentTurn;
    }

    public Board getGameBoard() {
        return gameBoard;
    }
    //overriden according to each board game logic
    public abstract int checkBoardforWinner();

    //closing the PrintWriter 
    public void endRecording() {
        saveGame.closeWriterBuffer();
        deleteInvalidFile();
    }

    //saving game move in case of int or string
    public void recordMove(int index) {
        saveGame.saveIntegerElementInFile(index);
    }

    public void recordMove(String strIndex) {
        int intIndex = Integer.parseInt(strIndex);
        saveGame.saveIntegerElementInFile(intIndex);
    }

    //restarting the recording in case the recording mode is on
    public void restartGameRecording() throws FileNotFoundException {
        endRecording();
        saveGame = new FilesHandler(FileMode.WRITE);
        saveGame.saveIntegerElementInFile(currentTurn);
    }

    //verfirying the name of the file according to the timestamp format
    public static boolean verifyFileContent(File file) {
        String fileName = file.getName();
        fileName = fileName.substring(0, fileName.length() - 4);
        if (FileNameMatcher.matches(fileName)) {
            return true;
        }
        return false;
    }

    //arraylist holding the saved game moves
    public static ArrayList replayGame(File file) throws FileNotFoundException, IOException {
        saveGame = new FilesHandler(file, FileMode.READ);
        ArrayList<Integer> moves = saveGame.readElementsFromFile();
        saveGame.closeReaderBuffer();
        return moves;

    }
    
    /*
    deleting incomplete game
    */
    private void  deleteInvalidFile(){
        if(saveGame.countFileItems() < 6){
            System.out.println(saveGame.countFileItems());
            saveGame.getFile().delete();
        }
    }

}

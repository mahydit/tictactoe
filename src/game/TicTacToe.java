/*
 This is the Tic Tac Toe class which implements the Game class (for any board game
 */
package game;

import java.io.FileNotFoundException;

/**
 *
 * @author Mahy
 */
public class TicTacToe extends Game{

    public TicTacToe(int row, int col) {
        this.gameBoard = new Board(row, col);
    }

    public TicTacToe(int row, int col, int currentTurn) {
        this.gameBoard = new Board(row, col);
        this.currentTurn = currentTurn;
    }
    
    //this constructor is used when the recording mode is on
    public TicTacToe(int row, int col, int currentTurn, RecordGameMode replayMode) throws FileNotFoundException {
        this.gameBoard = new Board(row, col);
        this.currentTurn = currentTurn;
        if(replayMode == RecordGameMode.RECORD)
        {
            saveGame= new FilesHandler(FileMode.WRITE);
            saveGame.saveIntegerElementInFile(currentTurn);
        }
    }

    private char getPlayerToken() {
        char token = 0;
        switch (currentTurn) {
            case (PLAYER_ONE):
                token = 'X';
                break;
            case (PLAYER_TWO):
                token = 'O';
                break;
        }
        return token;
    }
    
    //Checking for winner according to the rules of Tic Tac Toe
    @Override
    public int checkBoardforWinner() {
        char token = getPlayerToken();
        int winner = 0;
        if ((gameBoard.getSlotToken(0) == token && gameBoard.getSlotToken(1) == token && gameBoard.getSlotToken(2) == token)) {
            winner = currentTurn;
        } else if ((gameBoard.getSlotToken(3) == token && gameBoard.getSlotToken(4) == token && gameBoard.getSlotToken(5) == token)) {
            winner = currentTurn;
        } else if ((gameBoard.getSlotToken(6) == token && gameBoard.getSlotToken(7) == token && gameBoard.getSlotToken(8) == token)) {
            winner = currentTurn;
        } else if ((gameBoard.getSlotToken(0) == token && gameBoard.getSlotToken(3) == token && gameBoard.getSlotToken(6) == token)) {
            winner = currentTurn;
        } else if ((gameBoard.getSlotToken(1) == token && gameBoard.getSlotToken(4) == token && gameBoard.getSlotToken(7) == token)) {
            winner = currentTurn;
        } else if (gameBoard.getSlotToken(2) == token && gameBoard.getSlotToken(5) == token && gameBoard.getSlotToken(8) == token) {
            winner = currentTurn;
        } else if (gameBoard.getSlotToken(0) == token && gameBoard.getSlotToken(4) == token && gameBoard.getSlotToken(8) == token) {
            winner = currentTurn;
        } else if (gameBoard.getSlotToken(2) == token && gameBoard.getSlotToken(4) == token && gameBoard.getSlotToken(6) == token) {
            winner = currentTurn;
        } else {
            if (gameBoard.isBoardFull()) {
                winner = -1;
            }
        }
        return winner;
    }

}

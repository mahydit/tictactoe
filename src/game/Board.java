/*

 */
package game;

/**
 *
 * @author Miramar
 */
public class Board {

    private final int rows;
    private final int cols;
    private char[] gameBoard;

    public Board() {
        cols = 0;
        rows = 0;

    }

    public Board(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        gameBoard = new char[rows * cols];

    }

    /**
     * getRows() function return number of rows in the game player choose
     */
    public int getRows() {
        return rows;
    }

    public int getSize() {
        return gameBoard.length;
    }

    public boolean isBoardEmpty() {
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * getCols() function return number of columns in the game player choose
     */
    public int getCols() {
        return cols;
    }

    /**
     * getBoard() function returns an array containing the tokens of the player
     */
    public void clearSlot(int index) {
        gameBoard[index] = 0;
    }

    public char[] getBoard() {
        return gameBoard;
    }

    /**
     * setBoardSlot() function used for setting token inside board take the
     * player token and the index of where to put token
     */
    public void setBoardSlot(char token, int index) {
        if (gameBoard.length > index) {
            gameBoard[index] = token;
        }

    }

    /**
     * isSlotEmpty() function used to check whether a slot in specific index is
     * empty or not
     */
    public boolean isSlotEmpty(int index) {
        if (gameBoard.length > index && (int) gameBoard[index] != 0) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * isBoardFull() function used to check whether board is full or not
     */
    public boolean isBoardFull() {
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i] == 0) {
                return false;
            }
        }
        return true;

    }

    /**
     * clearBoard() function used to clear board and initialize new one
     */
    public void clearBoard() {
        gameBoard = new char[rows * cols];
    }

    /**
     * getSlotToken() function
     */
    public char getSlotToken(int index) {
        return gameBoard[index];
    }
    //for debugging
    public void showEmptySlots(){
        for(int i=0; i<gameBoard.length;i++)
        {
            if(gameBoard[i]==0)
            {
                System.out.println(i);
            }
        }
            System.out.println("==================");
    }
    //fordebugging
    public void showFullBoard(){
        for(int i=0; i<gameBoard.length;i++)
        {
         
            System.out.println("index: "+i+" Token: "+ gameBoard[i]);
        }
            System.out.println("==================");
    }
}

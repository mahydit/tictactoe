/*
This class is concerned with the human player where it saves the move 
it gets from the GUI to the game board
 */
package game;

/**
 *
 * @author Mahy
 */
public class HumanPlayer {

    private String username;
    private int playersTurn;

    public HumanPlayer(int playersTurn) {
        this.playersTurn = playersTurn;
    }

    private char getToken() {
        char token = 0;
        switch (playersTurn) {
            case Game.PLAYER_ONE:
                token = 'X';
                break;
            case Game.PLAYER_TWO:
                token = 'O';
        }
        return token;
    }

    public void performMove(String index, Board b) { //adding the HumanPlayer move to the game board
        int position = Integer.parseInt(index);
        char token = getToken();
        b.setBoardSlot(token, position);
    }
}

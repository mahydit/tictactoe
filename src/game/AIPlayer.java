/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Vector;

/**
 *
 * @author Mahy
 */
public class AIPlayer {

    private final int AI_PLAYER=Game.PLAYER_ONE;
    private final int HUMAN_PLAYER=Game.PLAYER_TWO;
    private GameLevel level;

    public AIPlayer(GameLevel level) {
//        init(playersTurn);
        this.level = level;
    }
// remove O's turn and set ai and human to final
//    public void init(int playersTurn) {
//        //intializa AI Player
//        switch (playersTurn) {
//            case 1:
//                ai_player = 1;
//                human_player = 2;
//                break;
//            case 2:
//                ai_player = 2;
//                human_player = 1;
//                break;
//
//        }
//    }

    public int performMove(Board b) {
        int index;
        if (level == GameLevel.EASY) {
            index = findFirstEmptySlot(b);
        } else {
            if (b.isBoardEmpty()) {
                index = (int) (Math.random() * 9);
            } else {
                index = getBestMove(b, AI_PLAYER).index;
            }
            b.setBoardSlot(getToken(AI_PLAYER), index);
        }

        return index;
    }

    private char getToken(int currentTurn) {
        if (currentTurn == AI_PLAYER) {
            return 'X';
        } else {
            return 'O';
        }
    }

    private int findFirstEmptySlot(Board b) {
        boolean emptySlotFound = false;
        int randomIndex;
        do {
            randomIndex = (int) (Math.random() * 9);
            if (b.isSlotEmpty(randomIndex)) {
                b.setBoardSlot(getToken(AI_PLAYER), randomIndex);
                emptySlotFound = true;

            }
        } while (!emptySlotFound);
        return randomIndex;
    }

    private class AIMove {

        public int index;
        public int score;

        AIMove() {
        }

        AIMove(int score) {
            this.score = score;
        }
    }

    private int checkWinner(Board gameBoard, int currentTurn) {
        char token = getToken(currentTurn);
//        if (currentTurn == 1) {
//            token = 'X';
//        } else {
//            token = 'O';
//        }

        if ((gameBoard.getSlotToken(0) == token && gameBoard.getSlotToken(1) == token && gameBoard.getSlotToken(2) == token)) {
            return currentTurn;
        } else if ((gameBoard.getSlotToken(3) == token && gameBoard.getSlotToken(4) == token && gameBoard.getSlotToken(5) == token)) {
            return currentTurn;
        } else if ((gameBoard.getSlotToken(6) == token && gameBoard.getSlotToken(7) == token && gameBoard.getSlotToken(8) == token)) {
            return currentTurn;
        } else if ((gameBoard.getSlotToken(0) == token && gameBoard.getSlotToken(3) == token && gameBoard.getSlotToken(6) == token)) {
            return currentTurn;
        } else if ((gameBoard.getSlotToken(1) == token && gameBoard.getSlotToken(4) == token && gameBoard.getSlotToken(7) == token)) {
            return currentTurn;
        } else if (gameBoard.getSlotToken(2) == token && gameBoard.getSlotToken(5) == token && gameBoard.getSlotToken(8) == token) {
            return currentTurn;
        } else if (gameBoard.getSlotToken(0) == token && gameBoard.getSlotToken(4) == token && gameBoard.getSlotToken(8) == token) {
            return currentTurn;
        } else if (gameBoard.getSlotToken(2) == token && gameBoard.getSlotToken(4) == token && gameBoard.getSlotToken(6) == token) {
            return currentTurn;
        } else {
            //check ties
            if (gameBoard.isBoardFull()) {
                return 0;
            }

        }
        return -1;
    }

    private AIMove getBestMove(Board b, int player) {
        int rv = checkWinner(b, player);
        switch (rv) {
            case AI_PLAYER:
                //            System.out.println("10");
                return new AIMove(10);
            case HUMAN_PLAYER:
                //            System.out.println("-10");
                return new AIMove(-10);
            case 0:
                //            System.out.println("0");
                return new AIMove(0);
            default:
                break;
        }

        Vector<AIMove> movesList = new Vector<>();

        for (int i = 0; i < b.getSize(); i++) {
            if (b.getSlotToken(i) == 0) {
//                System.out.println("true");
                AIMove move = new AIMove();
                move.index = i;
                b.setBoardSlot(getToken(player), i);
//                if (player == AI_PLAYER) {
//                    b.setBoardSlot('X', i);
//                } else {
//                    b.setBoardSlot('O', i);
//                }
                if (player == AI_PLAYER) {
                    move.score = getBestMove(b, HUMAN_PLAYER).score;
                } else {
                    move.score = getBestMove(b, AI_PLAYER).score;
                }
                movesList.add(move);
                b.clearSlot(i);
            }
        }
        AIMove bestMove = new AIMove();
        if (player == AI_PLAYER) {
            int bestScore = -100000;
            for (AIMove move : movesList) {
                if (move.score > bestScore) {
                    bestMove = move;
                    bestScore = move.score;
                }
            }
        } else {
            int bestScore = 100000;
            for (AIMove move : movesList) {
                if (move.score < bestScore) {
                    bestMove = move;
                    bestScore = move.score;
                }
            }
        }
        return bestMove;
    }
}
//        int randomIndex = (int) Math.random()*9;
//        
//        for (int i =0; i<b.getSize();i++)
//        {
//            if(b.isSlotEmpty(i))
//            {
//                b.setBoardSlot(getToken(), i);
//                break;
//            }
//        }

//}
//}

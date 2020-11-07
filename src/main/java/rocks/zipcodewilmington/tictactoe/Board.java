package rocks.zipcodewilmington.tictactoe;


import java.util.*;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Character[][] board;

    public Board(Character[][] matrix) {  //an array of arrays aka tic-tac-toe board
        this.board = matrix;
    }

    public Boolean isInFavorOfX() {
        return isInFavorOf('X');
    }

    public Boolean isInFavorOfO() {
        return isInFavorOf('O');
    }

    public Boolean isInFavorOf(Character characterToEvaluate) {
        for (int rowOrColumn = 0; rowOrColumn < board.length; rowOrColumn++) {
            Character leftChar = board[rowOrColumn][0];
            Character midChar = board[rowOrColumn][1];
            Character rightChar = board[rowOrColumn][2];
            if (leftChar.equals(characterToEvaluate) &&
                    midChar.equals(characterToEvaluate) &&
                    rightChar.equals(characterToEvaluate)) {
                return true;
            }

            Character upperChar = board[0][rowOrColumn];
            Character middleChar = board[1][rowOrColumn];
            Character lowerChar = board[2][rowOrColumn];
            if (upperChar.equals(characterToEvaluate) &&
                    middleChar.equals(characterToEvaluate) &&
                    lowerChar.equals(characterToEvaluate)) {
                return true;
            }

            Character topLeft = board[0][0];
            Character middle = board[1][1];
            Character bottomRight = board[2][2];
            if (topLeft.equals(characterToEvaluate) &&
                    middle.equals(characterToEvaluate) &&
                    bottomRight.equals(characterToEvaluate)) {
                return true;
            }

            Character topRight = board[0][2];
            Character bottomLeft = board[0][2];
            if (topRight.equals(characterToEvaluate) &&
                    middle.equals(characterToEvaluate) &&
                    bottomLeft.equals(characterToEvaluate)) {
                return true;
            }
        }
        return false;
    }

    public Boolean isTie() {
        boolean bothWinners = isInFavorOfO() && isInFavorOfX();
        boolean bothLosers = (!isInFavorOfO()) && (!isInFavorOfX());
        boolean isTie = bothWinners || bothLosers;
        if (isTie) {
            return true;
        }
        return false;
    }

    public String getWinner() {
        if (isTie()) {
            return "";
        }
        if (isInFavorOfX()) {
            return "X";
        } else {
            return "O";
        }
    }

}

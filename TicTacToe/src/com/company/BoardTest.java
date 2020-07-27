package com.company;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board();
    Main m = new Main();
    @org.junit.jupiter.api.Test
    void determinePosition() {
        assertEquals(6, board.determinePosition(2,3));
        assertFalse(board.determinePosition(2,3) == 4);
        assertEquals(7, board.determinePosition(3,1));
        assertFalse(board.determinePosition(2,3) == 5);
        assertEquals(8, board.determinePosition(3,2));
        assertFalse(board.determinePosition(3,2) == 6);
        assertEquals(9, board.determinePosition(3,3));
        assertFalse(board.determinePosition(3,3) == 4);


        if (m.playerTurn(true) == 'X' &&  board.determinePosition(1,1) == 1) {
            assertEquals(' ', board.row1.charAt(1));
        }

        if(m.playerTurn(true) == 'X' && board.determinePosition(1,2) == 2){
            assertEquals(' ', board.row1.charAt(5));
        }

        if( m.playerTurn(true) == 'X' && board.determinePosition(1,3) == 3){
            assertEquals(' ', board.row1.charAt(9));
        }

        if(m.playerTurn(false) == 'O' && board.determinePosition(2,1) == 4){
            assertEquals(' ', board.row1.charAt(1));
        }

        if(m.playerTurn(false) == 'O' && board.determinePosition(2,2) == 5){
            assertEquals(' ', board.row1.charAt(5));
        }

    }
    @org.junit.jupiter.api.Test
    void printBoard() {
        assertEquals(board.row1, board.sec1 + "|" + board.sec2 + "|" + board.sec3);
        assertEquals(board.row3, board.sec4 + "|" + board.sec5 + "|" + board.sec6);
        assertEquals(board.row5, board.sec7 + "|" + board.sec8 + "|" + board.sec9);
        assertEquals(board.row2, "-----------");
        assertFalse(board.row3 == board.sec4 + "|" + board.sec5 + "|" + board.sec6);
        assertFalse(board.row1 == board.sec7 + "|" + board.sec8 + "|" + board.sec9);
        assertFalse(board.row2 == board.sec1 + "|" + board.sec2 + "|" + board.sec3);
    }

    @org.junit.jupiter.api.Test
    void printError() {
        //assertFalse(board.printError(1,1) == "This move at (" + 2 + "," + 2 + ") is not valid. Try again...");
       // assertFalse(board.printError(2,3) == "This move at (" + 2 + "," + 3 + ") is not valid. Try again...");
       // assertFalse(board.printError(1,5) == "This move at (" + 1 + "," + 1 + ") is not valid. Try again...");
       // assertFalse(board.printError(2,9) == "This move at (" + 2 + "," + 1 + ") is not valid. Try again...");

       // if (m.playerTurn(false) == 'O' && board.determinePosition(1,3) == 3 && board.validatePosition(3)) {
         //   assertEquals("This move at (" + 1 + "," + 3 + ") is not valid. Try again...", board.printError(1,3));
        //}
    }
}

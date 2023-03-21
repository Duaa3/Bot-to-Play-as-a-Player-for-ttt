package com.TicTacToeGame.TTTGame.model;

public class Board {
    private String[] board; // a private array of strings called "board"

    public Board() {
        // empty constructor (does nothing)
    }

    public Board(String[] board) {
        this.board = board; // constructor that initializes "board" with an array passed as a parameter
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }
}

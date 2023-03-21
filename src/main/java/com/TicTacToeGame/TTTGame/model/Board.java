package com.TicTacToeGame.TTTGame.model;

public class Board {
    private String[] board;

    public Board() {
    }

    public Board(String[] board) {
        this.board = board;
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }
}

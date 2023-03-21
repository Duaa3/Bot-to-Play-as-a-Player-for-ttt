package com.TicTacToeGame.TTTGame.model;




public class BotResponse {
    // Declare a private instance variable "move" of type integer
    private int move;
    // Constructor that takes an integer parameter "move"
    public BotResponse(int move) {
        // Set the value of the "move" instance variable to the parameter value
        this.move = move;
    }
    // Getter method to return the value of the "move" instance variable

    public int getMove() {
        return move;
    }

    // Setter method to set the value of the "move" instance variable
    public void setMove(int move) {
        this.move = move;
    }
}

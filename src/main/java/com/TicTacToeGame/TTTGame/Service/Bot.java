package com.TicTacToeGame.TTTGame.Service;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class Bot {
    private Random rand;

    public Bot() {
        rand = new Random();
    }

    public int makeRandomMove(String[] board) {
        int size = (int) Math.sqrt(board.length);
        int randomIndex;
        do {
            // generate random row and column indices
            int row = rand.nextInt(size);
            int col = rand.nextInt(size);
            // calculate the index in the 1D array
            randomIndex = row * size + col;
        } while (board[randomIndex] != ""); // keep generating new random indices until an empty cell is found
        return randomIndex;
    }
}


package com.TicTacToeGame.TTTGame.Controller;

import com.TicTacToeGame.TTTGame.Service.Bot;
import com.TicTacToeGame.TTTGame.model.Board;
import com.TicTacToeGame.TTTGame.model.BotResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController // Specifies that this class is a REST controller
@RequestMapping( "/bot") // Maps requests to /bot endpoint
@CrossOrigin(origins = "*", allowedHeaders = "*")// Enables Cross-Origin Resource Sharing (CORS) for this endpoint
public class BotController {
    @Autowired // Automatically injects a dependency of type Bot into this class
    public Bot bot;

    // Maps GET requests to /bot/move endpoint with a query parameter of board
    @GetMapping("/move")
    public ResponseEntity<BotResponse> makeMove(@RequestParam String[] board) {
        for(String elem: board){ // Loops through each element in the board array and prints it
            System.out.println(elem);
        }
        // Calls the makeRandomMove method of the Bot class and returns a BotResponse object with the result
        return ResponseEntity.ok(new BotResponse(bot.makeRandomMove(board)));
    }
}





package com.TicTacToeGame.TTTGame.Controller;

import com.TicTacToeGame.TTTGame.Service.Bot;
import com.TicTacToeGame.TTTGame.model.Board;
import com.TicTacToeGame.TTTGame.model.BotResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping( "/bot")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BotController {
    @Autowired
    public Bot bot;

    @GetMapping("/move")
    public ResponseEntity<BotResponse> makeMove(@RequestParam String[] board) {
        for(String elem: board){
            System.out.println(elem);
        }
        return ResponseEntity.ok(new BotResponse(bot.makeRandomMove(board)));
    }
}





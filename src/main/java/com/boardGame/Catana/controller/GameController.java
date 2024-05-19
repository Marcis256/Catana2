package com.boardGame.Catana.controller;

import com.boardGame.Catana.model.BoardModel;
import com.boardGame.Catana.model.Player;
import com.boardGame.Catana.model.SettlementPlaces;
import com.boardGame.Catana.service.BoardModelService;
import com.boardGame.Catana.service.CardService;
import com.boardGame.Catana.service.GameService;
import com.boardGame.Catana.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:3000")
public class GameController {
    @Autowired
    PlayerService playerService;
    @Autowired
    CardService cardService;
    @Autowired
    private GameService gameService;
    @Autowired
    private BoardModelService boardModelService;

    @GetMapping("/board")
    public List<BoardModel> getAllBoardModel() {
        return boardModelService.getAllBoard();
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping("/players")
    public Player createNewPlayer(@RequestBody Player player) throws Exception {
        return playerService.createNewPlayer(player);
    }

    @PostMapping("/board")
    public String createNewBoarders() throws Exception {
        return boardModelService.createBoard();
    }

    @PutMapping("/roll-dice")
    public ResponseEntity<String> rollDice() {
        try {
            gameService.processDiceRoll();
            return ResponseEntity.ok("Dice rolled successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error rolling dice: " + e.getMessage());
        }
    }

    @PutMapping("/players/{id}/addSettlement")
    public ResponseEntity<Player> addSettlementToPlayer(@PathVariable("id") long id, @RequestBody SettlementPlaces settlementPlaces) {
        try {
            Player updatedPlayer = playerService.addSettlement(id, settlementPlaces);
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/settlement-places")
    public List<SettlementPlaces> getAllSettlementPlaces() {
        return playerService.getAllSettlementPlaces();
    }
}

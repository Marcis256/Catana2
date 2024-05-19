package com.boardGame.Catana.service;

import com.boardGame.Catana.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired PlayerService playerService;
    @Autowired CardService cardService;


    // Uzmet kauliņu, un skatās kam māja ir un iedod resursu atbilstošos ja ir
    public void processDiceRoll() throws Exception {
        List<Player> playerList = playerService.getAllPlayers();
        DiceNumber dice = DiceNumber.NINE;

        for(Player player : playerList) {
            for(SettlementPlaces playerSet : player.getSettlementPlaces()) {
                for(Board board : playerSet.getBoards()) {
                    DiceNumber diceNumber = board.getDiceNumber();
                    if(dice == diceNumber) {
                        long playerId = player.getId();
                        cardService.updateCardForPlayer(playerId, board.getTileType().toString());
                    }
                }
            }
        }
    }
}

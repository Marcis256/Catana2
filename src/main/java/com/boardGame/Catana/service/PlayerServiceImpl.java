package com.boardGame.Catana.service;

import com.boardGame.Catana.model.Card;
import com.boardGame.Catana.model.Player;
import com.boardGame.Catana.model.SettlementPlaces;
import com.boardGame.Catana.repostory.PlayerRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepostory playerRepostory;

    public Player createNewPlayer(Player player) throws Exception {
        player.setCards(new Card());
        return playerRepostory.save(player);
    }

    public ArrayList<Player> getAllPlayers() {
        return (ArrayList<Player>) playerRepostory.findAll();
    }

    public Player selectPlayerById(long id) throws Exception {
        if (playerRepostory.existsById(id)) {
            return playerRepostory.findById(id).get();
        } else {
            throw new Exception("Id nav pareizs");
        }
    }

    @Override
    public Player addSettlement(long id, SettlementPlaces settlementPlaces) throws Exception {
        if (playerRepostory.existsById(id)) {
            Player player = playerRepostory.findById(id).get();
            player.getSettlementPlaces().add(settlementPlaces);

            return playerRepostory.save(player);
        } else {
            throw new Exception("Id nav pareizs");
        }
    }

    public List<SettlementPlaces> getAllSettlementPlaces() {
        return playerRepostory.findAllSettlementPlaces();
    }
}

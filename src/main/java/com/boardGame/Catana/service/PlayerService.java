package com.boardGame.Catana.service;

import com.boardGame.Catana.model.Card;
import com.boardGame.Catana.model.Player;
import com.boardGame.Catana.model.SettlementPlaces;
import com.boardGame.Catana.model.TileType;
import com.boardGame.Catana.repostory.PlayerRepostory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public interface PlayerService {
    public Player createNewPlayer(Player player) throws Exception;
    public ArrayList<Player> getAllPlayers();
    public Player selectPlayerById(long id) throws Exception;
    public Player addSettlement(long id, SettlementPlaces settlementPlaces) throws Exception;
    public List<SettlementPlaces> getAllSettlementPlaces();
}

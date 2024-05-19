package com.boardGame.Catana.service;

import com.boardGame.Catana.model.Card;
import com.boardGame.Catana.model.Player;
import com.boardGame.Catana.model.TileType;

public interface CardService {

    public Card createNewCard(Card card) throws Exception;
    public Card updateCardById(long id, Card card) throws Exception;
    public Card findCardByPlayerId(Long playerId);
    public void updateCardForPlayer(Long playerId, String tileType) throws Exception;
}

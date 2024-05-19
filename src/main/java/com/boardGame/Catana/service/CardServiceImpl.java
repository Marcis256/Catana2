package com.boardGame.Catana.service;

import com.boardGame.Catana.model.Card;
import com.boardGame.Catana.model.Player;
import com.boardGame.Catana.model.TileType;
import com.boardGame.Catana.repostory.CardRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepostory cardRepostory;

    public Card createNewCard(Card card) throws Exception {
        return cardRepostory.save(card);
    }

    public Card updateCardById(long id, Card card) throws Exception {
        if(cardRepostory.existsById(id)) {
            Card cardRep = cardRepostory.findById(id).get();
            cardRep.setWood(card.getWood());
            cardRep.setGrain(card.getGrain());
            cardRep.setOre(card.getOre());
            cardRep.setSheep(card.getSheep());
            cardRep.setBrick(card.getBrick());

            cardRepostory.save(card);
            return card;
        } else {
            throw new Exception("Id nav pareizs");
        }
    }
    public Card findCardByPlayerId(Long playerId) {
        return cardRepostory.findByPlayerId(playerId);
    }

    public void updateCardForPlayer(Long playerId, String tileType) throws Exception {
        Card existingCard = cardRepostory.findByPlayerId(playerId);
        if (existingCard != null) {
            if(tileType == "ORE") {
                existingCard.setOre(existingCard.getOre() + 1);
            } else if (tileType == "BRICK") {
                existingCard.setBrick(existingCard.getBrick() + 1);
            } else if (tileType == "WOOD") {
                existingCard.setWood(existingCard.getWood() + 1);
            } else if (tileType == "GRAIN") {
                existingCard.setGrain(existingCard.getGrain() + 1);
            } else if (tileType == "SHEEP") {
                existingCard.setSheep(existingCard.getSheep() + 1);
            }

            // Save the updated card
            cardRepostory.save(existingCard);
        } else {
            throw new Exception("Id nav pareizs");
        }
    }

/*    public Card addCardToPlayer(Player player, TileType tileType) {
        Card playerCards = player.getCards();
        if(tileType == TileType.ORE) {
            playerCards.setOre(playerCards.getOre() + 1);
        } else if (tileType == TileType.BRICK) {
            playerCards.setBrick(playerCards.getBrick() + 1);
        } else if (tileType == TileType.WOOD) {
            playerCards.setWood(playerCards.getWood() + 1);
        } else if (tileType == TileType.GRAIN) {
            playerCards.setGrain(playerCards.getGrain() + 1);
        } else if (tileType == TileType.SHEEP) {
            playerCards.setSheep(playerCards.getSheep() + 1);
        }
        return playerCards;
    }*/
}

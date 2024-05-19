package com.boardGame.Catana.service;

import com.boardGame.Catana.model.Board;
import com.boardGame.Catana.model.BoardModel;
import com.boardGame.Catana.model.DiceNumber;
import com.boardGame.Catana.model.TileType;
import com.boardGame.Catana.repostory.BorderModelRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardModelServiceImpl implements BoardModelService {

    @Autowired
    BorderModelRepostory borderModelRepostory;

    public String createBoard() {
        BoardModel board_1 = new BoardModel(TileType.ORE, DiceNumber.TWELVE);
        BoardModel board_2 = new BoardModel(TileType.BRICK,DiceNumber.NINE);
        BoardModel board_3 = new BoardModel(TileType.WOOD,DiceNumber.TEN);
        BoardModel board_4 = new BoardModel(TileType.SHEEP,DiceNumber.ELEVEN);
        BoardModel board_5 = new BoardModel(TileType.GRAIN,DiceNumber.SIX);
        BoardModel board_6 = new BoardModel(TileType.WOOD,DiceNumber.FIVE);
        BoardModel board_7 = new BoardModel(TileType.SHEEP,DiceNumber.EIGHT);
        BoardModel board_8 = new BoardModel(TileType.SHEEP,DiceNumber.FOUR);
        BoardModel board_9 = new BoardModel(TileType.GRAIN,DiceNumber.THREE);
        BoardModel board_10 = new BoardModel(TileType.GRAIN,DiceNumber.ELEVEN);
        BoardModel board_11 = new BoardModel(TileType.GRAIN,DiceNumber.FOUR);
        BoardModel board_12 = new BoardModel(TileType.WOOD,DiceNumber.THREE);
        BoardModel board_13 = new BoardModel(TileType.BRICK,DiceNumber.EIGHT);
        BoardModel board_14 = new BoardModel(TileType.SHEEP,DiceNumber.TEN);
        BoardModel board_15 = new BoardModel(TileType.ORE,DiceNumber.NINE);
        BoardModel board_16 = new BoardModel(TileType.EMPTY,DiceNumber.ONE);
        BoardModel board_17 = new BoardModel(TileType.WOOD,DiceNumber.FIVE);
        BoardModel board_18 = new BoardModel(TileType.BRICK,DiceNumber.TWO);
        BoardModel board_19 = new BoardModel(TileType.ORE,DiceNumber.SIX);

        borderModelRepostory.save(board_1);
        borderModelRepostory.save(board_2);
        borderModelRepostory.save(board_3);
        borderModelRepostory.save(board_4);
        borderModelRepostory.save(board_5);
        borderModelRepostory.save(board_6);
        borderModelRepostory.save(board_7);
        borderModelRepostory.save(board_8);
        borderModelRepostory.save(board_9);
        borderModelRepostory.save(board_10);
        borderModelRepostory.save(board_11);
        borderModelRepostory.save(board_12);
        borderModelRepostory.save(board_13);
        borderModelRepostory.save(board_14);
        borderModelRepostory.save(board_15);
        borderModelRepostory.save(board_16);
        borderModelRepostory.save(board_17);
        borderModelRepostory.save(board_18);
        borderModelRepostory.save(board_19);

        return "ok";
    }

    public List<BoardModel> getAllBoard() {
        return borderModelRepostory.findAll();
    }
}

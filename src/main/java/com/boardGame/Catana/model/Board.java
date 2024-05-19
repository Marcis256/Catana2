package com.boardGame.Catana.model;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public enum Board {
    TILE_1(TileType.ORE,DiceNumber.TWELVE),
    TILE_2(TileType.BRICK,DiceNumber.NINE),
    TILE_3(TileType.WOOD,DiceNumber.TEN),
    TILE_4(TileType.SHEEP,DiceNumber.ELEVEN),
    TILE_5(TileType.GRAIN,DiceNumber.SIX),
    TILE_6(TileType.WOOD,DiceNumber.FIVE),
    TILE_7(TileType.SHEEP,DiceNumber.EIGHT),
    TILE_8(TileType.SHEEP,DiceNumber.FOUR),
    TILE_9(TileType.GRAIN,DiceNumber.THREE),
    TILE_10(TileType.GRAIN,DiceNumber.ELEVEN),
    TILE_11(TileType.GRAIN,DiceNumber.FOUR),
    TILE_12(TileType.WOOD,DiceNumber.THREE),
    TILE_13(TileType.BRICK,DiceNumber.EIGHT),
    TILE_14(TileType.SHEEP,DiceNumber.TEN),
    TILE_15(TileType.ORE,DiceNumber.NINE),
    TILE_16(TileType.EMPTY,DiceNumber.ONE),
    TILE_17(TileType.WOOD,DiceNumber.FIVE),
    TILE_18(TileType.BRICK,DiceNumber.TWO),
    TILE_19(TileType.ORE,DiceNumber.SIX);

    private TileType tileType;
    private DiceNumber diceNumber;

    private Board(TileType tileType, DiceNumber diceNumber){
        this.tileType = tileType;
        this.diceNumber = diceNumber;
    }
}

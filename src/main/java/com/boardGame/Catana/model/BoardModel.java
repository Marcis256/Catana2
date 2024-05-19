package com.boardGame.Catana.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table
@Entity(name = "boardModel")
@Getter
@Setter
@NoArgsConstructor
public class BoardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "tileType")
    TileType tileType;
    @Column(name = "diceNumber")
    DiceNumber diceNumber;

    public BoardModel(TileType tileType, DiceNumber diceNumber){
        this.tileType = tileType;
        this.diceNumber = diceNumber;
    }
}

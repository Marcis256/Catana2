package com.boardGame.Catana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "player")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    String name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    Card cards;

    @Column(name = "points")
    int points = 0;

    @ElementCollection(targetClass = SettlementPlaces.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "player_settlement_places", joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "settlement_place")
    List<SettlementPlaces> settlementPlaces = new ArrayList<>();

    public Player(String name){
        this.name = name;
        this.cards = new Card();
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}

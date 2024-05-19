package com.boardGame.Catana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Table
@Entity(name = "card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "wood")
    int Wood = 0;
    @Column(name = "grain")
    int Grain = 0;
    @Column(name = "sheep")
    int Sheep = 0;
    @Column(name = "brick")
    int Brick = 0;
    @Column(name = "ore")
    int Ore = 0;

    @JsonIgnore
    @OneToOne(mappedBy = "cards")
    private Player player;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", Wood='" + Wood + '\'' +
                ", Sheep=" + Sheep +
                ", Ore=" + Ore +
                ", Grain=" + Grain +
                ", Brick=" + Brick +
                '}';
    }
}

package com.boardGame.Catana.repostory;

import com.boardGame.Catana.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepostory extends JpaRepository<Card, Long> {
    Card findByPlayerId(Long playerId);
}

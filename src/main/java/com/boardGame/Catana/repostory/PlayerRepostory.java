package com.boardGame.Catana.repostory;

import com.boardGame.Catana.model.Player;
import com.boardGame.Catana.model.SettlementPlaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepostory extends JpaRepository<Player, Long> {
    @Query("SELECT DISTINCT p.settlementPlaces FROM Player p")
    List<SettlementPlaces> findAllSettlementPlaces();
}

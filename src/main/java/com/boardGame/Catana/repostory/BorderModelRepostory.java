package com.boardGame.Catana.repostory;

import com.boardGame.Catana.model.BoardModel;
import com.boardGame.Catana.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorderModelRepostory extends JpaRepository<BoardModel, Long> {
}

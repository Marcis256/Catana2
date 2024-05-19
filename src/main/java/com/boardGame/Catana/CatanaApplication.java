package com.boardGame.Catana;

import com.boardGame.Catana.model.*;
import com.boardGame.Catana.repostory.CardRepostory;
import com.boardGame.Catana.repostory.PlayerRepostory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CatanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatanaApplication.class, args);

//		SetBoard setBoard = new SetBoard();
//		List<Board> boards = setBoard.getBoardList();
//
//		// Print the board values
//		for (Board board : boards) {
//			System.out.println(board.getDiceNumber());
//		}

		/*Player playerMarcis = new Player("Marcis");
		Player playerSanita = new Player("Sanita");
		PlayerList playerList = new PlayerList();
		
		playerList.getPlayerList().add(playerMarcis);
		playerList.getPlayerList().add(playerSanita);

		playerMarcis.getSettlementPlaces().add(SettlementPlaces.settlement_11);
		playerSanita.getSettlementPlaces().add(SettlementPlaces.settlement_44);

		DiceNumber dice = DiceNumber.EIGHT;

		for(Player player : playerList.getPlayerList()) {
			for(SettlementPlaces playerSet : player.getSettlementPlaces()) {
				for(Board board : playerSet.getBoards()) {
					DiceNumber diceNumber = board.getDiceNumber();
					if(dice == diceNumber) {
						player.getCards().addCardToPlayer(board.getTileType());

						System.out.println(player.getName() + " " + player.getCards().toString());
					}
				}
			}
		}*/
	}

	@Bean
	public CommandLineRunner saveData(CardRepostory cardRepostory, PlayerRepostory playerRepostory) {
		return(args)->{
			/*Card card = new Card();
			cardRepostory.save(card);
			Player player = new Player(card);
			player.getSettlementPlaces().add(SettlementPlaces.settlement_1);
			playerRepostory.save(player);


			Player task = playerRepostory.findById(player.getId()).get();
			task.getSettlementPlaces().add(SettlementPlaces.settlement_25);
			playerRepostory.save(task);
			System.out.println("abc " + playerRepostory.findById(task.getId()).get().getSettlementPlaces().get(0).getBoards().get(0).getTileType());
*/


			/*task.getSettlementPlaces().add(SettlementPlaces.settlement_1);
			task.getSettlementPlaces().add(SettlementPlaces.settlement_13);*/

			//System.out.println("abc " + task);


/*			Deck deck = new Deck();
			deckRepostory.save(deck);

			Card card1 = new Card(Suit.CLUB,Value.ACE,deck);
			Card card2 = new Card(Suit.DIAMOND,Value.EIGHT,deck);
			Card card3 = new Card(Suit.DIAMOND,Value.NINE,deck);
			Card card4 = new Card(Suit.DIAMOND,Value.TEN,deck);
			Card card5 = new Card(Suit.DIAMOND,Value.THREE,deck);
			Card card6 = new Card(Suit.DIAMOND,Value.TWO,deck);
			cardRepostory.saveAll(Arrays.asList(card1,card2,card3,card4,card5,card6));*/
		};
	}

	//Game start
	//for all player 2 reizes, vienu māju būvēt flag
	//for all player
	//kauliņš + resursi + (pirkšana + būvēšana) + gājiena beigas

}

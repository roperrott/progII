package juegoDeCartas;

public class Main {

	public static void main(String[] args) {
		String mazoPath = "./src/JsonsMazos/superheroes.json";

		RandomStrategy random = new RandomStrategy();
		AmbitiousStrategy ambitious = new AmbitiousStrategy();

		Player p1 = new Player("Lucho", ambitious);
		Player p2 = new Player("Rope", random);

		CardDeck cd1 = new CardDeck("MazoImportado");
		
		cd1.importCardDeck(mazoPath);
		
		System.out.println(cd1+"\n");
		
		Game g1 = new Game(p1, p2, cd1, 50, p1);
		
		PotionPercentage pot1 = new PotionPercentage("Fortalecedora", null, 20);
		PotionPercentage pot2 = new PotionPercentage("Forcalecedora Plus", null, 50);
		PotionPercentage pot3 = new PotionPercentage("Kriptonita", null, -25);
		PotionPercentage pot4 = new PotionPercentage("Reductor De Plomo", null, -55);
		PotionFixedValue pot5 = new PotionFixedValue("Quiero Vale Cuatro", null, 4);
		PotionFixedValue pot6 = new PotionFixedValue("Numero Magico", null, 23);
		PotionPercentage pot7 = new PotionPercentage("P.S.Fuerza", "fuerza", 20);
		PotionPercentage pot8 = new PotionPercentage("P.S.Peso", "peso", 20);
		Cocktail ct = new Cocktail ("Cocktail");
		Cocktail ct2 = new Cocktail("Cocktail Magico");
		
		ct.addPotion(pot2);
		ct.addPotion(pot7);
		
		ct2.addPotion(pot6);
		ct2.addPotion(ct);
		
		g1.addPotionToGame(pot1);
		g1.addPotionToGame(pot2);
		g1.addPotionToGame(pot3);
		g1.addPotionToGame(pot4);
		g1.addPotionToGame(pot5);
		g1.addPotionToGame(pot6);
		g1.addPotionToGame(pot7);
		g1.addPotionToGame(pot8);
		g1.addPotionToGame(ct);
		g1.addPotionToGame(ct2);
		
		g1.startGame();
		
		System.out.println(g1.getHistoryLog());

	}
					
}

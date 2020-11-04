package juegoDeCartas;

import potions.*;
import strategies.*;

public class Main {

	public static void main(String[] args) {
		String mazoPath = "./src/mazos/superheroes.json";

		StubbornStrategy stubborn = new StubbornStrategy("fuerza");
		RandomStrategy random = new RandomStrategy();
//		AmbitiousStrategy ambitious = new AmbitiousStrategy();

		Player p1 = new Player("Lucho", stubborn);
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
		
		PotionPercentage pot9 = new PotionPercentage("Fortalecedora", null, 15);
		PotionPercentage pot10 = new PotionPercentage("Forcalecedora Plus", null, 40);
		PotionPercentage pot11 = new PotionPercentage("Kriptonita", null, -40);
		PotionPercentage pot12 = new PotionPercentage("Reductor De Plomo", null, -80);
		PotionFixedValue pot13 = new PotionFixedValue("Quiero Vale Cuatro", null, 7);
		PotionFixedValue pot14 = new PotionFixedValue("Numero Magico", null, 10);
		PotionPercentage pot15 = new PotionPercentage("P.S.RPM", "RPM", 30);
		PotionPercentage pot16 = new PotionPercentage("P.S.cm3", "cm3", 30);
		
		Cocktail pot17 = new Cocktail ("Cocktail");
		Cocktail pot18 = new Cocktail("Cocktail Magico");
		
		pot17.addPotion(pot2);
		pot17.addPotion(pot7);
		
		pot18.addPotion(pot6);
		pot18.addPotion(pot17);

		g1.addPotionToGame(pot1);
		g1.addPotionToGame(pot2);
		g1.addPotionToGame(pot3);
		g1.addPotionToGame(pot4);
		g1.addPotionToGame(pot5);
		g1.addPotionToGame(pot6);
		g1.addPotionToGame(pot7);
		g1.addPotionToGame(pot8);
		g1.addPotionToGame(pot9);
		g1.addPotionToGame(pot10);
		g1.addPotionToGame(pot11);
		g1.addPotionToGame(pot12);
		g1.addPotionToGame(pot13);
		g1.addPotionToGame(pot14);
		g1.addPotionToGame(pot15);
		g1.addPotionToGame(pot16);
		g1.addPotionToGame(pot17);
		g1.addPotionToGame(pot18);
		
		g1.startGame();
		
		System.out.println(g1.getHistoryLog());

	}
					
}

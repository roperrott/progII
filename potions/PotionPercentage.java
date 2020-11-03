package potions;

public class PotionPercentage extends Potion {

	private int percentage;
	/* si es null el nombre aplica a todos los atributos */
	/* funciona tanto si incrementa o decrementa */
	public PotionPercentage(String name, String atrModifName, int percentage) {
		super(name, atrModifName);
		this.percentage = percentage;
	}

	@Override
	public int applyEffects(String atrName, int atrValue) {
		if (this.getAtrModifName() == null || this.getAtrModifName().equals(atrName)) {
			return atrValue + (atrValue*percentage/100);
		}
		else {
			return atrValue;
		}
	}


}

package potions;

public class PotionFixedValue extends Potion {

	private int value;
	/* si es null el nombre aplica a todos los atributos */
	public PotionFixedValue(String name, String atrModifName, int value) {
		super(name, atrModifName);
		this.value = value;
	}

	@Override
	public int applyEffects(String atrName, int atrValue) {
		if (this.getAtrModifName() == null || this.getAtrModifName().equals(atrName)) {
			return value;
		}
		else {
			return atrValue;
		}
	}

}

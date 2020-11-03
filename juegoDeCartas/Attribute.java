package juegoDeCartas;

public class Attribute implements Comparable<Attribute> {
	private String name;
	private int value;
	
	
	public Attribute(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}


	public int getValue() {
		return value;
	}

//	ver con seba mañana
	public void setValue(int value) {
		this.value = value;
	}

	public boolean equals(Object o1) {
		try {
			Attribute at1 = (Attribute) o1;
			return name.equals(at1.getName());
			
		}catch(Exception e){
			return false;
		}
		
	}
	
	@Override
	public int compareTo(Attribute at) {
		return this.value - at.getValue();
	}
	
	@Override
	public String toString() {
		return name+" "+value;
	}

	

}

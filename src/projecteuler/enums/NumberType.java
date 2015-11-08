package projecteuler.enums;


public enum NumberType {

	ALL(0), 
	ODD(1),
	EVEN(2);
	
	private final int value;

	NumberType(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static NumberType fromString(String value) {
		if (value != null) {
			for (NumberType numberType : values()) {
				if (value.equals(numberType.value)) {
					return numberType;
				}
			}
		}
		return null;
	}
}

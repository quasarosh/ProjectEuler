package projecteuler.enums;

/**
 * NumberType.java which contains enum value of number type, odd, even, or both. 
 *  
 * @author Rosh Lee
 *
 */

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

	/**
	 * This method is used to get NumberType enum value using integers among 0, 1, or 2 assigned above. 
	 * @param value
	 * @return
	 */
	public static NumberType fromInteger(int value) {
		for (NumberType numberType : values()) {
			if (value == numberType.value) {
				return numberType;
			}
		}
		return null;
	}
}

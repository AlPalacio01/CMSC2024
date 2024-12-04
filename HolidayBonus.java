
public class HolidayBonus {

	public static double[] calculateHolidayBonus(double[][] data, double highest, double otherStores, double lowest) {
		double[] bonus = new double[data.length];
		
		for(int i = 0; i < bonus.length; i++) {
			for(int k = 0; k < data[i].length; k++) {
				
				if (data[i][k] >= 0){
					
					double value = data[i][k];
					double highestCol = TwoDimRaggedArrayUtility.getHighestInColumn(data, k);
					double lowestCol = TwoDimRaggedArrayUtility.getLowestInColumn(data, k);
					
					if (value == highestCol) {
						bonus[i] += highest;
					} else if (value == lowestCol) {
						bonus[i] += lowest;
					} else {
						bonus[i] += otherStores;
					}	
				}
			}
		}
		return bonus;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data, double highest,double otherStores,double lowest) {
		double[] bonus = calculateHolidayBonus(data, highest, otherStores, lowest);
		double holidayBonusTotal = 0;
		
		for (int i = 0; i < bonus.length; i++) {
			holidayBonusTotal += bonus[i];
		}
		
		return holidayBonusTotal;
		
	}
}

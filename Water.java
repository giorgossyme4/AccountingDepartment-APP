public class Water extends FlatFeeAndUse {
	
	private double cubicMeters;
	private static final double price2 = 1;
	
	public Water() {
		super();
	}
	
	public Water(double code, String description, double pricePerConsumerUnit, String measurementUnit, double monthlyFee, double cubicMeters) {
		super(code, description, pricePerConsumerUnit, measurementUnit, monthlyFee);
		this.cubicMeters = cubicMeters;
	}
	
	public double getCubicMeters(){
		return cubicMeters;
	}
	
	public double getPricePerConsumerUnit() {
		return super.getPricePerConsumerUnit();
	}
	
	public double getMonthlyFee() {
		return super.getMonthlyFee();

	}
	
	public void setCubicMeters(double cubicMeters){
		
		this.cubicMeters = cubicMeters;
	}
	
	public void setPricePerConsumerUnit (double pricePerConsumerUnit){
		
		super.pricePerConsumerUnit = pricePerConsumerUnit;
	}
	
	public boolean WaterCounter(double cubicMeters) {
		if (cubicMeters < 100) {
			return true;
		} else {
			return false;
		}
	}
	
	public double water(double pricePerConsumerUnit, double monthlyFee, double cubicMeters) { 
		if ( WaterCounter(cubicMeters) == true ) {
			return monthlyFee + ( price2 * cubicMeters);
		} else {
			return monthlyFee + (pricePerConsumerUnit* cubicMeters);
		}
	}
	
	public String print() {
		return super.print() + "\t Cubic meters: " +getCubicMeters();
	}
	
}
	
	
	
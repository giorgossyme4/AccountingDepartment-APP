public class FlatFeeAndUse extends spending {
	
	protected double pricePerConsumerUnit;
	private String measurementUnit;
	private double monthlyFee;
	
	public FlatFeeAndUse() {
		super();
	}
	
	public FlatFeeAndUse(double code, String description, double pricePerConsumerUnit, String measurementUnit, double monthlyFee) {
		super(code, description);
		this.pricePerConsumerUnit = pricePerConsumerUnit;
		this.measurementUnit = measurementUnit;
		this.monthlyFee = monthlyFee;
	}
	
	public double getPricePerConsumerUnit() {
		return this.pricePerConsumerUnit;
	}
	
	public double getMonthlyFee() {
		return this.monthlyFee;

	}
	
	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	public String getMeasurementUnit() {
		return this.measurementUnit;
	}
	
	public void setPricePerConsumerUnit(double pricePerConsumerUnit){
		this.pricePerConsumerUnit = pricePerConsumerUnit;
	}
	
	public void setMeasurementUnit(String measurementUnit){
		this.measurementUnit = measurementUnit;
	}
	
	
	public String print() {
		return super.print() + "\t Price per consume unit: " + getPricePerConsumerUnit()+ "\t Measurement unit: "+ getMeasurementUnit() +"\t Monthly fee: "+getMonthlyFee();
	}
}

			
			